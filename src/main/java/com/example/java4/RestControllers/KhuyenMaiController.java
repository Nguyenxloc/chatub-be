package com.example.java4.RestControllers;
import com.example.java4.Request.KhuyenMaiReq;
import com.example.java4.entities.KhuyenMai;
import com.example.java4.entitiesNoMap.KhuyenMaiNoMap;
import com.example.java4.repositories.KhuyenMaiRepository;
import com.example.java4.repositoriesNoMap.KhuyenMaiRepoNoMap;
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

    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") KhuyenMai khuyenMai){
        khuyenMaiRepo.delete(khuyenMai);
    }

    @PostMapping ("/update/{id}")
    public KhuyenMai doUpdate(@RequestBody @Valid KhuyenMaiReq newKhuyenMai, BindingResult result, @PathVariable(value ="id") KhuyenMai khuyenMai){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            //call procedure
            return khuyenMai;
        }
    }

    @PostMapping("save")
    public KhuyenMaiNoMap save(
            @RequestBody @Valid KhuyenMaiReq newKhuyenMai,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
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
            //call procedure
            return khuyenMai;
        }
    }
}