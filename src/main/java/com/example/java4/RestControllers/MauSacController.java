package com.example.java4.RestControllers;
import com.example.java4.requestStore.MauSacStore;
import com.example.java4.entities.MauSac;
import com.example.java4.repositories.MauSacRepository;
import com.example.java4.requestUpdate.MauSacUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;
    public MauSacController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<MauSac>> index() {
        return ResponseEntity.ok(msRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<MauSac> getDetail(@PathVariable("id") MauSac mauSac){
        return ResponseEntity.ok(mauSac);
    }
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid MauSacUpdate newMauSac,
            BindingResult result, @PathVariable(value = "id") MauSac ms
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            ms.setTen(newMauSac.getTen());
            ms.setTrangThai(Integer.valueOf(newMauSac.getTrangThai()));
            ms.setNgayTao(Date.valueOf(newMauSac.getNgayTao()));
            msRepo.save(ms);
            return  ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid MauSacStore newMauSac,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            MauSac ms = new MauSac();
            //conduct ma
            ms.setMa(newMauSac.getMa());
            ms.setTen(newMauSac.getTen());
            ms.setTrangThai(Integer.valueOf(newMauSac.getTrangThai()));
            ms.setNgayTao(Date.valueOf(newMauSac.getNgayTao()));
            msRepo.save(ms);
            return ResponseEntity.ok(true);
        }
    }
}