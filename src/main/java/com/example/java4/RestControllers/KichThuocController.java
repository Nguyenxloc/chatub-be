package com.example.java4.RestControllers;
import com.example.java4.requestStore.KichThuocStore;
import com.example.java4.entities.KichThuoc;
import com.example.java4.repositories.KichThuocRepository;
import com.example.java4.requestUpdate.KichThuocUpdate;
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

    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@Valid @RequestBody KichThuocUpdate newKichThuoc, BindingResult rs,
                                            @PathVariable(value = "id") KichThuoc kt) {
        if (rs.hasErrors()) {
            System.out.println("error at kich thuoc: " + rs);
            return null;
        } else {
            kt.setTen(newKichThuoc.getTen());
            kt.setTrangThai(Integer.valueOf(newKichThuoc.getTrangThai()));
            kt.setNgayTao(Date.valueOf(newKichThuoc.getNgayTao()));
            ktRepo.save(kt);
            return  ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(ktRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(ktRepo.enableStt(id));
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> store(
            @RequestBody @Valid KichThuocStore newKichThuoc,
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