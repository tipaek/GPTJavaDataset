package com.newweb.service.base.imp;

import com.newweb.dao.base.SmallDao;
import com.newweb.model.base.Small;
import com.newweb.model.business.OrderPrice;
import com.newweb.model.business.SmallPriceCut;
import com.newweb.service.base.SmallService;
import com.newweb.service.business.OrderPriceService;
import com.newweb.service.business.SmallPriceCutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("smallService")
public class SmallServiceImp implements SmallService {

    private final SmallDao smallDao;
    private final SmallPriceCutService smallPriceCutService;
    private final OrderPriceService orderPriceService;

    @Autowired
    public SmallServiceImp(SmallDao smallDao, SmallPriceCutService smallPriceCutService, OrderPriceService orderPriceService) {
        this.smallDao = smallDao;
        this.smallPriceCutService = smallPriceCutService;
        this.orderPriceService = orderPriceService;
    }

    @Override
    public String[] queryDistinctTypes() {
        List<String> list = smallDao.selectDistinctType();
        return list.toArray(new String[0]);
    }

    @Override
    public Small[] querySmallsByType(String type) {
        List<Small> list = "全部".equals(type) ? smallDao.selectAllSmalls() : smallDao.selectSmallsByType(type);
        return list.toArray(new Small[0]);
    }

    @Override
    public Small findSmallByIdBindCut(int smallID, int customerID, String orderID) {
        Small small = smallDao.selectSmallById(smallID);
        Small returnSmall = (Small) small.clone();
        SmallPriceCut cut = smallPriceCutService.findSmallPriceCutBySmallIDAndCustomerID(smallID, customerID);
        if (cut != null) {
            returnSmall.setLsprice(cut.getPrice());
        }
        if (orderID != null) {
            OrderPrice op = orderPriceService.findOrderPriceByCondition("small", smallID, orderID);
            if (op != null) {
                returnSmall.setLsprice(op.getPrice());
            }
        }
        return returnSmall;
    }

    @Override
    public Small findSmallById(int smallID) {
        return smallDao.selectSmallById(smallID);
    }

    @Override
    public boolean modify(Small small) {
        return smallDao.update(small) > 0;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List queryAllSmalls(int start, int limit) {
        List list = smallDao.selectAllSmalls(start, limit);
        int size = (Integer) list.get(0);
        List sList = (List) list.get(1);
        Small[] ss = new Small[sList.size()];
        int count = 0;
        for (Object s : sList) {
            ss[count++] = (Small) s;
        }
        List returnList = new ArrayList();
        returnList.add(size);
        returnList.add(ss);
        return returnList;
    }

    @Override
    public Small findSmallByName(String name) {
        return smallDao.selectSmallByName(name);
    }

    @Override
    public boolean save(Small small) {
        return smallDao.insert(small);
    }

    @Override
    public boolean remove(Small small) {
        return smallDao.delete(small);
    }

    @Override
    public int getOrderSmallsCount(int id) {
        return smallDao.selectSmallById(id).getOrderSmalls().size();
    }
}
