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
public class KhachHangReq {
    private String id;
    private String ma;
    @NotEmpty
    private String ten;
    @NotEmpty
    private String tenDem;
    @NotEmpty
    private String ho;
    @NotEmpty
    private String ngaySinh;
    @NotEmpty
    private String sdt;
    @NotEmpty
    private String diaChi;
    @NotEmpty
    private String thanhPho;
    @NotEmpty
    private String quocGia;
    @NotEmpty
    private String matKhau;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String indx;
    @NotEmpty
    private String trangThai;
}
