package com.example.java4.RestControllers;
import com.example.java4.Request.HinhAnhReq;
import com.example.java4.Request.SanPhaRq;
import com.example.java4.entities.HinhAnh;
import com.example.java4.entities.SanPham;
import com.example.java4.repositories.HinhAnhRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("hinh-anh")
public class HinhAnhController {
    @Autowired
    HinhAnhRepository hinhAnhRepo;
    public HinhAnhController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<HinhAnh>> index(){
        return ResponseEntity.ok(hinhAnhRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HinhAnh> getDetail(@PathVariable(value = "id") HinhAnh hinhAnh){
            return ResponseEntity.ok(hinhAnh);
    }
    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") HinhAnh hinhAnh){
        hinhAnhRepo.delete(hinhAnh);
    }

    @PostMapping ("/update/{id}")
    public HinhAnh doUpdate(@RequestBody @Valid HinhAnhReq newHinhAnh, BindingResult result, @PathVariable(value ="id") HinhAnh hinhAnh){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            //call procedure
            return hinhAnh;
        }
    }

    @PostMapping("save")
    public SanPham save(
            @RequestBody @Valid SanPhaRq newSanPham,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        }
        else{
            SanPham sp = new SanPham();
            //call procedure
            return sp;
        }
    }
}