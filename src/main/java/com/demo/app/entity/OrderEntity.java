package com.demo.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@SQLDelete(sql = "UPDATE orders SET soft_delete = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "soft_delete is not true")
public class OrderEntity extends BaseEntity{

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private CustomerEntity customer;
}
