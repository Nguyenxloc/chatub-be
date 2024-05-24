package com.example.java4.RestControllers;

import com.example.java4.Request.GiaoHangRq;
import com.example.java4.entities.*;
import com.example.java4.repositories.*;
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

    @GetMapping("/index")
    public ResponseEntity<List<GiaoHang>> index() {
        return ResponseEntity.ok(giaoHangRepo.findAll());
    }

    @GetMapping("/detail/{id}")
    public GiaoHang getDetail(@PathVariable(name="id")GiaoHangRq newGiaoHangRq,BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("please input valid data giao hang");
            return null;
        }
        else{
            GiaoHang giaoHang = new GiaoHang();
            giaoHang.setId(newGiaoHangRq.getId());
            giaoHang.setHoTen(newGiaoHangRq.getHoTen());
            giaoHang.setSdt(newGiaoHangRq.getSdt());
            giaoHang.setDiaChi(newGiaoHangRq.getDiaChi());
            giaoHang.setPhuongXa(newGiaoHangRq.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHangRq.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHangRq.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHangRq.getTrangThai()));
            giaoHang.setNgayTao(Date.valueOf(newGiaoHangRq.getNgayTao()));
            return giaoHang;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") GiaoHang giaoHang) {
         giaoHangRepo.delete(giaoHang);
    }

    @PostMapping("save")
    public GiaoHang Store(
            @RequestBody @Valid GiaoHangRq newGiaoHangRq,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error at giaoHang: "+result);
            return null;
        } else {
            GiaoHang giaoHang= new GiaoHang();
            giaoHang.setId(newGiaoHangRq.getId());
            giaoHang.setHoTen(newGiaoHangRq.getHoTen());
            giaoHang.setSdt(newGiaoHangRq.getSdt());
            giaoHang.setDiaChi(newGiaoHangRq.getDiaChi());
            giaoHang.setPhuongXa(newGiaoHangRq.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHangRq.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHangRq.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHangRq.getTrangThai()));
            giaoHang.setNgayTao(Date.valueOf(newGiaoHangRq.getNgayTao()));
            return giaoHang;
        }
    }
}