package com.example.java4.Request;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaChiRq{
    private String id;
    @NotEmpty
    private String idKH;
    @NotEmpty
    private String diaChi;
    @NotEmpty
    private String idPhuongXa;
    @NotEmpty
    private String idQuanHuyen;
    @NotEmpty
    private String idTinhThanh;
    @Positive
    private String trangThai;
    @Past
    private String NgayTao;
}
