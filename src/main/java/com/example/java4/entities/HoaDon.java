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
@Table(name="HoaDon")
public class HoaDon {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Ma")
    private String ma;
    @ManyToOne
    @JoinColumn(name="IdPTTT",referencedColumnName = "IdPTTT")
    private PTTT pttt;
    @ManyToOne
    @JoinColumn(name="IdKM",referencedColumnName = "IdKM")
    private KhuyenMai khuyenMai;
    @ManyToOne
    @JoinColumn(name="IdNV",referencedColumnName ="IdNV")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name="IdKH", referencedColumnName = "IdKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name="IdShip",referencedColumnName ="IdShip")
    private GiaoHang  giaoHang;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name="TrangThai")
    private int trangThai;
    @Column(name="indx")
    private int indx;
}