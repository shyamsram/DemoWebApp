package com.corp.app.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tranId;
    private Date tranDate;
    private String tranType;

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranId=" + tranId +
                ", tranDate=" + tranDate +
                ", tranType='" + tranType + '\'' +
                '}';
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    protected Transaction () {}

    public Transaction (Date tranDate, String tranType) {
        this.tranDate = tranDate;
        this.tranType = tranType;
    }


}
