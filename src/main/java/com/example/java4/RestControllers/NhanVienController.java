package com.example.java4.RestControllers;
import com.example.java4.Request.NhanVienRq;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nvRepo;
    public NhanVienController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<NhanVien>> index() {
        return ResponseEntity.ok(nvRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<NhanVien> getDetail(@PathVariable("id") NhanVien nhanVien){
        return  ResponseEntity.ok(nhanVien);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") NhanVien nv) {
        nvRepo.delete(nv);
    }

    @PostMapping("/update/{id}")
    public NhanVien doUpdate(
            @RequestBody @Valid NhanVienRq newNhanVien,
            BindingResult result,@PathVariable(value="id") NhanVien nv
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        }
        else{

            nvRepo.save(nv);
        }
        return nv;
    }
    @PostMapping("save")
    public NhanVien save(
            @RequestBody @Valid NhanVien newNhanVien,
            BindingResult result
    ) {
        NhanVien newNV = new NhanVien();
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return null;
        }
        else{
            nvRepo.save(newNV);
        }
        return newNV;
    }
}