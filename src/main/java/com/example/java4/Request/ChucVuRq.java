package com.example.java4.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class ChucVuRq {
    private String id;
    private String ma;
    @NotEmpty
    private String ten;
    @Column(name ="TrangThai")
    private String trangThai;
    @Column(name="NgayTao")
    private String ngayTao;
    @Column(name="indx")
    private String indx;
}
