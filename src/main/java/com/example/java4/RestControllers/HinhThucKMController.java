package com.example.java4.RestControllers;
import com.example.java4.requestStore.HinhThucKMStore;
import com.example.java4.entitiesLv1.HinhThucKM;
import com.example.java4.repositories.HinhThucKMRepository;
import com.example.java4.requestUpdate.HinhThucKMUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("hinh-thuc-km")
public class HinhThucKMController {
    @Autowired
    HinhThucKMRepository hinhThucKMRepo;
    public HinhThucKMController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<HinhThucKM>> index(){
        return ResponseEntity.ok(hinhThucKMRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HinhThucKM> getDetail(@PathVariable(value ="id") HinhThucKM hinhThucKM){
        return  ResponseEntity.ok(hinhThucKM);
    }

    @PostMapping ("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@RequestBody @Valid HinhThucKMUpdate newHinhThucKM, BindingResult result,
                                            @PathVariable(value ="id") HinhThucKM hinhThucKM){
        if (result.hasErrors()) {
            System.out.println("error temp:" + result);
            return  ResponseEntity.ok(false);
        }
        else{
            hinhThucKM.setLoaiPhuongThuc(newHinhThucKM.getLoaiPhuongThuc());
            hinhThucKM.setHeSo(Float.valueOf(newHinhThucKM.getHeSo()));
            hinhThucKM.setTrangThai(Integer.valueOf(newHinhThucKM.getTrangThai()));
            hinhThucKM.setNgayTao(Date.valueOf(newHinhThucKM.getNgayTao()));
            hinhThucKMRepo.save(hinhThucKM);
            return  ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hinhThucKMRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hinhThucKMRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HinhThucKMStore newHinhThucKM,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            HinhThucKM hinhThucKM = new HinhThucKM();
            hinhThucKM.setLoaiPhuongThuc(newHinhThucKM.getLoaiPhuongThuc());
            hinhThucKM.setHeSo(Float.valueOf(newHinhThucKM.getHeSo()));
            hinhThucKM.setTrangThai(Integer.valueOf(newHinhThucKM.getTrangThai()));
            hinhThucKM.setNgayTao(Date.valueOf(newHinhThucKM.getNgayTao()));
            hinhThucKMRepo.save(hinhThucKM);
            return ResponseEntity.ok(true);
        }
    }
}