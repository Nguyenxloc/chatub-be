package com.example.java4.RestControllers;
import com.example.java4.requestStore.KhachHangStore;
import com.example.java4.entitiesLv1.KhachHang;
import com.example.java4.repositories.KhachHangRepository;
import com.example.java4.requestUpdate.KhachHangUpdate;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    KhachHangRepository khRepo;
    public KhachHangController() {

    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KhachHang>> index(Model model) {
        return ResponseEntity.ok(khRepo.findAll()) ;
    }


    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<KhachHang> getDetail(@PathVariable(value = "id") KhachHang khachHang){
            return ResponseEntity.ok(khachHang);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@Valid @RequestBody KhachHangUpdate newKH,
                                   BindingResult result, @PathVariable(value = "id") KhachHang kh) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            kh.setHoTen(newKH.getHoTen());
            kh.setNgaySinh(newKH.getNgaySinh());
            kh.setSdt(newKH.getSdt());
            kh.setMatKhau(newKH.getMatKhau());
            kh.setNgayTao(Date.valueOf(newKH.getNgayTao()));
            kh.setTrangThai(Integer.valueOf(newKH.getTrangThai()));
            khRepo.save(kh);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid KhachHangStore newKH,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        } else {
            //conduct ma
            KhachHang kh = new KhachHang();
            kh.setMa(newKH.getMa());
            kh.setHoTen(newKH.getHoTen());
            kh.setNgaySinh(newKH.getNgaySinh());
            kh.setSdt(newKH.getSdt());
            kh.setMatKhau(newKH.getMatKhau());
            kh.setNgayTao(Date.valueOf(newKH.getNgayTao()));
            kh.setTrangThai(Integer.valueOf(newKH.getTrangThai()));
            khRepo.save(kh);
            return ResponseEntity.ok(true);
        }
    }
}