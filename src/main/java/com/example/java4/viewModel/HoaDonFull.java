package com.example.java4.viewModel;
import com.example.java4.entities.KhachHang;
import com.example.java4.entities.NhanVien;
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
public class HoaDonFull {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    @Column(name="NgayMuaHang")
    private Date ngayMuaHang;
    @Column(name = "TrangThai")
    private Integer trangThai;
}