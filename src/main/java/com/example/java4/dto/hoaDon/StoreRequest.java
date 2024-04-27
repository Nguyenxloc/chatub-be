package com.example.java4.dto.hoaDon;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequest {
    private Integer id;
    @NotNull(message = "do not empty this field")
    private String idKH;
    @NotNull(message = "do not empty this field")
    private String idNV;
    @NotNull(message = "do not empty this field")
    private String ngayMuaHang;
    @NotNull(message = "do not empty this field")
    private String trangThai;
}