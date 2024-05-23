package com.example.java4.RestControllers;

import com.example.java4.dto.kich_thuoc.StoreRequest;
import com.example.java4.entities.KichThuoc;
import com.example.java4.repositories.KichThuocRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("kich_thuoc")
public class KichThuocController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    StoreRequest rem;
    StoreRequest remUpdate;
    @Autowired
    KichThuocRepository ktRepo;

    public KichThuocController() {
        this.rem = new StoreRequest();
        this.remUpdate = new StoreRequest();
    }

    @GetMapping("/index")
    public ResponseEntity<List<KichThuoc>> getIndexPage(Model model) {
        return ResponseEntity.ok(ktRepo.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") KichThuoc kt) {
        ktRepo.delete(kt);
    }

    @PostMapping("/update/{id}")
    public KichThuoc doUpdate(@Valid @RequestBody StoreRequest newKichThuoc, BindingResult rs, @PathVariable(value = "id") KichThuoc kt) {
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
    public KichThuoc store(
            @RequestBody @Valid @ModelAttribute("data") StoreRequest newKichThuoc,
            BindingResult result
    ) {
        KichThuoc kt = new KichThuoc();
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        } else {
            kt.setMa(newKichThuoc.getMa());
            kt.setTen(newKichThuoc.getTen());
            kt.setTrangThai(Integer.valueOf(newKichThuoc.getTrangThai()));
            ktRepo.save(kt);
        }
        return kt;
    }
}