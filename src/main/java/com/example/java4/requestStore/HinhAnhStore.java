package com.example.java4.requestStore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnhStore {
    private String id;
    @NotEmpty
    private String idChiTietSP;
    @NotEmpty
    private String hinh1;
    @NotEmpty
    private String hinh2;
    @NotEmpty
    private String hinh3;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
