package com.newweb.model.base;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.newweb.model.business.BxgPriceCut;
import com.newweb.model.business.OrderBxg;

@Entity
@Table(name = "t_bxg")
public class Bxg implements Cloneable {

    private int id;
    private String name;
    private String norms;
    private double thickness;
    private double lsPrice;
    private double pfPrice;
    private MaterialBrand materialBrand;
    private Supplier supplier;
    private int buyCount;
    private Set<BxgPriceCut> bxgPriceCuts;
    private boolean valid;
    private Set<OrderBxg> orderBxgs;

    @OneToMany(mappedBy = "bxg", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public Set<OrderBxg> getOrderBxgs() {
        return orderBxgs;
    }

    public void setOrderBxgs(Set<OrderBxg> orderBxgs) {
        this.orderBxgs = orderBxgs;
    }

    @Column(columnDefinition = "boolean default true")
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @OneToMany(mappedBy = "bxg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<BxgPriceCut> getBxgPriceCuts() {
        return bxgPriceCuts;
    }

    public void setBxgPriceCuts(Set<BxgPriceCut> bxgPriceCuts) {
        this.bxgPriceCuts = bxgPriceCuts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getNorms() {
        return norms;
    }

    public void setNorms(String norms) {
        this.norms = norms;
    }

    @Column
    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Column(columnDefinition = "int default 0 ")
    public double getLsPrice() {
        return lsPrice;
    }

    public void setLsPrice(double lsPrice) {
        this.lsPrice = lsPrice;
    }

    @Column(columnDefinition = "int default 0")
    public double getPfPrice() {
        return pfPrice;
    }

    public void setPfPrice(double pfPrice) {
        this.pfPrice = pfPrice;
    }

    @ManyToOne
    @JoinColumn(name = "materialbrandID")
    public MaterialBrand getMaterialBrand() {
        return materialBrand;
    }

    public void setMaterialBrand(MaterialBrand materialBrand) {
        this.materialBrand = materialBrand;
    }

    @ManyToOne
    @JoinColumn(name = "supplierID")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Column(columnDefinition = "int default 0")
    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public Object clone() {
        try {
            Bxg bxg = (Bxg) super.clone();
            bxg.materialBrand = (MaterialBrand) materialBrand.clone();
            bxg.supplier = (Supplier) supplier.clone();
            return bxg;
        } catch (Exception e) {
            return null;
        }
    }
}
