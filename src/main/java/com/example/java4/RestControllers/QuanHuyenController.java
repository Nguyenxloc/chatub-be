package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.QuanHuyen;
import com.example.java4.repositories.QuanHuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}