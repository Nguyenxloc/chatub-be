package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.TinhThanh;
import com.example.java4.repositories.TinhThanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}