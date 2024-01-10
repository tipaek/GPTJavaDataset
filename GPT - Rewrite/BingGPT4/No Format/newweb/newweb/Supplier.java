package com.newweb.model.base;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="t_supplier")
public class Supplier implements Cloneable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private String contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<MaterialBrand> materialBrands;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Bxg> bxgs;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Small> smalls;

    @Column(columnDefinition="boolean default true")
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Set<Bxg> getBxgs() {
        return bxgs;
    }

    public void setBxgs(Set<Bxg> bxgs) {
        this.bxgs = bxgs;
    }

    public Set<Small> getSmalls() {
        return smalls;
    }

    public void setSmalls(Set<Small> smalls) {
        this.smalls = smalls;
    }

    public Set<MaterialBrand> getMaterialBrands() {
        return materialBrands;
    }

    public void setMaterialBrands(Set<MaterialBrand> materialBrands) {
        this.materialBrands = materialBrands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
