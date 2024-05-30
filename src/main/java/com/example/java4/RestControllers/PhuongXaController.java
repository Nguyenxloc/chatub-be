package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.MauSac;
import com.example.java4.entitiesLv1.PhuongXa;
import com.example.java4.repositories.PhuongXaRepository;
import com.example.java4.requestStore.MauSacStore;
import com.example.java4.requestStore.PhuongXaStore;
import com.example.java4.requestUpdate.MauSacUpdate;
import com.example.java4.requestUpdate.PhuongXaUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("phuong-xa")
public class PhuongXaController {
    @Autowired
    private PhuongXaRepository phuongXaRepository;
    public PhuongXaController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<PhuongXa>> index() {
        return ResponseEntity.ok(phuongXaRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<PhuongXa> getDetail(@PathVariable("id") PhuongXa phuongXa){
        return ResponseEntity.ok(phuongXa);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid PhuongXaUpdate newPhuongXa,
            BindingResult result, @PathVariable(value = "id") PhuongXa phuongXa
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            phuongXa.setTen(newPhuongXa.getTen());
            phuongXa.setTrangThai(Integer.valueOf(newPhuongXa.getTrangThai()));
            phuongXaRepository.save(phuongXa);
            return  ResponseEntity.ok(true);
        }
    }
//    @CrossOrigin
//    @PostMapping("/enable-status/{id}")
//    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
//        return ResponseEntity.ok(phuongXaRepository.enableStt(id));
//    }
//
//
//    @CrossOrigin
//    @PostMapping("/disable-status/{id}")
//    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
//        return ResponseEntity.ok(phuongXaRepository.enableStt(id));
//    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid PhuongXaStore newMauSac,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            PhuongXa px = new PhuongXa();
            //conduct ma
            px.setTen(newMauSac.getTen());
            px.setTrangThai(Integer.valueOf(newMauSac.getTrangThai()));
            phuongXaRepository.save(px);
            return ResponseEntity.ok(true);
        }
    }
}