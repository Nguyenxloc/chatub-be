package com.example.java4.entitiesLv1;

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
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "Ma")
    private String ma;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="NgaySinh")
    private String ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="NgayTao")
    private  Date ngayTao;
    @Column(name ="TrangThai")
    private Integer trangThai;
    @Column(name="IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String idTinhThanh;
    @Column(name="phuongXa")
    private String phuongXa;
    @Column(name="quanHuyen")
    private String quanHuyen;
    @Column(name="tinhThanh")
    private String tinhThanh;
}