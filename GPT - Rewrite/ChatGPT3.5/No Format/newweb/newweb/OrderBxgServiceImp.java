package com.newweb.service.business.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringBuilder;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.business.OrderBxgDao;
import com.newweb.model.base.Bxg;
import com.newweb.model.business.Order;
import com.newweb.model.business.OrderBxg;
import com.newweb.model.business.OrderPrice;
import com.newweb.service.base.BxgService;
import com.newweb.service.business.OrderBxgService;
import com.newweb.service.business.OrderPriceService;
import com.newweb.service.business.OrderService;
import com.newweb.util.FileUtil;

@Component("orderBxgService")
public class OrderBxgServiceImp {

    @Autowired
    private OrderBxgDao orderBxgDao;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BxgService bxgService;
    @Autowired
    private OrderPriceService orderPriceService;

    @Override
    public boolean save(OrderBxg ob) {
        OrderPrice op = createOrderPrice(ob);
        handleOrderPriceSaveFailure(op);
        updateBxgBuyCount(ob);
        return orderBxgDao.insert(ob) > 0;
    }

    @Override
    public List<Map<String, Object>> queryOrderBxgABxgByOrderID(String orderID) {
        Order order = orderService.findOrderById(orderID);
        List<Map<String, Object>> oblist = new ArrayList<>();
        for (OrderBxg ob : order.getOrderBxgs()) {
            if (ob.getCount() == 0) {
                remove(ob);
                continue;
            }
            Map<String, Object> map = createOrderBxgMap(ob);
            oblist.add(map);
        }
        return oblist;
    }

    @Override
    public OrderBxg findOrderBxgByBxgIdInOrderID(int bxgID, String orderid) {
        return orderBxgDao.selectOrderBxgByBxgIdInOrderID(bxgID, orderid);
    }

    @Override
    public boolean remove(OrderBxg ob) {
        OrderPrice op = getOrderPriceByOrderBxg(ob);
        handleOrderPriceDeleteFailure(op);
        return orderBxgDao.delete(ob);
    }

    @Override
    public boolean modify(OrderBxg ob) {
        OrderPrice op = getOrderPriceByOrderBxg(ob);
        updateOrderPrice(op, ob);
        handleOrderPriceUpdateFailure(op, ob);
        return orderBxgDao.update(ob);
    }

    @Override
    public OrderBxg[] queryAllOrderBxgs() {
        List<OrderBxg> list = orderBxgDao.selectAllOrderBxgs();
        return list.toArray(new OrderBxg[0]);
    }

    private OrderPrice createOrderPrice(OrderBxg ob) {
        OrderPrice op = new OrderPrice();
        op.setOrder(ob.getOrder());
        op.setProductID(ob.getBxg().getID());
        op.setType("bxg");
        double price = bxgService.findBxgByIdBindCut(ob.getBxg().getID(),
                ob.getOrder().getCustomer().getID(), null).getLsprice();
        op.setPrice(price);
        return op;
    }

    private void handleOrderPriceSaveFailure(OrderPrice op) {
        if (!orderPriceService.save(op)) {
            handleDatabaseOperationFailure("bxg", op);
        }
    }

    private void updateBxgBuyCount(OrderBxg ob) {
        Bxg bxg = ob.getBxg();
        bxg.setBuycount(bxg.getBuycount() + 1);
        bxgService.modify(bxg);
    }

    private Map<String, Object> createOrderBxgMap(OrderBxg ob) {
        Map<String, Object> map = new HashMap<>();
        map.put("count", ob.getCount());
        map.put("bxg", bxgService.findBxgByIdBindCut(ob.getBxg().getID(), ob.getOrder().getCustomer().getID(), null));
        map.put("operation", ob.getOperation());
        return map;
    }

    private OrderPrice getOrderPriceByOrderBxg(OrderBxg ob) {
        return orderPriceService.findOrderPriceByCondition("bxg", ob.getBxg().getID(), ob.getOrder().getID());
    }

    private void handleOrderPriceDeleteFailure(OrderPrice op) {
        if (!orderPriceService.remove(op)) {
            handleDatabaseOperationFailure("bxg", op);
        }
    }

    private void updateOrderPrice(OrderPrice op, OrderBxg ob) {
        double price = bxgService.findBxgByIdBindCut(ob.getBxg().getID(),
                ob.getOrder().getCustomer().getID(), null).getLsprice();
        op.setPrice(price);
    }

    private void handleOrderPriceUpdateFailure(OrderPrice op, OrderBxg ob) {
        if (!orderPriceService.modify(op)) {
            handleDatabaseOperationFailure("bxg", op);
        }
    }

    private void handleDatabaseOperationFailure(String type, OrderPrice op) {
        StringBuilder sb = new StringBuilder();
        sb.append("数据操作异常\t").append(new Date()).append("\n");
        sb.append("目标表：t_orderprice\n");
        sb.append("orderID:").append(op.getOrder().getID()).append("\n");
        sb.append("productID:").append(op.getProductID()).append("\n");
        sb.append("type:").append(type).append("\n");
        sb.append("price:").append(op.getPrice()).append("\n\n");
        FileUtil.writeTextToTextFile(sb.toString(), "log" + File.separator + "database", "record.txt", true);
        JOptionPane.showConfirmDialog(null,
                "警告，订单价格操作失败，请查看" + "log" + File.separator + "database" +
                        File.separator + "record.txt", "系统消息",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }
}
