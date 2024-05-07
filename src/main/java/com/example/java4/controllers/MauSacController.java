package com.example.java4.controllers;

import com.example.java4.dto.mau_sac.StoreRequest;
import com.example.java4.entities.MauSac;
import com.example.java4.repositories.MauSacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("mau_sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;
    public MauSacController() {
    }

    @GetMapping("index")
    public ResponseEntity<List<MauSac>> index() {
        return ResponseEntity.ok(msRepo.findAll());
    }

    @PostMapping("update/{id}")
    public MauSac doUpdate(
            @RequestBody @Valid StoreRequest req,
            BindingResult result, @PathVariable(value = "id") MauSac ms
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return null;
        }
        else{
            ms.setTen(req.getTen());
            ms.setMa(req.getMa());
            ms.setTrangThai(req.getTrangThai());
            msRepo.save(ms);
        }
        return ms;
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") MauSac ms) {
        msRepo.delete(ms);
    }

    @PostMapping("save")
    public MauSac save(
            @RequestBody @Valid StoreRequest newMauSac,
            BindingResult result
    ) {
        MauSac ms = new MauSac();
        if (result.hasErrors()){
            System.out.println("error temp: "+ result);
            return null;
        }
        else{
            ms.setId(null);
            ms.setTen(newMauSac.getTen());
            ms.setMa(newMauSac.getMa());
            ms.setTrangThai(1);
            msRepo.save(ms);
        }
        return ms;
    }
}