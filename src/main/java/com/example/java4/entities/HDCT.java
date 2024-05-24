package com.example.java4.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HoaDonChiTiet")
public class HDCT {
    @Id
    @Column(name="IdHDCT")
    private String id;
    @ManyToOne
    @JoinColumn(name="IdHoaDon",referencedColumnName = "IdHoaDon")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name ="IdChiTietSP", referencedColumnName = "IdChiTietSP")
    private ChiTietSP chiTietSP;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="SoLuong")
    private Integer soLuong;
}