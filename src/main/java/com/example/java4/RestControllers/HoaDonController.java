package com.example.java4.RestControllers;
import com.example.java4.dto.hoaDon.StoreRequest;
import com.example.java4.entities.HoaDon;
import com.example.java4.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("hoa_don")
public class HoaDonController {
    StoreRequest rem = new StoreRequest();
    @Autowired
    private HoaDonRepository hdRepo;
    public HoaDonController() {
    }
    @GetMapping("index")
    public ResponseEntity<List<HoaDon>> index() {
        return ResponseEntity.ok(hdRepo.findAll());
    }

    @PostMapping("update/{id}")
    public String doUpdate(
            @RequestBody  @Valid StoreRequest newHoaDon,
            BindingResult result, @PathVariable(value = "id") HoaDon hd
    ) {
        if (result.hasErrors()){
            System.out.println("tempt error: "+result);
            return null;
        }
        else{
            hd.setIdKH(newHoaDon.getIdKH());
            hd.setIdNV(Integer.valueOf(newHoaDon.getIdNV()));
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayMuaHang()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hdRepo.save(hd);
            return "redirect:/hoa_don/index";
        }
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") HoaDon hd) {
        hdRepo.delete(hd);
    }

    @PostMapping("save")
    public HoaDon save(
            @RequestBody @Valid StoreRequest newHoaDon,
            BindingResult result
    ) {
        HoaDon hd = new HoaDon();
        if (result.hasErrors()){
            System.out.println("temp error: "+ result);
            return null;
        }
        else{
            hd.setId(null);
            hd.setIdKH(newHoaDon.getIdKH());
            hd.setIdNV(Integer.valueOf(newHoaDon.getIdNV()));
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayMuaHang()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hd = hdRepo.save(hd);
        }
        return hd;
    }
}