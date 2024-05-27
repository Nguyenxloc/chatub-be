package com.example.java4.RestControllers;
import com.example.java4.requestStore.ChucVuStore;
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
    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") ChucVu chucVu,
                                            @RequestBody @Valid ChucVuStore newChucVu,
                                            BindingResult rs){
               if(rs.hasErrors()){
                   System.out.println("update error: " + rs);
                   return  ResponseEntity.ok(false);
               }
               else{
                   chucVu.setTen(newChucVu.getTen());
                   chucVu.setTrangThai(Integer.valueOf(newChucVu.getTrangThai()));
                   chucVu.setNgayTao(Date.valueOf(newChucVu.getNgayTao()));
                   chucVuRepo.save(chucVu);
                   return ResponseEntity.ok(true);
               }
    }
    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid ChucVuStore newChucVu,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("chuc vu accused failed: "+result);
            return ResponseEntity.ok(false);
        } else {
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(newChucVu.getMa());
            chucVu.setTen(newChucVu.getTen());
            chucVu.setTrangThai(Integer.valueOf(newChucVu.getTrangThai()));
            chucVu.setNgayTao(Date.valueOf(newChucVu.getNgayTao()));
            chucVuRepo.save(chucVu);
            return ResponseEntity.ok(true);
        }
    }
}