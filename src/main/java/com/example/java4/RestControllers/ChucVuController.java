package com.example.java4.RestControllers;
import com.example.java4.Request.ChucVuRq;
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
@RequestMapping("chuc-vu")
public class ChucVuController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    ChucVuRepository chucVuRepo;
    public ChucVuController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ChucVu>> index() {
        return ResponseEntity.ok(chucVuRepo.findAll());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChucVu> getDetail(@PathVariable(name="id") ChucVu chucVu){
             return ResponseEntity.ok(chucVu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") ChucVu chucVu) {
        chucVuRepo.delete(chucVu);
    }

    @PostMapping("save")
    public ChucVu Store(
            @RequestBody @Valid ChucVuRq newChucVu,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("chuc vu accused failed: "+result);
            return null;
        } else {
            ChucVu chucVu = new ChucVu();
            chucVu.setId(newChucVu.getId());
            chucVu.setMa(newChucVu.getMa());
            chucVu.setTen(newChucVu.getTen());
            chucVu.setTrangThai(Integer.valueOf(newChucVu.getTrangThai()));
            chucVu.setNgayTao(Date.valueOf(newChucVu.getNgayTao()));
            chucVuRepo.save(chucVu);
            return chucVu;
        }
    }
}