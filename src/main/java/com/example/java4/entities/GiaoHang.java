package com.example.java4.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "giaoHang")
public class GiaoHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="Sdt")
    private String sdt;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name="PhuongXa")
    private String phuongXa;
    @Column(name="QuanHuyen")
    private String quanHuyen;
    @Column(name="TinhThanh")
    private String tinhThanh;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
