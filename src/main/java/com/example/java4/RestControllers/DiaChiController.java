package com.example.java4.RestControllers;
import com.example.java4.Request.DiaChiRq;
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
@RequestMapping("dia-chi")
public class DiaChiController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiRepository  diaChiRepo;
    public DiaChiController() {
    }


    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<DiaChi>> index() {
        return ResponseEntity.ok(diaChiRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChi> getDetail(@PathVariable(name="id") DiaChi diaChi){
         return ResponseEntity.ok(diaChi);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") DiaChi diaChi) {
        diaChiRepo.delete(diaChi);
    }

    @PostMapping("save")
    public DiaChi Store(
            @RequestBody @Valid DiaChiRq newDiaChi,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return null;
        } else {
            DiaChi diaChi = new DiaChi();
            diaChi.setId(newDiaChi.getId());
            diaChi.setIdKH(newDiaChi.getIdKH());
            diaChi.setIdPhuongXa(newDiaChi.getIdPhuongXa());
            diaChi.setIdQuanHuyen(newDiaChi.getIdQuanHuyen());
            diaChi.setIdTinhThanh(newDiaChi.getIdTinhThanh());
            diaChi.setTrangThai(Integer.valueOf(newDiaChi.getTrangThai()));
            diaChi.setNgayTao(Date.valueOf(newDiaChi.getNgayTao()));
            return diaChi;
        }
    }
}