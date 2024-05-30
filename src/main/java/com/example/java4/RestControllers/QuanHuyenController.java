package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.PhuongXa;
import com.example.java4.entitiesLv1.QuanHuyen;
import com.example.java4.repositories.QuanHuyenRepository;
import com.example.java4.requestStore.PhuongXaStore;
import com.example.java4.requestStore.QuanHuyenStore;
import com.example.java4.requestUpdate.PhuongXaUpdate;
import com.example.java4.requestUpdate.QuanHuyenUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("quan-huyen")
public class QuanHuyenController {
    @Autowired
    private QuanHuyenRepository quanHuyenRepository;
    public QuanHuyenController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<QuanHuyen>> index() {
        return ResponseEntity.ok(quanHuyenRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<QuanHuyen> getDetail(@PathVariable("id") QuanHuyen quanHuyen){
        return ResponseEntity.ok(quanHuyen);
    }
    @CrossOrigin
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid QuanHuyenUpdate newQuanHuyen,
            BindingResult result, @PathVariable(value = "id") QuanHuyen quanHuyen
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            quanHuyen.setTen(newQuanHuyen.getTen());
            quanHuyen.setTrangThai(Integer.valueOf(newQuanHuyen.getTrangThai()));
            quanHuyenRepository.save(quanHuyen);
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
            @RequestBody @Valid QuanHuyenStore newQuanHuyen,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            QuanHuyen qh = new QuanHuyen();
            //conduct ma
            qh.setTen(newQuanHuyen.getTen());
            qh.setTrangThai(Integer.valueOf(newQuanHuyen.getTrangThai()));
            quanHuyenRepository.save(qh);
            return ResponseEntity.ok(true);
        }
    }
}