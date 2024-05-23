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
@Table(name = "khuyenmai")
public class KhuyenMai {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name ="Ten")
    private String ten;
    @Column(name ="NgayBatDau")
    private Date ngayBatDau;
    @Column(name="NgayKetThuc")
    private Date ngayKetThuc;
    @Column(name="IdHinhThucKM")
    private String idHinhThucKM;
    @Column(name="GiaTriGiam")
    private Float giaTriGiam;
    @Column(name="indx")
    private Integer indx;
}
