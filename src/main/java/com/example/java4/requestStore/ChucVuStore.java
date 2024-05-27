package com.example.java4.requestStore;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChucVuStore {
    private String id;
    private String ma;
    @NotEmpty
    private String ten;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String ngayTao;
}
