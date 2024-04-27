package com.example.java4.dto.spct;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequest {
    private Integer id;
    @NotNull(message = "Do not empty idKichThuoc")
    private String idKichThuoc;
    @NotNull(message = "Do not empty idMauSac")
    private String idMauSac;
    @NotNull(message = "Do not empty idSanPham")
    private String idSanPham;
    @NotBlank(message = "Do not empty maSPCT")
    private String maSPCT;
    private String soLuong;
    private String donGia;
    private String trangThai;
}