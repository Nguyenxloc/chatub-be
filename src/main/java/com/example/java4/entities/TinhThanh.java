package com.example.java4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tinhthanh")
public class TinhThanh {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="Ten")
    private String ten;
    @Column(name="TrangThai")
    private Integer trangThai;
}