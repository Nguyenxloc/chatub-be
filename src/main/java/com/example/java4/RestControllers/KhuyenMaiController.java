package com.example.java4.RestControllers;
import com.example.java4.requestStore.KhuyenMaiStore;
import com.example.java4.entitiesLv2.KhuyenMai;
import com.example.java4.entitiesNoMap.KhuyenMaiNoMap;
import com.example.java4.repositories.KhuyenMaiRepository;
import com.example.java4.repositoriesNoMap.KhuyenMaiRepoNoMap;
import com.example.java4.requestUpdate.KhuyenMaiUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepo;
    @Autowired
    KhuyenMaiRepoNoMap khuyenMaiRepoNoMap;
    public KhuyenMaiController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KhuyenMai>> index(){
        return ResponseEntity.ok(khuyenMaiRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("detail/{id}")
    public ResponseEntity<KhuyenMai> getDetail(@PathVariable(value = "id") KhuyenMai khuyenMai){
        return ResponseEntity.ok(khuyenMai);
    }
    @CrossOrigin
    @PostMapping ("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@RequestBody @Valid KhuyenMaiUpdate newKhuyenMai, BindingResult result,
                                            @PathVariable(value ="id") KhuyenMaiNoMap khuyenMai){
        if (result.hasErrors()) {
            System.out.println("error at khuyen mai "+result);
            return ResponseEntity.ok(false);
        }
        else{
            khuyenMai.setTen(newKhuyenMai.getTen());
            khuyenMai.setNgayBatDau(Date.valueOf(newKhuyenMai.getNgayBatDau()));
            khuyenMai.setNgayKetThuc(Date.valueOf(newKhuyenMai.getNgayKetThuc()));
            khuyenMai.setIdHinhThucKM(newKhuyenMai.getIdHinhThucKM());
            khuyenMai.setGiaTriGiam(Float.valueOf(newKhuyenMai.getGiaTriGiam()));
            khuyenMai.setTrangThai(Integer.valueOf(newKhuyenMai.getTrangThai()));
            khuyenMaiRepoNoMap.save(khuyenMai);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khuyenMaiRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khuyenMaiRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid KhuyenMaiStore newKhuyenMai,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            KhuyenMaiNoMap khuyenMai = new KhuyenMaiNoMap();
            khuyenMai.setMa(newKhuyenMai.getMa());
            khuyenMai.setTen(newKhuyenMai.getTen());
            khuyenMai.setNgayBatDau(Date.valueOf(newKhuyenMai.getNgayBatDau()));
            khuyenMai.setNgayKetThuc(Date.valueOf(newKhuyenMai.getNgayKetThuc()));
            khuyenMai.setIdHinhThucKM(newKhuyenMai.getIdHinhThucKM());
            khuyenMai.setGiaTriGiam(Float.valueOf(newKhuyenMai.getGiaTriGiam()));
            khuyenMai.setTrangThai(Integer.valueOf(newKhuyenMai.getTrangThai()));
            khuyenMaiRepoNoMap.save(khuyenMai);
            //call procedure
            return ResponseEntity.ok(true);
        }
    }
}