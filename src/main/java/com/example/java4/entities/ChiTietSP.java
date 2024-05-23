package com.example.java4.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="IdSP")
    private String idSp;
    @Column(name="IdNsx")
    private String idNsx;
    @Column(name="IdMauSac")
    private String idMauSac;
    @Column(name="IdKichThuoc")
    private String idKichThuoc;
    @Column(name="NamBH")
    private int namBH;
    @Column(name="MoTa")
    private String moTa;
    @Column(name="SoLuong")
    private Integer soLuong;
    @Column(name="GiaNhap")
    private BigDecimal giaNhap;
    @Column(name="GiaBan")
    private BigDecimal giaBan;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="TrangThai")
    private Integer trangThai;
}