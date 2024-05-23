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
@Table(name ="KichThuoc")
public class KichThuoc {
    @Id
    @Column(name="ID")
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="Indx")
    private Integer indx;
}