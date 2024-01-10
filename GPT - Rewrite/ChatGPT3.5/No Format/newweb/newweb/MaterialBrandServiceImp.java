package com.newweb.service.base.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.newweb.dao.base.MaterialBrandDao;
import com.newweb.model.base.Bxg;
import com.newweb.model.base.MaterialBrand;
import com.newweb.model.base.TypeForBrand;
import com.newweb.service.base.BxgService;
import com.newweb.service.base.MaterialBrandService;
import com.newweb.service.base.TypeForBrandService;

@Component("materialBrandService")
@Transactional
public class MaterialBrandServiceImp implements MaterialBrandService {

    @Autowired
    private MaterialBrandDao materialBrandDao;
    @Autowired
    private BxgService bxgService;
    @Autowired
    private TypeForBrandService typeForBrandService;

    @Override
    public MaterialBrand[] queryMaterialBrandsByType(String type) {
        List<MaterialBrand> list = materialBrandDao.selectMaterialBrandsByType(type);
        return list.toArray(new MaterialBrand[0]);
    }

    @Override
    public MaterialBrand findMaterialBrandById(int ID) {
        return materialBrandDao.selectMaterialBrandById(ID);
    }

    @Override
    public TypeForBrand findTypeForBrandById(int ID) {
        return materialBrandDao.selectTypeForBrandById(ID);
    }

    @Override
    public List<Object> queryAllMaterialBrands(int start, int limit) {
        List<Object> list = materialBrandDao.selectAllMaterialBrands(start, limit);
        int size = (Integer) list.get(0);
        List<MaterialBrand> mbList = (List<MaterialBrand>) list.get(1);
        MaterialBrand[] mbs = mbList.toArray(new MaterialBrand[0]);
        List<Object> returnList = new ArrayList<>();
        returnList.add(size);
        returnList.add(mbs);
        return returnList;
    }

    @Override
    public boolean modify(MaterialBrand mb) {
        return materialBrandDao.update(mb);
    }

    @Override
    public MaterialBrand findMaterialBrandByName(String name) {
        return materialBrandDao.selectMaterialBrandByName(name);
    }

    @Override
    public boolean save(MaterialBrand mb) {
        return materialBrandDao.insert(mb);
    }

    @Override
    public boolean remove(MaterialBrand mb) {
        return materialBrandDao.delete(mb);
    }

    @Override
    public boolean isUsed(int id) {
        MaterialBrand mb = materialBrandDao.selectMaterialBrandById(id);
        if (mb.getOrderLhjs().size() > 0)
            return true;
        Set<Bxg> bxgs = mb.getBxgs();
        for (Bxg bxg : bxgs) {
            if (bxg.getOrderBxgs().size() > 0)
                return true;
        }
        return false;
    }

    @Override
    public String modifyToUnvalid(int id) {
        StringBuilder sb = new StringBuilder();
        MaterialBrand mb = materialBrandDao.selectMaterialBrandById(id);
        Set<Bxg> bxgs = mb.getBxgs();
        int cbxg = 0;
        int ctfb = 0;
        for (Bxg bxg : bxgs) {
            bxg.setValid(false);
            if (bxgService.modify(bxg)) {
                cbxg++;
            } else {
                throw new RuntimeException("品牌： '" + mb.getName() + " 更改【不可用】状态失败</br>原因：不锈钢【" + bxg.getName() +
                        bxg.getNorms() + "】状态更改失败</br>");
            }
        }
        Set<TypeForBrand> typeForBrands = mb.getTypeForBrands();
        for (TypeForBrand typeForBrand : typeForBrands) {
            typeForBrand.setValid(false);
            if (typeForBrandService.modify(typeForBrand)) {
                ctfb++;
            } else {
                throw new RuntimeException("品牌： '" + mb.getName() + " 更改【不可用】状态失败</br>原因：材料品牌【" + typeForBrand.getName() +
                        "】状态更改失败</br>");
            }
        }
        mb.setValid(false);
        if (modify(mb)) {
            sb.append("品牌： '" + mb.getName() + " ' 已更改为【不可用】状态</br>");
        } else {
            throw new RuntimeException("品牌： '" + mb.getName() + " 更改【不可用】状态失败</br>");
        }
        if (cbxg != 0) {
            sb.append("已同步更改" + cbxg + "个不锈钢为【不可用】状态</br>");
        }
        if (ctfb != 0) {
            sb.append("已同步更改" + ctfb + "个材料品牌为【不可用】状态</br>");
        }
        return sb.toString();
    }

    @Override
    public String modifyToValid(int id) {
        StringBuilder sb = new StringBuilder();
        MaterialBrand mb = materialBrandDao.selectMaterialBrandById(id);
        Set<Bxg> bxgs = mb.getBxgs();
        int cbxg = 0;
        int ctfb = 0;
        for (Bxg bxg : bxgs) {
            bxg.setValid(true);
            if (bxgService.modify(bxg)) {
                cbxg++;
            } else {
                throw new RuntimeException("品牌： '" + mb.getName() + " 更改【可用】状态失败</br>原因：不锈钢【" + bxg.getName() +
                        bxg.getNorms() + "】状态更改失败</br>");
            }
        }
        Set<TypeForBrand> typeForBrands = mb.getTypeForBrands();
        for (TypeForBrand typeForBrand : typeForBrands) {
            typeForBrand.setValid(true);
            if (typeForBrandService.modify(typeForBrand)) {
                ctfb++;
            } else {
                throw new RuntimeException("品牌： '" + mb.getName() + " 更改【可用】状态失败</br>原因：材料品牌【" + typeForBrand.getName() +
                        "】状态更改失败</br>");
            }
        }
        mb.setValid(true);
        if (modify(mb)) {
            sb.append("品牌： '" + mb.getName() + " ' 已更改为【可用】状态</br>");
        } else {
            throw new RuntimeException("品牌： '" + mb.getName() + " 更改【可用】状态失败</br>");
        }
        if (cbxg != 0) {
            sb.append("已同步更改" + cbxg + "个不锈钢为【可用】状态</br>");
        }
        if (ctfb != 0) {
            sb.append("已同步更改" + ctfb + "个材料品牌为【可用】状态</br>");
        }
        return sb.toString();
    }

}
