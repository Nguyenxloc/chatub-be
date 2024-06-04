package com.example.java4.entitiesLv2;

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
@Table(name = "diachiNV")
public class DiaChiNV {
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
    @JoinColumn(name="IdNV", referencedColumnName = "Id")
    private NhanVien nv;
}
