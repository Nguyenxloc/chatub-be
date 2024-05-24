package com.example.java4.RestControllers;

import com.example.java4.dto.nhan_vien.StoreRequest;
import com.example.java4.entities.NhanVien;
import com.example.java4.repositories.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("nhan_vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nvRepo;
    public NhanVienController() {
    }
    @GetMapping("/index")
    public ResponseEntity<List<NhanVien>> index() {
        return ResponseEntity.ok(nvRepo.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") NhanVien nv) {
        nvRepo.delete(nv);
    }

    @PostMapping("/update/{id}")
    public NhanVien doUpdate(
            @RequestBody @Valid StoreRequest newNhanVien,
            BindingResult result,@PathVariable(value="id") NhanVien nv
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        }
        else{
            nv.setMa(newNhanVien.getMa());
            nv.setTen(newNhanVien.getTen());
            nv.setMatKhau(newNhanVien.getMatKhau());
            nv.setTrangThai(newNhanVien.getTrangThai());
            nvRepo.save(nv);
        }
        return nv;
    }
    @PostMapping("save")
    public NhanVien save(
            @RequestBody @Valid StoreRequest newNhanVien,
            BindingResult result
    ) {
        NhanVien newNV = new NhanVien();
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return null;
        }
        else{
            newNV.setId(null);
            newNV.setMa(newNV.getMa());
            newNV.setTen(newNV.getTen());
            newNV.setMatKhau(newNV.getMatKhau());
            newNV.setTrangThai(newNV.getTrangThai());
            nvRepo.save(newNV);
        }
        return newNV;
    }
}