package com.newweb.service.business.imp;

import com.newweb.dao.business.SmallPriceCutDao;
import com.newweb.model.business.SmallPriceCut;
import com.newweb.service.business.SmallPriceCutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("smallPriceCutService")
public class SmallPriceCutServiceImp implements SmallPriceCutService {

    private final SmallPriceCutDao smallPriceCutDao;

    @Autowired
    public SmallPriceCutServiceImp(SmallPriceCutDao smallPriceCutDao) {
        this.smallPriceCutDao = smallPriceCutDao;
    }

    @Override
    public SmallPriceCut findSmallPriceCutBySmallIDAndCustomerID(int smallID, int customerID) {
        return smallPriceCutDao.selectSmallPriceCutBySmallIDAndCustomerID(smallID, customerID);
    }

    @Override
    public boolean save(SmallPriceCut cut) {
        return smallPriceCutDao.insert(cut);
    }

    @Override
    public boolean remove(SmallPriceCut cut) {
        return smallPriceCutDao.delete(cut);
    }

    @Override
    public boolean modify(SmallPriceCut cut) {
        return smallPriceCutDao.update(cut);
    }
}
