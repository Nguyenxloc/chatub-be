package com.example.java4.entitiesLv2;
import com.example.java4.entitiesLv1.KhachHang;
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
@Table(name = "diaChi")
public class DiaChi {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="IdKH",referencedColumnName = "id")
    private KhachHang kh;
    @ManyToOne
    @JoinColumn(name="IdNV",referencedColumnName = "id")
    private NhanVien nv;
    @Column(name="DiaChi")
    private String diaChi;
    @ManyToOne
    @JoinColumn(name="IdPhuongXa",referencedColumnName = "id")
    private PhuongXa phuongXa;
    @ManyToOne
    @JoinColumn(name="IdQuanHuyen",referencedColumnName = "id")
    private QuanHuyen quanHuyen;
    @ManyToOne
    @JoinColumn(name="IdTinhThanh",referencedColumnName = "id")
    private TinhThanh tinhThanh;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date NgayTao;
}
