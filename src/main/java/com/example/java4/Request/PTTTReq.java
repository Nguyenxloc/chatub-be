package com.example.java4.Request;

import com.example.java4.entities.HoaDon;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class PTTTReq {
    private String id;
    @NotEmpty
    private String idHoaDon;
    @NotEmpty
    private String ma;
    @NotEmpty
    private String loaiPhuongThuc;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
    @NotEmpty
    private String indx;
}
