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
    private Integer id;
    @Column(name="IdHoaDon")
    private Integer idHoaDon;
    @Column(name="IdChiTietSP")
    private Integer idChiTietSP;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
    @Column(name="SoLuong")
    private Integer soLuong;
}