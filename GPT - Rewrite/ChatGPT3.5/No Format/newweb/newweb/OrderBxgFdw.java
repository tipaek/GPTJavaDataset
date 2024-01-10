package com.newweb.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newweb.model.base.Bxg;

@Entity
@Table(name = "t_order_bxgfdws")
public class OrderBxgFdw {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int ID;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Order order;

    @Column
    private double fdwHeight;

    @Column
    private double fdwWidth;

    @Column
    private int fdwCount;

    @ManyToOne
    @JoinColumn(name = "fgbxgid")
    private Bxg fdwFgType;

    @Column
    private int fdwFgCount;

    @ManyToOne
    @JoinColumn(name = "ygbxgid")
    private Bxg fdwYgType;

    @Column
    private int fdwYgCount;

    @Column
    private String remark;

    @Column
    private String operation; // data operation type (create: first-time order submission, add: order modification addition, update: order modification update)

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getFdwCount() {
        return fdwCount;
    }

    public void setFdwCount(int fdwCount) {
        this.fdwCount = fdwCount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getFdwHeight() {
        return fdwHeight;
    }

    public void setFdwHeight(double fdwHeight) {
        this.fdwHeight = fdwHeight;
    }

    public double getFdwWidth() {
        return fdwWidth;
    }

    public void setFdwWidth(double fdwWidth) {
        this.fdwWidth = fdwWidth;
    }

    public Bxg getFdwFgType() {
        return fdwFgType;
    }

    public void setFdwFgType(Bxg fdwFgType) {
        this.fdwFgType = fdwFgType;
    }

    public int getFdwFgCount() {
        return fdwFgCount;
    }

    public void setFdwFgCount(int fdwFgCount) {
        this.fdwFgCount = fdwFgCount;
    }

    public Bxg getFdwYgType() {
        return fdwYgType;
    }

    public void setFdwYgType(Bxg fdwYgType) {
        this.fdwYgType = fdwYgType;
    }

    public int getFdwYgCount() {
        return fdwYgCount;
    }

    public void setFdwYgCount(int fdwYgCount) {
        this.fdwYgCount = fdwYgCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
