package com.example.demo.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.InitBinder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "amount")
    private double amount;
}
