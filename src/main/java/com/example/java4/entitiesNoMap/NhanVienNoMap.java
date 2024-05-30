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
@Table(name="nhanvien")
public class NhanVienNoMap {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name ="Ma")
    private String ma;
    @Column(name ="HoTen")
    private String hoTen;
    @Column(name="GioiTinh")
    private String gioiTinh;
    @Column(name="NgaySinh")
    private Date ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="IdCV")
    private String idChucVu;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private  Date ngayTao;
}