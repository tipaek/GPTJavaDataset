package com.newweb.service.business.imp;

import com.newweb.dao.business.OrderPriceDao;
import com.newweb.model.business.OrderPrice;
import com.newweb.service.business.OrderPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderPriceService")
public class OrderPriceServiceImp implements OrderPriceService {

    private final OrderPriceDao orderPriceDao;

    @Autowired
    public OrderPriceServiceImp(OrderPriceDao orderPriceDao) {
        this.orderPriceDao = orderPriceDao;
    }

    @Override
    public OrderPrice findOrderPriceByCondition(String type, int materialBrandID, String orderID) {
        List<OrderPrice> ops = orderPriceDao.selectOrderPriceByCondition(type, materialBrandID, orderID);
        if (ops.isEmpty()) {
            return null;
        }

        OrderPrice op = ops.get(0);
        ops.stream()
                .skip(1)
                .filter(p -> p.getOrder().getID().equals(op.getOrder().getID()) && p.getProductID() == op.getProductID())
                .forEach(orderPriceDao::delete);

        return op;
    }

    @Override
    public boolean remove(OrderPrice op) {
        return orderPriceDao.delete(op);
    }

    @Override
    public boolean save(OrderPrice op) {
        return orderPriceDao.insert(op);
    }

    @Override
    public boolean modify(OrderPrice op) {
        return orderPriceDao.update(op);
    }
}
