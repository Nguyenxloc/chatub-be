package com.example.java4.controllers;

import com.example.java4.dto.sale.NewHDCTRequest;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
import com.example.java4.viewModel.SPCTfull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("sale")
public class SaleController {
    @Autowired
    HoaDonFullRepository hdRepo;
    @Autowired
    SPCTfullRepository spctRepo;
    @Autowired
    HDCTfullRepository hdctRepo;
    @Autowired
    NhanVienRepository nvRepo;
    @Autowired
    KhachHangRepository khRepo;
    @Autowired
    HoaDonRepository hdBaseRepo;
    @Autowired
    HDCTRepository hdctBaseRepo;
    @Autowired
    SPCTRepository spctBaseRepo;
    public SaleController() {
    }

    @PostMapping("/addNewHD")
    public HoaDon  addNewHD() {
        HoaDon hd = new HoaDon(null, 1, 1, new Date(System.currentTimeMillis()), 0);
        hdBaseRepo.save(hd);
        return hd;
    }

    @GetMapping("/addToCart/")
    public void addToCart (@RequestParam(value = "idHD") HoaDon hd, @RequestParam(value = "idSPCT") SPCT spct) {
        Integer idSPCT = spct.getId();
        spct.setSoLuong(spct.getSoLuong()-1);
        HDCT hdct = new HDCT(null, hd.getId(), idSPCT, 1, (int) spctBaseRepo.findById(idSPCT).get().getDonGia(), new Timestamp(System.currentTimeMillis()), 1);
        hdctBaseRepo.save(hdct);
        spctBaseRepo.save(spct);
    }

    @PostMapping("/check/{id}")
    public void check(@PathVariable(value = "id") HoaDon hd) {
        hd.setTrangThai(1);
        hdBaseRepo.save(hd);
    }

    @GetMapping("/index/")
    public ResponseEntity<List<SPCTfull>> GetIndex(@RequestParam("page") Optional<Integer> pageParams) {
        int page = pageParams.orElse(0);
        Pageable p = PageRequest.of(page, 5);
        Page<SPCTfull> pageData = spctRepo.findByTrangThai(MauSacRepository.ACTIVE, p);
        return ResponseEntity.ok(pageData.getContent());
    }
}