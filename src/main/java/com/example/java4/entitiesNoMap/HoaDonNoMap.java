package com.example.java4.entitiesNoMap;
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
public class HoaDonNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name="IdPTTT")
    private String idPttt;
    @Column(name="IdKM")
    private String idKhuyenMai;
    @Column(name="IdNV")
    private String idNhanVien;
    @Column(name="IdKH")
    private String idKhachHang;
    @Column(name="IdShip")
    private String idGiaoHang;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name="TrangThai")
    private int trangThai;
}