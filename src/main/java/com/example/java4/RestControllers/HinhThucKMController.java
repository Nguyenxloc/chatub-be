package com.example.java4.RestControllers;
import com.example.java4.Request.HinhThucKMReq;
import com.example.java4.entities.HinhThucKM;
import com.example.java4.repositories.HinhThucKMRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("hinh-thuc-km")
public class HinhThucKMController {
    @Autowired
    HinhThucKMRepository hinhThucKMRepo;
    public HinhThucKMController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<HinhThucKM>> index(){
        return ResponseEntity.ok(hinhThucKMRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HinhThucKM> getDetail(@PathVariable(value ="id") HinhThucKM hinhThucKM){
        return  ResponseEntity.ok(hinhThucKM);
    }

    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") HinhThucKM hinhThucKM){
        hinhThucKMRepo.delete(hinhThucKM);
    }

    @PostMapping ("/update/{id}")
    public HinhThucKM doUpdate(@RequestBody @Valid HinhThucKMReq newHinhThucKM, BindingResult result, @PathVariable(value ="id") HinhThucKM hinhThucKM){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            //call procedure
            return hinhThucKM;
        }
    }

    @PostMapping("save")
    public HinhThucKM save(
            @RequestBody @Valid HinhThucKMReq newHinhThucKM,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        }
        else{
            HinhThucKM hinhThucKM = new HinhThucKM();
            hinhThucKM.setLoaiPhuongThuc(newHinhThucKM.getLoaiPhuongThuc());
            hinhThucKM.setHeSo(Float.valueOf(newHinhThucKM.getHeSo()));
            hinhThucKM.setTrangThai(Integer.valueOf(newHinhThucKM.getTrangThai()));
            hinhThucKM.setNgayTao(Date.valueOf(newHinhThucKM.getNgayTao()));
            return hinhThucKMRepo.save(hinhThucKM);
        }
    }
}