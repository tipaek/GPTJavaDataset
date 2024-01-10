package com.newweb.service.business.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.business.OrderBxgFdwDao;
import com.newweb.model.base.Bxg;
import com.newweb.model.business.OrderBxgFdw;
import com.newweb.service.base.BxgService;
import com.newweb.service.business.OrderBxgFdwService;

@Component("orderBxgFdwService")
public class OrderBxgFdwServiceImp implements OrderBxgFdwService {

    @Autowired
    private OrderBxgFdwDao orderBxgFdwDao;
    @Autowired
    private BxgService bxgService;

    @Override
    public boolean save(OrderBxgFdw orderBxgFdw) {
        updateBxgBuyCount(orderBxgFdw);
        if (!orderBxgFdwDao.insert(orderBxgFdw)) {
            throw new RuntimeException("不锈钢防盗网保存失败");
        }
        return true;
    }

    @Override
    public OrderBxgFdw[] queryOrderBxgFdwsByOrderID(String orderid) {
        return orderBxgFdwDao.selectOrderBxgFdwsByOrderID(orderid)
                .stream()
                .filter(of -> of.getFdwCount() > 0)
                .toArray(OrderBxgFdw[]::new);
    }

    @Override
    public OrderBxgFdw findBxgFdwById(int ID) {
        return orderBxgFdwDao.selectBxgFdwById(ID);
    }

    @Override
    public boolean modify(OrderBxgFdw fdw) {
        return orderBxgFdwDao.update(fdw);
    }

    @Override
    public boolean remove(OrderBxgFdw fdw) {
        return orderBxgFdwDao.delete(fdw);
    }

    private void updateBxgBuyCount(OrderBxgFdw orderBxgFdw) {
        Bxg fg = orderBxgFdw.getFdwFgType();
        Bxg yg = orderBxgFdw.getFdwYgType();
        fg.setBuycount(fg.getBuycount() + 1);
        yg.setBuycount(yg.getBuycount() + 1);
        if (!bxgService.modify(fg) || !bxgService.modify(yg)) {
            throw new RuntimeException("不锈钢购买次数更新失败");
        }
    }
}
