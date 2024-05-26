package com.example.java4.RestControllers;
import com.example.java4.Request.NhanVienRq;
import com.example.java4.entities.NhanVien;
import com.example.java4.entitiesNoMap.NhanVienNoMap;
import com.example.java4.repositories.NhanVienRepository;
import com.example.java4.repositoriesNoMap.NhanVienRepoNoMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nvRepo;
    @Autowired
    NhanVienRepoNoMap nhanVienRepoNoMap;
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
    public NhanVienNoMap save(
            @RequestBody @Valid NhanVienRq newNhanVien,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return null;
        }
        else{
            NhanVienNoMap newNV = new NhanVienNoMap();
            newNV.setMa(newNhanVien.getMa());
            newNV.setTen(newNhanVien.getTen());
            newNV.setTenDem(newNhanVien.getTenDem());
            newNV.setHo(newNhanVien.getHo());
            newNV.setGioiTinh(newNhanVien.getGioiTinh());
            newNV.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
            newNV.setDiaChi(newNhanVien.getDiaChi());
            newNV.setSdt(newNhanVien.getSdt());
            newNV.setMatKhau(newNhanVien.getMatKhau());
            newNV.setIdChucVu(newNhanVien.getIdCV());
            newNV.setTrangThai(Integer.valueOf(newNhanVien.getTrangThai()));
            newNV.setNgayTao(Date.valueOf(newNhanVien.getNgayTao()));
            return nhanVienRepoNoMap.save(newNV);
        }
    }
}