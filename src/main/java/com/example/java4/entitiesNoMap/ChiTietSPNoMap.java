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
@Table(name = "ChiTietSP")
public class ChiTietSPNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="IdSP")
    private String idSp;
    @Column(name="IdMauSac")
    private String idMauSac;
    @Column(name="IdKichThuoc")
    private String idKichThuoc;
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
    @Column(name="HinhAnh1")
    private String hinhAnh1;
    @Column(name="HinhAnh2")
    private String hinhAnh2;
    @Column(name="HinhAnh3")
    private String hinhAnh3;
}