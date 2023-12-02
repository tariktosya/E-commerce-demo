package com.demo.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customers SET soft_delete = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "soft_delete is not true")
public class CustomerEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private Set<OrderEntity> orderList = new HashSet<>();

}
