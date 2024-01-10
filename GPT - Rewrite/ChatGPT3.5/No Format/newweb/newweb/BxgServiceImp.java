package com.newweb.service.base.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newweb.dao.base.BxgDao;
import com.newweb.model.base.Bxg;
import com.newweb.model.business.BxgPriceCut;
import com.newweb.model.business.OrderPrice;
import com.newweb.service.base.BxgService;
import com.newweb.service.business.BxgPriceCutService;
import com.newweb.service.business.OrderPriceService;

@Component("bxgService")
public class BxgServiceImp implements BxgService {

    @Autowired
    private BxgDao bxgDao;

    @Autowired
    private BxgPriceCutService bxgPriceCutService;

    @Autowired
    private OrderPriceService orderPriceService;

    @Override
    public Bxg[] queryAllBxgs() {
        List<Bxg> list = bxgDao.selectAllBxgs();
        return list.toArray(new Bxg[0]);
    }

    @Override
    public Bxg findBxgByIdBindCut(int id, int customerID, String orderID) {
        Bxg bxg = bxgDao.selectBxgById(id);
        Bxg returnBxg = (Bxg) bxg.clone();

        if (orderID != null) {
            OrderPrice op = orderPriceService.findOrderPriceByCondition("bxg", id, orderID);

            if (op != null) {
                returnBxg.setLsprice(op.getPrice());
                return returnBxg;
            } else {
                BxgPriceCut cut = null;

                try {
                    cut = bxgPriceCutService.findBxgPriceCutByBxgIDAndCuttomerID(id, customerID);
                } catch (Exception e) {
                    return returnBxg;
                }

                if (cut != null) {
                    returnBxg.setLsprice(cut.getPrice());
                }

                return returnBxg;
            }
        } else {
            BxgPriceCut cut = null;

            try {
                cut = bxgPriceCutService.findBxgPriceCutByBxgIDAndCuttomerID(id, customerID);
            } catch (Exception e) {
                return returnBxg;
            }

            if (cut != null) {
                returnBxg.setLsprice(cut.getPrice());
            }

            return returnBxg;
        }
    }

    @Override
    public Bxg findBxgById(int id) {
        return bxgDao.selectBxgById(id);
    }

    @Override
    public boolean modify(Bxg bxg) {
        return bxgDao.update(bxg);
    }

    @Override
    public Bxg[] queryBxgsByLikeNorms(String condition) {
        List<Bxg> list = bxgDao.selectBxgByLikeNorms(condition);
        return list.toArray(new Bxg[0]);
    }

    @Override
    public List<Bxg> queryAllBxgs(int start, int limit) {
        List<Object> list = bxgDao.selectAllBxgs(start, limit);
        int size = (Integer) list.get(0);
        List<Bxg> sList = (List<Bxg>) list.get(1);
        List<Bxg> returnList = new ArrayList<>();

        for (Bxg b : sList) {
            returnList.add(b);
        }

        returnList.add(size);
        return returnList;
    }

    @Override
    public boolean remove(Bxg bxg) {
        return bxgDao.delete(bxg);
    }

    @Override
    public Bxg findBxgByCondition(String name, double thickness, String norms, int brandID) {
        return bxgDao.selectBxgByCondition(name, thickness, norms, brandID);
    }

    @Override
    public boolean save(Bxg b) {
        return bxgDao.insert(b);
    }

    @Override
    public int getOrderBxgsCount(int id) {
        Bxg bxg = bxgDao.selectBxgById(id);
        return bxg.getOrderBxgs().size();
    }
}
