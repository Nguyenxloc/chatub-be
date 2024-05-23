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
    @Column(name="IdPTTT")
    private String idPTTT;
    @Column(name="idKM")
    private String idKM;
    @Column(name="IdNV")
    private Integer idNV;
    @Column(name="IdKH")
    private String idKH;
    @Column(name="IdShip")
    private String idShip;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name="TrangThai")
    private int trangThai;
    @Column(name="indx")
    private int indx;
}