package com.train.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nr;
    private String issue;
    private String total;


    public Invoice() {

    }

    public Invoice(String nr, String issue, String total) {
        this.nr = nr;
        this.issue = issue;
        this.total = total;
    }

    public Invoice(String nr, String issue, String total,long id) {
        this.nr = nr;
        this.issue = issue;
        this.total = total;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", nr='" + nr + '\'' +
                ", issue='" + issue + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
