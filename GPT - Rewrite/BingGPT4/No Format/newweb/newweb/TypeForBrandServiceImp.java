package com.newweb.service.base.imp;

import com.newweb.dao.base.TypeForBrandDao;
import com.newweb.model.base.TypeForBrand;
import com.newweb.service.base.TypeForBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeForBrandService")
public class TypeForBrandServiceImp implements TypeForBrandService {

    private final TypeForBrandDao typeForBrandDao;

    @Autowired
    public TypeForBrandServiceImp(TypeForBrandDao typeForBrandDao) {
        this.typeForBrandDao = typeForBrandDao;
    }

    @Override
    public TypeForBrand[] queryTypeForBrandByMaterialBrand(String brandID) {
        List<TypeForBrand> list = typeForBrandDao.selectTypeForBrandByMaterialBrand(brandID);
        return list.toArray(new TypeForBrand[0]);
    }

    @Override
    public boolean modify(TypeForBrand typeForBrand) {
        return typeForBrandDao.update(typeForBrand);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public List queryAllTypeForBrands(int start, int limit) {
        List list = typeForBrandDao.selectAllTyepForBrands(start, limit);
        int size = (Integer) list.get(0);
        List<TypeForBrand> types = (List<TypeForBrand>) list.get(1);
        return List.of(size, types.toArray(new TypeForBrand[0]));
    }

    @Override
    public TypeForBrand findTypeForBrandById(int typeID) {
        return typeForBrandDao.selectTypeForBrandByID(typeID);
    }

    @Override
    public TypeForBrand findTypeForBrandByCondition(String name, int materialBrandID) {
        return typeForBrandDao.selectTypeForBrandByCondition(name, materialBrandID);
    }

    @Override
    public boolean save(TypeForBrand type) {
        return typeForBrandDao.insert(type);
    }

    @Override
    public int getOrderLhjWinPropsCount(int id) {
        TypeForBrand type = typeForBrandDao.selectTypeForBrandByID(id);
        return type.getOrderLhjWinProps().size();
    }

    @Override
    public boolean remove(TypeForBrand type) {
        return typeForBrandDao.delete(type);
    }
}
