package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.PhuongXa;
import com.example.java4.repositories.PhuongXaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}