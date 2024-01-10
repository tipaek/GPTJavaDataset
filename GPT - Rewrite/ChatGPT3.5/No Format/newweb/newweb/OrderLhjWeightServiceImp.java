package com.newweb.service.business.imp;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.business.OrderLhjWeightDao;
import com.newweb.model.business.OrderLhjWeight;
import com.newweb.model.business.OrderPrice;
import com.newweb.service.base.LhjPriceService;
import com.newweb.service.business.OrderLhjWeightService;
import com.newweb.service.business.OrderPriceService;
import com.newweb.service.business.OrderService;
import com.newweb.util.FileUtil;

@Component("orderLhjWeightService")
public class OrderLhjWeightServiceImp implements OrderLhjWeightService {
    @Autowired
    private OrderLhjWeightDao orderLhjWeightDao;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderPriceService orderPriceService;
    @Autowired
    private LhjPriceService lhjPriceService;

    @Override
    public OrderLhjWeight findOrderLhjWeightByOrderIDAndMaterialBrandID(String orderid, int materialBrandID) {
        return orderLhjWeightDao.selectOrderLhjWeightByOrderIDAndMaterialBrandID(orderid, materialBrandID);
    }

    @Override
    public boolean remove(OrderLhjWeight lhjWeight) {
        OrderPrice op = orderPriceService.findOrderPriceByCondition("lhj", lhjWeight.getMaterialBrand().getID(),
                lhjWeight.getOrder().getID());
        if (!orderPriceService.remove(op)) {
            handleDataException("t_orderprice", op.getID());
        }
        return orderLhjWeightDao.delete(lhjWeight);
    }

    @Override
    public boolean save(OrderLhjWeight w) {
        OrderPrice op = createOrderPrice("lhj", w);
        if (!orderPriceService.save(op)) {
            handleDataException("t_orderprice", w.getOrder().getID(), w.getMaterialBrand().getID(), "lhj", op.getPrice());
        }
        return orderLhjWeightDao.insert(w);
    }

    @Override
    public boolean modify(OrderLhjWeight lhjWeight) {
        OrderPrice op = updateOrderPrice("lhj", lhjWeight);
        if (!orderPriceService.modify(op)) {
            handleDataException("t_orderprice", lhjWeight.getOrder().getID(), lhjWeight.getMaterialBrand().getID(), "lhj", op.getPrice());
        }
        return orderLhjWeightDao.update(lhjWeight);
    }

    @Override
    public OrderLhjWeight[] queryOrderLhjWeightsByOrderID(String orderid) {
        Set<OrderLhjWeight> set = orderService.findOrderById(orderid).getOrderLhjWeights();
        return set.toArray(new OrderLhjWeight[0]);
    }

    @Override
    public OrderLhjWeight[] queryAllOrderLhjWeights() {
        List<OrderLhjWeight> list = orderLhjWeightDao.selectAllOrderLhjWeights();
        return list.toArray(new OrderLhjWeight[0]);
    }

    private OrderPrice createOrderPrice(String type, OrderLhjWeight w) {
        OrderPrice op = new OrderPrice();
        op.setOrder(w.getOrder());
        op.setProductID(w.getMaterialBrand().getID());
        op.setType(type);
        double price = lhjPriceService.findLhjPriceByMaterialBrandIDBindCut(w.getMaterialBrand().getID(),
                w.getOrder().getCustomer().getID(), null).getPrice();
        op.setPrice(price);
        return op;
    }

    private OrderPrice updateOrderPrice(String type, OrderLhjWeight lhjWeight) {
        OrderPrice op = orderPriceService.findOrderPriceByCondition(type, lhjWeight.getMaterialBrand().getID(),
                lhjWeight.getOrder().getID());
        double price = lhjPriceService.findLhjPriceByMaterialBrandIDBindCut(lhjWeight.getMaterialBrand().getID(),
                lhjWeight.getOrder().getCustomer().getID(), null).getPrice();
        op.setPrice(price);
        return op;
    }

    private void handleDataException(String tableName, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("数据操作异常\t").append(new Date()).append("\n目标表：").append(tableName).append("\n");
        for (Object arg : args) {
            sb.append(arg).append("\n");
        }
        sb.append("\n");
        FileUtil.writeTextToTextFile(sb.toString(), "log" + File.separator + "database", "record.txt", true);
        JOptionPane.showConfirmDialog(null,
                "警告，数据操作异常，请查看" + "log" + File.separator + "database" +
                        File.separator + "record.txt", "系统消息",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }
}
