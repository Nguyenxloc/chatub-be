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
public class KhachHangUpdate {
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
    private String matKhau;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String trangThai;
}
