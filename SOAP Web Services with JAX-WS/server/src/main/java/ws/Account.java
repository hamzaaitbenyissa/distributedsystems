package ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)

public class Account {

    private int code;
    private double balance;

    @XmlTransient
    private Date createdAt;

    public Account(int code, double balance, Date createdAt) {
        this.code = code;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
