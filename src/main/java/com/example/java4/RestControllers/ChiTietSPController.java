package com.example.java4.RestControllers;

import com.example.java4.Request.ChiTietSPRQ;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("chi-tiet-sp")
public class ChiTietSPController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    KichThuocRepository kichThuocRepo;
    @Autowired
    MauSacRepository mauSacRepo;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;

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

    public ChiTietSP Store(
            @RequestBody @Valid ChiTietSPRQ newChiTietSP,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return null;
        } else {
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setId(newChiTietSP.getId());
            chiTietSP.setMauSac(mauSacRepo.findById(newChiTietSP.getIdMauSac()).get());
            chiTietSP.setKichThuoc(kichThuocRepo.findById(newChiTietSP.getIdKichThuoc()).get());
            chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
            chiTietSP.setMoTa(newChiTietSP.getMoTa());
            chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
            chiTietSP.setNgayTao(Date.valueOf(newChiTietSP.getNgayTao()));
            chiTietSP.setTrangThai(Integer.valueOf( newChiTietSP.getTrangThai()));
            return chiTietSP;
        }
    }
}