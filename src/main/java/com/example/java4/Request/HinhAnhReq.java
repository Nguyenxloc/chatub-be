package com.example.java4.Request;
import com.example.java4.entities.ChiTietSP;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnhReq {
    private String id;
    @NotEmpty
    private String idChiTietSP;
    @NotEmpty
    private String url;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
