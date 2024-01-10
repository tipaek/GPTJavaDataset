package com.newweb.service.business.imp;

import com.newweb.dao.business.OrderOtherDao;
import com.newweb.model.business.OrderOther;
import com.newweb.service.business.OrderOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("orderOtherService")
public class OrderOtherServiceImp implements OrderOtherService {

    private final OrderOtherDao orderOtherDao;

    @Autowired
    public OrderOtherServiceImp(OrderOtherDao orderOtherDao) {
        this.orderOtherDao = orderOtherDao;
    }

    @Override
    public boolean save(OrderOther other) {
        return orderOtherDao.insert(other);
    }

    @Override
    public OrderOther[] queryOrderOthersByOrderID(String orderid) {
        List<OrderOther> list = orderOtherDao.selectOrderOthersByOrderID(orderid)
                .stream()
                .filter(other -> other.getCount() != 0)
                .collect(Collectors.toList());

        list.forEach(this::remove);

        return list.toArray(new OrderOther[0]);
    }

    @Override
    public OrderOther findOrderOtherById(int id) {
        return orderOtherDao.selectOrderOtherById(id);
    }

    @Override
    public boolean modify(OrderOther other) {
        return orderOtherDao.update(other);
    }

    @Override
    public boolean remove(OrderOther other) {
        return orderOtherDao.delete(other);
    }
}
