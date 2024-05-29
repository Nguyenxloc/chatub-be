package com.example.java4.entitiesNoMap;

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
public class HinhAnhNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="IdChiTietSP")
    private String idChiTietSP;
    @Column(name ="hinh1")
    private String hinh1;
    @Column(name ="hinh2")
    private String hinh2;
    @Column(name ="hinh3")
    private String hinh3;
    @Column(name ="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
