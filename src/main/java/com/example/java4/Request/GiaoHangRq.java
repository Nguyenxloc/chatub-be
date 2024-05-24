package com.example.java4.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiaoHangRq {
    private String id;
    @NotEmpty
    private String hoTen;
    @NotEmpty
    private String sdt;
    @NotEmpty
    private String diaChi;
    @NotEmpty
    private String phuongXa;
    @NotEmpty
    private String quanHuyen;
    @NotEmpty
    private String tinhThanh;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
