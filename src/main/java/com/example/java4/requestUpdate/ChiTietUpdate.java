package com.example.java4.requestUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietUpdate {
    @NotEmpty
    private String idMauSac;
    @NotEmpty
    private String idKichThuoc;
    @Positive
    private String namBH;
    @NotEmpty
    private String moTa;
    @Positive
    private String soLuongTon;
    @Positive
    private String giaNhap;
    @Positive
    private String giaBan;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String  trangThai;
}
