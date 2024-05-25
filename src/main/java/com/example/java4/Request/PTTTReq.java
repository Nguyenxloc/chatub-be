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
public class PTTTReq {
    private String id;
    @NotEmpty
    private String idHoaDon;
    @NotEmpty
    private String loaiPhuongThuc;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
