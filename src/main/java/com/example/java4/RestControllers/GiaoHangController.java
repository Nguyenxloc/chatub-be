package com.example.java4.RestControllers;

import com.example.java4.requestStore.GiaoHangStore;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
import com.example.java4.requestUpdate.GiaoHangUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("giao-hang")
public class GiaoHangController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    GiaohangRepository giaoHangRepo;
    public GiaoHangController() {
    }


    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<GiaoHang>> index() {
        return ResponseEntity.ok(giaoHangRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<GiaoHang> getDetail(@PathVariable(name="id") GiaoHang giaoHang){
         return ResponseEntity.ok(giaoHang);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") GiaoHang giaoHang,
                                            @RequestBody @Valid GiaoHangUpdate newGiaoHang,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            giaoHang.setHoTen(newGiaoHang.getHoTen());
            giaoHang.setSdt(newGiaoHang.getSdt());
            giaoHang.setDiaChi(newGiaoHang.getDiaChi());
            giaoHang.setPhuongXa(newGiaoHang.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHang.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHang.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHang.getTrangThai()));
            giaoHang.setNgayTao(Date.valueOf(newGiaoHang.getNgayTao()));
            giaoHangRepo.save(giaoHang);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid GiaoHangStore newGiaoHangStore,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error at giaoHang: "+result);
            return ResponseEntity.ok(false);
        } else {
            GiaoHang giaoHang= new GiaoHang();
            giaoHang.setId(newGiaoHangStore.getId());
            giaoHang.setHoTen(newGiaoHangStore.getHoTen());
            giaoHang.setSdt(newGiaoHangStore.getSdt());
            giaoHang.setDiaChi(newGiaoHangStore.getDiaChi());
            giaoHang.setPhuongXa(newGiaoHangStore.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHangStore.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHangStore.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHangStore.getTrangThai()));
            giaoHang.setNgayTao(Date.valueOf(newGiaoHangStore.getNgayTao()));
            giaoHangRepo.save(giaoHang);
            return ResponseEntity.ok(true);
        }
    }
}