package com.example.java4.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuRq {
    private String id;
    private String ma;
    @NotEmpty
    private String ten;
    @Positive
    private String trangThai;
    @Past
    private Date ngayTao;
    private Integer indx;
}
