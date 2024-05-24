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
@Table(name = "hinhanh")
public class HinhAnh {
    @Id
    @Column(name="Id")
    private String id;
    @ManyToOne
    @JoinColumn(name="IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSP chiTietSP;
    @Column(name ="Url")
    private String url;
    @Column(name ="TrangThai")
    private String trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
