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
    @ManyToOne
    @JoinColumn(name="IdSP",referencedColumnName = "IdSp")
    private SanPham sp;
    @ManyToOne
    @JoinColumn(name="IdNsx",referencedColumnName = "IdNsx")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name="IdMauSac",referencedColumnName = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name="IdKichThuoc",referencedColumnName = "IdKichThuoc")
    private KichThuoc kichThuoc;
    @Column(name="NamBH")
    private int namBH;
    @Column(name="MoTa")
    private String moTa;
    @Column(name="SoLuongTon")
    private Integer soLuongTon;
    @Column(name="GiaNhap")
    private Long giaNhap;
    @Column(name="GiaBan")
    private Long giaBan;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="TrangThai")
    private Integer trangThai;
}