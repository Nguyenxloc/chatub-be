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
@Table(name = "pttt")
public class PTTT {
    @Id
    @Column(name="Id")
    private String id;
    @ManyToOne
    @JoinColumn(name="IdHoaDon",referencedColumnName = "Id")
    private HoaDon hoaDon;
    @Column(name ="LoaiPhuongThuc")
    private String loaiPhuongThuc;
    @Column(name ="TrangThai")
    private String trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="indx")
    private Integer indx;
}
