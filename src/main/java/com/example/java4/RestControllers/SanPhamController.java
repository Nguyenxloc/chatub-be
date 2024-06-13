package com.example.java4.RestControllers;
import com.example.java4.requestStore.SanPhaStore;
import com.example.java4.entitiesLv1.SanPham;
import com.example.java4.repositories.SanPhamRepository;
import com.example.java4.requestUpdate.SanPhaUpdate;
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

    @CrossOrigin
    @PostMapping ("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@RequestBody @Valid SanPhaUpdate newSanPham, BindingResult result,
                                            @PathVariable(value ="id") SanPham sp){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return ResponseEntity.ok(false);
        }
        else{
            sp.setTen(newSanPham.getTen());
            sp.setTrangThai(Integer.valueOf(newSanPham.getTrangThai()));
            sp.setNgayTao(Date.valueOf(newSanPham.getNgayTao()));
            sp.setHinhAnh(newSanPham.getHinhAnh());
            sp.setGiaBan(newSanPham.getGiaBan());
            spRepo.save(sp);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(spRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(spRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid SanPhaStore newSanPham,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            String ma = "SP"+(spRepo.getCount()+1);
            SanPham sp = new SanPham();
            sp.setTen(newSanPham.getTen());
            sp.setMa(ma);
            sp.setTrangThai(Integer.valueOf(newSanPham.getTrangThai()));
            sp.setNgayTao(Date.valueOf(newSanPham.getNgayTao()));
            sp.setHinhAnh(newSanPham.getHinhAnh());
            sp.setGiaBan(newSanPham.getGiaBan());
            spRepo.save(sp);
            return ResponseEntity.ok(true);
        }
    }
}