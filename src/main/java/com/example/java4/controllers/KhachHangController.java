package com.example.java4.controllers;

import com.example.java4.dto.khach_hang.StoreRequest;
import com.example.java4.entities.HoaDon;
import com.example.java4.entities.KhachHang;
import com.example.java4.repositories.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("khach_hang")
public class KhachHangController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    KhachHangRepository khRepo;
    public KhachHangController() {

    }

    @GetMapping("/index")
    public ResponseEntity<List<KhachHang>> index(Model model) {
        return ResponseEntity.ok(khRepo.findAll()) ;
    }

    @PostMapping("/update/{id}")
    public KhachHang doUpdate(@Valid @RequestBody StoreRequest newKH,
                           BindingResult result, @PathVariable(value = "id") KhachHang kh) {
        KhachHang value = new KhachHang();
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return null;
        } else {
            kh.setMa(newKH.getMa());
            kh.setSdt(newKH.getSdt());
            kh.setTen(newKH.getTen());
            kh.setTrangThai(newKH.getTrangThai());
            value=khRepo.save(kh);
        }
        return value;
    }

    @GetMapping("/delete/{id}")
    public void delete(Model model, @PathVariable(value = "id") KhachHang kh) {
        khRepo.delete(kh);
        System.out.println("delete succesfully !");
    }

    @PostMapping("save")
    public KhachHang save(
            @RequestBody @Valid StoreRequest req,
            BindingResult result
    ) {
        KhachHang newKh = new KhachHang();
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return null;
        } else {
            newKh.setId(null);
            newKh.setMa(req.getMa());
            newKh.setTen(req.getTen());
            newKh.setSdt(req.getSdt());
            newKh.setTrangThai(req.getTrangThai());
            khRepo.save(newKh);
        }
        return newKh;
    }
}