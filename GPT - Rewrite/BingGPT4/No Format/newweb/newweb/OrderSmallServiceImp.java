package com.newweb.service.business.imp;

import com.newweb.dao.business.OrderSmallDao;
import com.newweb.model.base.Small;
import com.newweb.model.business.Order;
import com.newweb.model.business.OrderPrice;
import com.newweb.model.business.OrderSmall;
import com.newweb.service.base.SmallService;
import com.newweb.service.business.OrderPriceService;
import com.newweb.service.business.OrderService;
import com.newweb.service.business.OrderSmallService;
import com.newweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service("orderSmallService")
public class OrderSmallServiceImp implements OrderSmallService {

    private final OrderSmallDao orderSmallDao;
    private final OrderService orderService;
    private final SmallService smallService;
    private final OrderPriceService orderPriceService;

    @Autowired
    public OrderSmallServiceImp(OrderSmallDao orderSmallDao, OrderService orderService, SmallService smallService, OrderPriceService orderPriceService) {
        this.orderSmallDao = orderSmallDao;
        this.orderService = orderService;
        this.smallService = smallService;
        this.orderPriceService = orderPriceService;
    }

    @Override
    public boolean save(OrderSmall os) {
        OrderPrice op = new OrderPrice();
        op.setOrder(os.getOrder());
        op.setProductID(os.getSmall().getID());
        op.setType("small");
        double price = smallService.findSmallByIdBindCut(os.getSmall().getID(), os.getOrder().getCustomer().getID(), null).getLsprice();
        op.setPrice(price);
        if (!orderPriceService.save(op)) {
            logError("数据保存异常", "t_orderprice", os.getOrder().getID(), os.getSmall().getID(), "small", price);
        }
        Small small = os.getSmall();
        small.setBuycount(small.getBuycount() + 1);
        smallService.modify(small);
        return orderSmallDao.insert(os) > 0;
    }

    @Override
    public List<Map<String, Object>> queryOrderSmallASmallByOrderID(String orderID) {
        Order order = orderService.findOrderById(orderID);
        List<Map<String, Object>> oslist = new ArrayList<>();
        if (order != null) {
            for (OrderSmall os : order.getOrderSmalls()) {
                if (os.getCount() == 0) {
                    remove(os);
                    continue;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("count", os.getCount());
                map.put("small", smallService.findSmallByIdBindCut(os.getSmall().getID(), order.getCustomer().getID(), orderID));
                map.put("operation", os.getOperation());
                oslist.add(map);
            }
        }
        return oslist;
    }

    @Override
    public OrderSmall findOrderSmallById(int ID) {
        return orderSmallDao.selectOrderSmallById(ID);
    }

    @Override
    public boolean remove(OrderSmall os) {
        OrderPrice op = orderPriceService.findOrderPriceByCondition("small", os.getSmall().getID(), os.getOrder().getID());
        if (!orderPriceService.remove(op)) {
            logError("数据删除异常", "t_orderprice", op.getID());
        }
        return orderSmallDao.delete(os);
    }

    @Override
    public boolean modify(OrderSmall os) {
        OrderPrice op = orderPriceService.findOrderPriceByCondition("small", os.getSmall().getID(), os.getOrder().getID());
        double price = smallService.findSmallByIdBindCut(os.getSmall().getID(), os.getOrder().getCustomer().getID(), os.getOrder().getID()).getLsprice();
        op.setPrice(price);
        if (!orderPriceService.save(op)) {
            logError("数据保存异常", "t_orderprice", os.getOrder().getID(), os.getSmall().getID(), "small", price);
        }
        return orderSmallDao.update(os);
    }

    private void logError(String message, String table, Object... details) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append("\t").append(new Date());
        sb.append("\n目标表：").append(table).append("\n");
        for (int i = 0; i < details.length; i += 2) {
            sb.append(details[i]).append(":").append(details[i + 1]).append("\n");
        }
        sb.append("\n");
        FileUtil.writeTextToTextFile(sb.toString(), "log" + File.separator + "database", "record.txt", true);
        JOptionPane.showConfirmDialog(null,
                "警告，小件订单价格保存失败，请查看" + "log" + File.separator + "database" +
                        File.separator + "record.txt", "系统消息",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }

}
