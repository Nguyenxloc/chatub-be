package com.example.java4.RestControllers;

import com.example.java4.Request.ChiTietSPRQ;
import com.example.java4.entities.ChiTietSP;
import com.example.java4.entitiesNoMap.ChiTietSPNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.ChiTietSPfullRepositoryNoMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("chi-tiet-sp")
public class ChiTietSPController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    KichThuocRepository kichThuocRepo;
    @Autowired
    MauSacRepository mauSacRepo;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;
    @Autowired
    ChiTietSPfullRepositoryNoMap chiTietSPfullRepositoryNoMap;

    public ChiTietSPController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ChiTietSP>> index() {
        return ResponseEntity.ok(chiTietSPRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChiTietSP> getDetail(@PathVariable(value ="id") ChiTietSP chiTietSP){
        return  ResponseEntity.ok(chiTietSP);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") ChiTietSP spct) {
        chiTietSPRepository.delete(spct);
    }

    @PostMapping("save")
    public ChiTietSPNoMap Store(
            @RequestBody @Valid ChiTietSPRQ newChiTietSP,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return null;
        } else {
            ChiTietSPNoMap chiTietSP = new ChiTietSPNoMap();
            chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
            chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
            chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
            chiTietSP.setMoTa(newChiTietSP.getMoTa());
            chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
            chiTietSP.setNgayTao(Date.valueOf(newChiTietSP.getNgayTao()));
            chiTietSP.setTrangThai(Integer.valueOf( newChiTietSP.getTrangThai()));
            chiTietSPfullRepositoryNoMap.save(chiTietSP);
            return chiTietSP;
        }
    }
}