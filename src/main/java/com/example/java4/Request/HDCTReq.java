package com.example.java4.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
