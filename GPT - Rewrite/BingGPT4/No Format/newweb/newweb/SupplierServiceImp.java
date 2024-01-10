package com.newweb.service.base.imp;

import com.newweb.dao.base.SupplierDao;
import com.newweb.model.base.Bxg;
import com.newweb.model.base.MaterialBrand;
import com.newweb.model.base.Small;
import com.newweb.model.base.Supplier;
import com.newweb.service.base.BxgService;
import com.newweb.service.base.MaterialBrandService;
import com.newweb.service.base.SmallService;
import com.newweb.service.base.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("supplierService")
public class SupplierServiceImp implements SupplierService {

    private final SupplierDao supplierDao;
    private final BxgService bxgService;
    private final SmallService smallService;
    private final MaterialBrandService materialBrandService;

    @Autowired
    public SupplierServiceImp(SupplierDao supplierDao, BxgService bxgService, SmallService smallService, MaterialBrandService materialBrandService) {
        this.supplierDao = supplierDao;
        this.bxgService = bxgService;
        this.smallService = smallService;
        this.materialBrandService = materialBrandService;
    }

    @Override
    public Supplier[] queryAllSuppliers() {
        List<Supplier> list = supplierDao.selectAllSuppliers();
        return list.toArray(new Supplier[0]);
    }

    @Override
    public Supplier findSupplierById(int id) {
        return supplierDao.selectSupplierById(id);
    }

    @Override
    public boolean modify(Supplier supplier) {
        return supplierDao.update(supplier);
    }

    @Override
    public Supplier querySupplierByName(String name) {
        return supplierDao.selectSupplierByName(name);
    }

    @Override
    public boolean save(Supplier supplier) {
        return supplierDao.insert(supplier);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List queryAllSuppliers(int start, int limit) {
        List list = supplierDao.selectAllSuppliers(start, limit);
        int size = (Integer) list.get(0);
        List<Supplier> suppliers = (List<Supplier>) list.get(1);
        return List.of(size, suppliers.toArray(new Supplier[0]));
    }

    @Override
    public boolean isUsed(int id) {
        Supplier supplier = supplierDao.selectSupplierById(id);
        return supplier.getBxgs().stream().anyMatch(bxg -> bxg.getOrderBxgs().size() > 0) ||
                supplier.getSmalls().stream().anyMatch(small -> small.getOrderSmalls().size() > 0) ||
                supplier.getMaterialBrands().stream().anyMatch(materialBrand -> materialBrand.getOrderLhjs().size() > 0);
    }

    @Override
    public boolean remove(Supplier supplier) {
        return supplierDao.delete(supplier);
    }

    @Override
    public String modifyToUnvalid(int id) {
        StringBuilder sb = new StringBuilder();
        Supplier supplier = supplierDao.selectSupplierById(id);
        int i1 = 0;
        int i2 = 0;
        for (Bxg bxg : supplier.getBxgs()) {
            bxg.setValid(false);
            if (bxgService.modify(bxg)) {
                i1++;
            } else {
                throw new RuntimeException("供应商： " + supplier.getName() + " 【不可用】状态更改失败</br>原因：不锈钢【" +
                        bxg.getName() + bxg.getNorms() + "】状态更改失败</br>");
            }
        }
        for (Small small : supplier.getSmalls()) {
            small.setValid(false);
            if (smallService.modify(small)) {
                i2++;
            } else {
                throw new RuntimeException("供应商： " + supplier.getName() + " 【不可用】状态更改失败</br>原因：小件【" +
                        small.getName() + "】状态更改失败</br>");
            }
        }

        supplier.setValid(false);
        if (supplierDao.update(supplier)) {
            sb.append("供应商： ").append(supplier.getName()).append(" 已更改为【不可用】状态!</br>");
        } else {
            throw new RuntimeException("供应商： " + supplier.getName() + " 【不可用】状态更改失败</br>");
        }
        if (i1 != 0) {
            sb.append("已同步更改").append(i1).append("个不锈钢为【不可用】状态</br>");
        }
        if (i2 != 0) {
            sb.append("已同步更改").append(i2).append("个小件为【不可用】状态</br>");
        }
        return sb.toString();
    }
}
