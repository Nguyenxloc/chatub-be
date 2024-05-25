package com.example.java4.Request;

import jakarta.validation.constraints.NotEmpty;

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
