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
public class GiaoHangUpdate {
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
