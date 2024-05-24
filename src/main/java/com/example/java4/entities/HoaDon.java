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
    @JoinColumn(name="IdPTTT",referencedColumnName = "Id")
    private PTTT pttt;
    @ManyToOne
    @JoinColumn(name="IdKM",referencedColumnName = "Id")
    private KhuyenMai khuyenMai;
    @ManyToOne
    @JoinColumn(name="IdNV",referencedColumnName ="Id")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name="IdKH", referencedColumnName = "Id")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name="IdShip",referencedColumnName ="Id")
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