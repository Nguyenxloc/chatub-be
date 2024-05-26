package com.example.java4.RestControllers;
import com.example.java4.Request.HinhAnhReq;
import com.example.java4.Request.SanPhaRq;
import com.example.java4.entities.HinhAnh;
import com.example.java4.entities.SanPham;
import com.example.java4.entitiesNoMap.HinhAnhNoMap;
import com.example.java4.repositories.HinhAnhRepository;
import com.example.java4.repositoriesNoMap.HinhAnhRepoNoMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("hinh-anh")
public class HinhAnhController {
    @Autowired
    HinhAnhRepository hinhAnhRepo;
    @Autowired
    HinhAnhRepoNoMap hinhAnhRepoNoMap;
    public HinhAnhController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<HinhAnh>> index(){
        return ResponseEntity.ok(hinhAnhRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HinhAnh> getDetail(@PathVariable(value = "id") HinhAnh hinhAnh){
            return ResponseEntity.ok(hinhAnh);
    }
    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") HinhAnh hinhAnh){
        hinhAnhRepo.delete(hinhAnh);
    }

    @PostMapping ("/update/{id}")
    public HinhAnh doUpdate(@RequestBody @Valid HinhAnhReq newHinhAnh, BindingResult result, @PathVariable(value ="id") HinhAnh hinhAnh){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            //call procedure
            return hinhAnh;
        }
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HinhAnhReq newHinhAnh,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            HinhAnhNoMap hinhAnh = new HinhAnhNoMap();
            hinhAnh.setIdChiTietSP(newHinhAnh.getIdChiTietSP());
            hinhAnh.setUrl(newHinhAnh.getUrl());
            hinhAnh.setTrangThai(Integer.valueOf(newHinhAnh.getTrangThai()));
            hinhAnh.setNgayTao(Date.valueOf(newHinhAnh.getNgayTao()));
            hinhAnhRepoNoMap.save(hinhAnh);
            return ResponseEntity.ok(true);
        }
    }
}