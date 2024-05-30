package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.PhuongXa;
import com.example.java4.entitiesLv1.TinhThanh;
import com.example.java4.repositories.TinhThanhRepository;
import com.example.java4.requestStore.PhuongXaStore;
import com.example.java4.requestStore.TinhThanhStore;
import com.example.java4.requestStore.TinhThanhUpdate;
import com.example.java4.requestUpdate.PhuongXaUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tinh-thanh")
public class TinhThanhController {
    @Autowired
    private TinhThanhRepository tinhThanhRepository;
    public TinhThanhController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<TinhThanh>> index() {
        return ResponseEntity.ok(tinhThanhRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<TinhThanh> getDetail(@PathVariable("id") TinhThanh tinhThanh){
        return ResponseEntity.ok(tinhThanh);
    }
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid TinhThanhUpdate newTinhThanh,
            BindingResult result, @PathVariable(value = "id") TinhThanh tinhThanh
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            tinhThanh.setTen(newTinhThanh.getTen());
            tinhThanh.setTrangThai(Integer.valueOf(newTinhThanh.getTrangThai()));
            tinhThanhRepository.save(tinhThanh);
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
            @RequestBody @Valid TinhThanhStore newTinhThanh,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            TinhThanh tt = new TinhThanh();
            //conduct ma
            tt.setTen(newTinhThanh.getTen());
            tt.setTrangThai(Integer.valueOf(newTinhThanh.getTrangThai()));
            tinhThanhRepository.save(tt);
            return ResponseEntity.ok(true);
        }
    }
}