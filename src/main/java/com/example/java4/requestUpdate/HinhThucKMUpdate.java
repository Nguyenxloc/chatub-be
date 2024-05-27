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
public class HinhThucKMUpdate {
    @NotEmpty
    private String loaiPhuongThuc;
    @NotEmpty
    private String heSo;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
