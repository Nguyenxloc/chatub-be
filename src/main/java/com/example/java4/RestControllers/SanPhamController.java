package com.example.java4.RestControllers;
import com.example.java4.Request.SanPhaRq;
import com.example.java4.entities.SanPham;
import com.example.java4.repositories.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    SanPhamRepository spRepo;
    public SanPhamController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<SanPham>> index(){
          return ResponseEntity.ok(spRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<SanPham> getDetail(@PathVariable(value = "id") SanPham sanPham){
         return ResponseEntity.ok(sanPham);
    }
    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") SanPham sp){
        spRepo.delete(sp);
    }

    @PostMapping ("/update/{id}")
    public SanPham doUpdate(@RequestBody @Valid SanPhaRq newSanPham, BindingResult result, @PathVariable(value ="id") SanPham sp){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            sp.setTen(newSanPham.getTen());
            sp.setMa(newSanPham.getMa());
            sp.setTrangThai(newSanPham.getTrangThai());
            sp.setNgayTao(Date.valueOf(newSanPham.getNgayTao()));
        }
        return sp;
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid SanPhaRq newSanPham,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            SanPham sp = new SanPham();
            sp.setTen(newSanPham.getTen());
            sp.setMa(newSanPham.getMa());
            sp.setTrangThai(newSanPham.getTrangThai());
            sp.setNgayTao(Date.valueOf(newSanPham.getNgayTao()));
            spRepo.save(sp);
            return ResponseEntity.ok(true);
        }
    }
}