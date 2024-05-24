package com.example.java4.Request;

import com.example.java4.entities.ChiTietSP;
import com.example.java4.entities.HoaDon;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

import java.sql.Date;

public class HDCTReq {
    private String id;
    @NotEmpty
    private String idHoaDon;
    @NotEmpty
    private String  idChiTietSP;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String soLuong;
}
