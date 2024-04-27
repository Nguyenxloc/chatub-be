package com.example.java4.controllers;

import com.example.java4.dto.spct.StoreRequest;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
import com.example.java4.viewModel.SPCTfull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("spct")
public class SPCTController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    StoreRequest rem;
    @Autowired
    SanPhamRepository spRepo;
    @Autowired
    MauSacRepository msRepo;
    @Autowired
    KichThuocRepository ktRepo;
    @Autowired
    MauSacRepository mauSacRepo;
    @Autowired
    SPCTRepository spctRepo;
    @Autowired
    SPCTfullRepository spcTfullRepository;

    public SPCTController() {
        rem = new StoreRequest();
    }

    @GetMapping("/index")
    public ResponseEntity<List<SPCTfull>> index(Model model) {
        return ResponseEntity.ok(spcTfullRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") SPCT spct) {
        spctRepo.delete(spct);
    }

    @PostMapping("save")
    public SPCT Store(
            @RequestParam @Valid StoreRequest newSPCT,
            BindingResult result
    ) {
        SPCT spct = new SPCT();
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
        } else {
            spct.setMaSPCT(newSPCT.getMaSPCT());
            spct.setSoLuong(Integer.valueOf(newSPCT.getSoLuong()));
            spct.setTrangThai(Integer.valueOf(newSPCT.getTrangThai()));
            spct.setDonGia(Double.valueOf(newSPCT.getDonGia()));
            spct.setIdMauSac(Integer.valueOf(newSPCT.getIdMauSac()));
            spct.setIdSanPham(Integer.valueOf(newSPCT.getIdSanPham()));
            spct.setIdKichThuoc(Integer.valueOf(newSPCT.getIdKichThuoc()));
            spct = spctRepo.save(spct);
        }
        return  spct;
    }
}