package com.example.java4.requestUpdate;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienUpdate {
    @NotEmpty
    private String hoTen;
    @NotEmpty
    private String gioiTinh;
    @NotEmpty
    private String ngaySinh;
    @NotEmpty
    private String sdt;
    @NotEmpty
    private String matKhau;
    private String idCV;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String  ngayTao;
    @NotEmpty
    private String idPhuongXa;
    @NotEmpty
    private String idQuanHuyen;
    @NotEmpty
    private String idTinhThanh;
    @NotEmpty
    private String phuongXa;
    @NotEmpty
    private String quanHuyen;
    @NotEmpty
    private String tinhThanh;
}
