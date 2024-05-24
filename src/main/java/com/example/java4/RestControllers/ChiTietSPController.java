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
@Controller
@RequestMapping("spct")
public class ChiTietSPController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    SanPhamRepository spRepo;
    @Autowired
    MauSacRepository msRepo;
    @Autowired
    KichThuocRepository ktRepo;
    @Autowired
    MauSacRepository mauSacRepo;
    @Autowired
    ChiTietSPRepository spctRepo;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;

    public ChiTietSPController() {
    }

    @GetMapping("/index")
    public ResponseEntity<List<ChiTietSP>> index() {
        return ResponseEntity.ok(chiTietSPRepository.findAll());
    }

    @GetMapping("/detail/{id}")
    public ChiTietSP getDetail(@PathVariable(name="id")ChiTietSPRQ newChiTietSP,BindingResult rs){
           if(rs.hasErrors()){
               System.out.println("please input valid data");
               return null;
           }
           else{
               ChiTietSP chiTietSP = new ChiTietSP();
               chiTietSP.setId(newChiTietSP.getId());
               chiTietSP.setIdSp(newChiTietSP.getIdSp());
               chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
               chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
               chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
               chiTietSP.setMoTa(newChiTietSP.getMoTa());
               chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
               chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
               chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
               chiTietSP.setNgayTao(Date.valueOf(newChiTietSP.getNgayTao()));
               chiTietSP.setTrangThai(Integer.valueOf( newChiTietSP.getTrangThai()));
               return  chiTietSP;
           }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") ChiTietSP spct) {
        spctRepo.delete(spct);
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
            chiTietSP.setIdSp(newChiTietSP.getIdSp());
            chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
            chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
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