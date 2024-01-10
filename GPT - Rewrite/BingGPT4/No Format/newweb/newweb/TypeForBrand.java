package com.newweb.model.base;

import com.newweb.model.business.OrderLhjWinProp;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="t_typeforbrand")
public class TypeForBrand {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="materialbrandID")
    private MaterialBrand materialBrand;

    @Column(columnDefinition="boolean default true")
    private boolean valid;

    @OneToMany(mappedBy = "typeForBrand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderLhjWinProp> orderLhjWinProps;

    public Set<OrderLhjWinProp> getOrderLhjWinProps() {
        return orderLhjWinProps;
    }

    public void setOrderLhjWinProps(Set<OrderLhjWinProp> orderLhjWinProps) {
        this.orderLhjWinProps = orderLhjWinProps;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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

    public MaterialBrand getMaterialBrand() {
        return materialBrand;
    }

    public void setMaterialBrand(MaterialBrand materialBrand) {
        this.materialBrand = materialBrand;
    }
}
