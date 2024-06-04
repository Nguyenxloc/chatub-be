package com.example.java4.entitiesLv2;

import com.example.java4.RestControllers.KhachHangController;
import com.example.java4.entitiesLv1.KhachHang;
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
@Table(name = "diachiKH")
public class DiaChiKH {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name ="TrangThai")
    private Integer trangThai;
    @Column(name ="NgayTao")
    private Date ngayTao;
    @Column(name = "IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String idTinhThanh;
    @ManyToOne
    @JoinColumn(name="IdKH", referencedColumnName = "Id")
    private KhachHang khachHang;
}
