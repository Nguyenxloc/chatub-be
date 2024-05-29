package com.example.java4.RestControllers;
import com.example.java4.entities.PhuongXa;
import com.example.java4.entities.QuanHuyen;
import com.example.java4.entities.TinhThanh;
import com.example.java4.repositories.PhuongXaRepository;
import com.example.java4.repositories.QuanHuyenRepository;
import com.example.java4.repositories.TinhThanhRepository;
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