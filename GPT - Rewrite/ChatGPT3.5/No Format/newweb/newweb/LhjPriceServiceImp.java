package com.newweb.service.base.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newweb.dao.base.LhjPriceDao;
import com.newweb.model.base.LhjPrice;
import com.newweb.service.base.LhjPriceService;
import com.newweb.service.business.LhjPriceCutService;
import com.newweb.service.business.OrderPriceService;

@Service("lhjPriceService")
public class LhjPriceServiceImp implements LhjPriceService {

    @Autowired
    private LhjPriceDao lhjPriceDao;

    @Autowired
    private LhjPriceCutService lhjPriceCutService;

    @Autowired
    private OrderPriceService orderPriceService;

    @Override
    public LhjPrice findLhjPriceByMaterialBrandIDBindCut(int materialBrandID, int customerID, String orderID) {
        LhjPrice price = lhjPriceDao.selectLhjPriceByMaterialBrandID(materialBrandID);
        LhjPrice returnPrice = new LhjPrice(price);
        if (orderID != null) {
            returnPrice = getOrderPriceOrCutPrice(returnPrice, materialBrandID, customerID, orderID);
        } else {
            returnPrice = getCutPrice(returnPrice, materialBrandID, customerID);
        }
        return returnPrice;
    }

    private LhjPrice getOrderPriceOrCutPrice(LhjPrice returnPrice, int materialBrandID, int customerID, String orderID) {
        return orderPriceService.findOrderPriceByCondition("lhj", materialBrandID, orderID)
                .map(op -> {
                    returnPrice.setPrice(op.getPrice());
                    return returnPrice;
                })
                .orElseGet(() -> getCutPrice(returnPrice, materialBrandID, customerID));
    }

    private LhjPrice getCutPrice(LhjPrice returnPrice, int materialBrandID, int customerID) {
        return lhjPriceCutService.findLhjPriceCutByCustomerIDAndPriceID(returnPrice.getID(), customerID)
                .map(cut -> {
                    returnPrice.setPrice(cut.getPrice());
                    return returnPrice;
                })
                .orElse(returnPrice);
    }

    @Override
    public LhjPrice findLhjPriceByMaterialBrandID(int materialBrandID) {
        return lhjPriceDao.selectLhjPriceByMaterialBrandID(materialBrandID);
    }

    @Override
    public LhjPrice[] queryAllLhjPrices(int start, int limit) {
        return lhjPriceDao.selectAllLhjPrices(start, limit).toArray(new LhjPrice[0]);
    }

    @Override
    public LhjPrice findLhjPriceByID(int lid) {
        return lhjPriceDao.selectLhjPriceByID(lid);
    }

    @Override
    public boolean modify(LhjPrice lhjp) {
        return lhjPriceDao.update(lhjp);
    }

    @Override
    public boolean save(LhjPrice lhjp) {
        return lhjPriceDao.insert(lhjp);
    }

    @Override
    public boolean remove(LhjPrice lhjp) {
        return lhjPriceDao.delete(lhjp);
    }
}
