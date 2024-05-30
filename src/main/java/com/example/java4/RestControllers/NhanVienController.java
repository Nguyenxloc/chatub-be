package com.example.java4.RestControllers;
import com.example.java4.requestStore.NhanVienStore;
import com.example.java4.entitiesLv2.NhanVien;
import com.example.java4.entitiesNoMap.NhanVienNoMap;
import com.example.java4.repositories.NhanVienRepository;
import com.example.java4.repositoriesNoMap.NhanVienRepoNoMap;
import com.example.java4.requestUpdate.NhanVienUpdate;
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
    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid NhanVienUpdate newNhanVien,
            BindingResult result,@PathVariable(value="id") NhanVienNoMap nv
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            nv.setHoTen(newNhanVien.getHoTen());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
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
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(nvRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(nvRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid NhanVienStore newNhanVien,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        }
        else{
            NhanVienNoMap nv = new NhanVienNoMap();
            nv.setMa(newNhanVien.getMa());
            nv.setHoTen(newNhanVien.getHoTen());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
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