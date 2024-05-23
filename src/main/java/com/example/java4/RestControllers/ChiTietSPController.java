package com.example.java4.RestControllers;

import com.example.java4.dto.spct.StoreRequest;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("spct")
public class ChiTietSPController {
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
    ChiTietSPRepository spctRepo;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;

    public ChiTietSPController() {
        rem = new StoreRequest();
    }

    @GetMapping("/index")
    public ResponseEntity<List<ChiTietSP>> index(Model model) {
        return ResponseEntity.ok(chiTietSPRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") ChiTietSP spct) {
        spctRepo.delete(spct);
    }

    @PostMapping("save")
    public ChiTietSP Store(
            @RequestParam @Valid StoreRequest newSPCT,
            BindingResult result
    ) {
        ChiTietSP spct = new ChiTietSP();
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
        } else {
            spct.setSoLuong(Integer.valueOf(newSPCT.getSoLuong()));
            spct.setTrangThai(Integer.valueOf(newSPCT.getTrangThai()));
            spct.setIdMauSac(newSPCT.getIdMauSac());
            spct.setIdKichThuoc(newSPCT.getIdKichThuoc());
            spct = spctRepo.save(spct);
        }
        return  spct;
    }
}