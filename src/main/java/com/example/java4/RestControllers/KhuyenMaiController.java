package com.example.java4.RestControllers;
import com.example.java4.Request.KhuyenMaiReq;
import com.example.java4.entities.KhuyenMai;
import com.example.java4.repositories.KhuyenMaiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepo;
    public KhuyenMaiController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KhuyenMai>> index(){
        return ResponseEntity.ok(khuyenMaiRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("detail/{id}")
    public ResponseEntity<KhuyenMai> getDetail(@PathVariable(value = "id") KhuyenMai khuyenMai){
        return ResponseEntity.ok(khuyenMai);
    }

    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable(value ="id") KhuyenMai khuyenMai){
        khuyenMaiRepo.delete(khuyenMai);
    }

    @PostMapping ("/update/{id}")
    public KhuyenMai doUpdate(@RequestBody @Valid KhuyenMaiReq newKhuyenMai, BindingResult result, @PathVariable(value ="id") KhuyenMai khuyenMai){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return null;
        }
        else{
            //call procedure
            return khuyenMai;
        }
    }

    @PostMapping("save")
    public KhuyenMai save(
            @RequestBody @Valid KhuyenMaiReq newKhuyenMai,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        }
        else{
            KhuyenMai khuyenMai = new KhuyenMai();
            //call procedure
            return khuyenMai;
        }
    }
}