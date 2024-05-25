package com.example.java4.Request;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonReq {
    private String id;
    private String ma;
    @NotEmpty
    private String  IdPTTT;
    @NotEmpty
    private String IdKhuyenMai;
    @NotEmpty
    private String IdNhanVien;
    @NotEmpty
    private String IdKhachHang;
    @NotEmpty
    private String IdGiaoHang;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String ngayThanhToan;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String indx;
}