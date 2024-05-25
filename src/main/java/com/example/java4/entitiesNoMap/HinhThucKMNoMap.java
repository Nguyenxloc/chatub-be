package com.example.java4.entitiesNoMap;


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
@Table(name = "hinhthuckm")
public class HinhThucKMNoMap {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="LoaiPhuongThuc")
    private String loaiPhuongThuc;
    @Column(name ="HeSo")
    private Float heSo;
    @Column(name ="TrangThai")
    private String trangThai;
    @Column(name="NgayTao")
    private Date ngayTao;
}
