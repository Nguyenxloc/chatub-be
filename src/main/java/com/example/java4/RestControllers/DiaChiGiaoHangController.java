package com.example.java4.RestControllers;
import com.example.java4.entitiesLv2.DiaChiGiaoHang;
import com.example.java4.entitiesNoMap.DiaChiGiaoHangNoMap;
import com.example.java4.repositoriesNoMap.DiaChiGiaoHangNoMapRepository;
import com.example.java4.requestStore.DiaChiGiaoHangStore;
import com.example.java4.repositories.*;
import com.example.java4.requestUpdate.DiaChiGiaoHangUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("dia-chi-gh")
public class DiaChiGiaoHangController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiGiaoHangRepository  diaChiGiaoHangRepo;
    @Autowired
    DiaChiGiaoHangNoMapRepository diaChiGiaoHangNoMapRepo;
    public DiaChiGiaoHangController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<DiaChiGiaoHang>> index() {
        return ResponseEntity.ok(diaChiGiaoHangRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChiGiaoHang> getDetail(@PathVariable(name="id") DiaChiGiaoHang diaChiGiaoHang){
        return ResponseEntity.ok(diaChiGiaoHang);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") DiaChiGiaoHangNoMap diaChiGiaoHang,
                                            @RequestBody @Valid DiaChiGiaoHangUpdate newDiaChiGiaoHang,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            diaChiGiaoHang.setDiaChi(newDiaChiGiaoHang.getDiaChi());
            diaChiGiaoHang.setIdPhuongXa(newDiaChiGiaoHang.getIdPhuongXa());
            diaChiGiaoHang.setIdQuanHuyen(newDiaChiGiaoHang.getIdQuanHuyen());
            diaChiGiaoHang.setIdTinhThanh(newDiaChiGiaoHang.getIdTinhThanh());
            diaChiGiaoHang.setTrangThai(Integer.valueOf(newDiaChiGiaoHang.getTrangThai()));
            diaChiGiaoHang.setNgayTao(Date.valueOf(newDiaChiGiaoHang.getNgayTao()));
            diaChiGiaoHangNoMapRepo.save(diaChiGiaoHang);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiGiaoHangRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiGiaoHangRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid DiaChiGiaoHangStore newDiaChi,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            DiaChiGiaoHangNoMap diaChi = new DiaChiGiaoHangNoMap();
            diaChi.setId(newDiaChi.getId());
            diaChi.setIdGiaoHang(newDiaChi.getIdGiaoHang());
            diaChi.setIdPhuongXa(newDiaChi.getIdPhuongXa());
            diaChi.setIdQuanHuyen(newDiaChi.getIdQuanHuyen());
            diaChi.setIdTinhThanh(newDiaChi.getIdTinhThanh());
            diaChi.setTrangThai(Integer.valueOf(newDiaChi.getTrangThai()));
            diaChi.setNgayTao(Date.valueOf(newDiaChi.getNgayTao()));
            diaChiGiaoHangNoMapRepo.save(diaChi);
            return ResponseEntity.ok(true);
        }
    }
}