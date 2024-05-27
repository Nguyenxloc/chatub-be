package com.example.java4.entities;
import com.example.java4.RestControllers.KhachHangController;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name="pttt")
    private String pttt;
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
    private GiaoHang giaoHang;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name="TrangThai")
    private int trangThai;
}