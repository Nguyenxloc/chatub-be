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

    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid NhanVienRq newNhanVien,
            BindingResult result,@PathVariable(value="id") NhanVienNoMap nv
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            nv.setTen(newNhanVien.getTen());
            nv.setTenDem(newNhanVien.getTenDem());
            nv.setHo(newNhanVien.getHo());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
            nv.setDiaChi(newNhanVien.getDiaChi());
            nv.setSdt(newNhanVien.getSdt());
            nv.setMatKhau(newNhanVien.getMatKhau());
            nv.setIdChucVu(newNhanVien.getIdCV());
            nv.setTrangThai(Integer.valueOf(newNhanVien.getTrangThai()));
            nv.setNgayTao(Date.valueOf(newNhanVien.getNgayTao()));
            nhanVienRepoNoMap.save(nv);
            return ResponseEntity.ok(true);
        }
    }
    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid NhanVienRq newNhanVien,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        }
        else{
            NhanVienNoMap nv = new NhanVienNoMap();
            nv.setMa(newNhanVien.getMa());
            nv.setTen(newNhanVien.getTen());
            nv.setTenDem(newNhanVien.getTenDem());
            nv.setHo(newNhanVien.getHo());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
            nv.setDiaChi(newNhanVien.getDiaChi());
            nv.setSdt(newNhanVien.getSdt());
            nv.setMatKhau(newNhanVien.getMatKhau());
            nv.setIdChucVu(newNhanVien.getIdCV());
            nv.setTrangThai(Integer.valueOf(newNhanVien.getTrangThai()));
            nv.setNgayTao(Date.valueOf(newNhanVien.getNgayTao()));
            nhanVienRepoNoMap.save(nv);
            return ResponseEntity.ok(true);
        }
    }
}