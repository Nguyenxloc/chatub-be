package com.example.java4.RestControllers;

import com.example.java4.Request.ChiTietSPRQ;
import com.example.java4.entities.ChiTietSP;
import com.example.java4.entitiesNoMap.ChiTietSPNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.ChiTietSPRepoNoMap;
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
    ChiTietSPRepoNoMap chiTietSPRepoNoMap;

    public ChiTietSPController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ChiTietSP>> index() {
        return ResponseEntity.ok(chiTietSPRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChiTietSP> getDetail(@PathVariable(value = "id") ChiTietSP chiTietSP) {
        return ResponseEntity.ok(chiTietSP);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(value = "id") ChiTietSPNoMap chiTietSP,
                                            @RequestBody @Valid ChiTietSPRQ newChiTietSP,
                                            BindingResult rs) {
          if(rs.hasErrors()){
              System.out.println("update error: "+rs);
              return ResponseEntity.ok(false);
          } else{
              chiTietSP.setIdSp(newChiTietSP.getIdSp());
              chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
              chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
              chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
              chiTietSP.setMoTa(newChiTietSP.getMoTa());
              chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
              chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
              chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
              chiTietSP.setNgayTao(Date.valueOf(newChiTietSP.getNgayTao()));
              chiTietSP.setTrangThai(Integer.valueOf(newChiTietSP.getTrangThai()));
              chiTietSPRepoNoMap.save(chiTietSP);
              return  ResponseEntity.ok(true);
          }
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid ChiTietSPRQ newChiTietSP,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: " + result);
            return ResponseEntity.ok(false);
        } else {
            ChiTietSPNoMap chiTietSP = new ChiTietSPNoMap();
            chiTietSP.setIdSp(newChiTietSP.getIdSp());
            chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
            chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
            chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
            chiTietSP.setMoTa(newChiTietSP.getMoTa());
            chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
            chiTietSP.setNgayTao(Date.valueOf(newChiTietSP.getNgayTao()));
            chiTietSP.setTrangThai(Integer.valueOf(newChiTietSP.getTrangThai()));
            chiTietSPRepoNoMap.save(chiTietSP);
            return ResponseEntity.ok(true);
        }
    }
}