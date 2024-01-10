package com.newweb.model.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.newweb.model.business.LhjPriceCut;

@Entity
@Table(name = "t_lhjprice")
public class LhjPrice implements Cloneable {
    private int ID;
    private MaterialBrand materialBrand;
    private double price;
    private Set<LhjPriceCut> lhjPriceCuts;

    @OneToMany(mappedBy = "lhjPrice", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<LhjPriceCut> getLhjPriceCuts() {
        return lhjPriceCuts;
    }

    public void setLhjPriceCuts(Set<LhjPriceCut> lhjPriceCuts) {
        this.lhjPriceCuts = lhjPriceCuts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    @OneToOne
    @JoinColumn(name = "materialbrandid")
    public MaterialBrand getMaterialBrand() {
        return materialBrand;
    }

    public void setMaterialBrand(MaterialBrand materialBrand) {
        this.materialBrand = materialBrand;
    }

    @Column(columnDefinition = "double default 0.0")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Object clone() {
        try {
            LhjPrice lhj = (LhjPrice) super.clone();
            if (materialBrand != null) {
                lhj.materialBrand = (MaterialBrand) materialBrand.clone();
            }
            if (lhjPriceCuts != null) {
                Set<LhjPriceCut> clonedLhjPriceCuts = new HashSet<>();
                for (LhjPriceCut lhjPriceCut : lhjPriceCuts) {
                    clonedLhjPriceCuts.add((LhjPriceCut) lhjPriceCut.clone());
                }
                lhj.lhjPriceCuts = clonedLhjPriceCuts;
            }
            return lhj;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
