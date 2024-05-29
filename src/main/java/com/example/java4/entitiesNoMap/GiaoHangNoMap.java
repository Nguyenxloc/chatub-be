package com.example.java4.entitiesNoMap;
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
public class GiaoHangNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="Sdt")
    private String sdt;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name="IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String idTinhThanh;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
