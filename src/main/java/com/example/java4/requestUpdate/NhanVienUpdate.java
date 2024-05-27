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
    private String ten;
    @NotEmpty
    private String tenDem;
    @NotEmpty
    private String ho;
    @NotEmpty
    private String gioiTinh;
    @NotEmpty
    private String ngaySinh;
    @NotEmpty
    private String diaChi;
    @NotEmpty
    private String sdt;
    @NotEmpty
    private String matKhau;
    @NotEmpty
    private String idCV;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String  ngayTao;
}
