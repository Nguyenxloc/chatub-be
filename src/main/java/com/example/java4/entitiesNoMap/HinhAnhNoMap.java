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
    @Column(name ="Url")
    private String url;
    @Column(name ="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
