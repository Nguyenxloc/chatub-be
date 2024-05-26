package com.example.java4.RestControllers;
import com.example.java4.Request.KichThuocReq;
import com.example.java4.entities.KichThuoc;
import com.example.java4.repositories.KichThuocRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    KichThuocRepository ktRepo;

    public KichThuocController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KichThuoc>> getIndexPage(Model model) {
        return ResponseEntity.ok(ktRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("detail/{id}")
    public ResponseEntity<KichThuoc> getDetail(@PathVariable(value = "id") KichThuoc kichThuoc){
         return  ResponseEntity.ok(kichThuoc);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") KichThuoc kt) {
        ktRepo.delete(kt);
    }

    @PostMapping("/update/{id}")
    public KichThuoc doUpdate(@Valid @RequestBody KichThuocReq newKichThuoc, BindingResult rs, @PathVariable(value = "id") KichThuoc kt) {
        if (rs.hasErrors()) {
            System.out.println("error temp: " + rs);
            return null;
        } else {
            kt.setMa(newKichThuoc.getMa());
            kt.setTen(newKichThuoc.getTen());
            kt.setTrangThai(Integer.valueOf(newKichThuoc.getTrangThai()));
            ktRepo.save(kt);
        }
        return kt;
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> store(
            @RequestBody @Valid KichThuocReq newKichThuoc,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        } else {
            KichThuoc kt = new KichThuoc();
            kt.setMa(newKichThuoc.getMa());
            kt.setTen(newKichThuoc.getTen());
            kt.setTrangThai(Integer.valueOf(newKichThuoc.getTrangThai()));
            kt.setNgayTao(Date.valueOf(newKichThuoc.getNgayTao()));
            ktRepo.save(kt);
            return ResponseEntity.ok(true);
        }
    }
}