package com.example.java4.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "giaoHang")
public class DiaChi {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="IdKH")
    private String idKH;
    @Column(name="DiaChi")
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
    private Date NgayTao;
}
