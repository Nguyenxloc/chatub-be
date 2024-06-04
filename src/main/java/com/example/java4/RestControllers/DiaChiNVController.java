package com.example.java4.RestControllers;
import com.example.java4.entitiesLv2.DiaChiKH;
import com.example.java4.entitiesLv2.DiaChiNV;
import com.example.java4.entitiesNoMap.DiaChiKHNoMap;
import com.example.java4.entitiesNoMap.DiaChiNVNoMap;
import com.example.java4.repositoriesNoMap.DiaChiKHNoMapRepository;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.DiaChiNVNoMapRepository;
import com.example.java4.requestStore.DiaChiKHStore;
import com.example.java4.requestStore.DiaChiNVStore;
import com.example.java4.requestUpdate.DiaChiKHUpdate;
import com.example.java4.requestUpdate.DiaChiNVUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("dia-chi-nv")
public class DiaChiNVController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiNVRepository diaChiNVRepo;
    @Autowired
    DiaChiNVNoMapRepository diaChiNVNoMapRepo;
    public DiaChiNVController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<DiaChiNV>> index() {
        return ResponseEntity.ok(diaChiNVRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChiKH> getDetail(@PathVariable(name="id") DiaChiKH diaChiKH){
        return ResponseEntity.ok(diaChiKH);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") DiaChiNVNoMap diaChiNV,
                                            @RequestBody @Valid DiaChiNVUpdate newDiaChiNV,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            diaChiNV.setDiaChi(newDiaChiNV.getDiaChi());
            diaChiNV.setIdPhuongXa(newDiaChiNV.getIdPhuongXa());
            diaChiNV.setIdQuanHuyen(newDiaChiNV.getIdQuanHuyen());
            diaChiNV.setIdTinhThanh(newDiaChiNV.getIdTinhThanh());
            diaChiNV.setTrangThai(Integer.valueOf(newDiaChiNV.getTrangThai()));
            diaChiNV.setNgayTao(Date.valueOf(newDiaChiNV.getNgayTao()));
            diaChiNVNoMapRepo.save(diaChiNV);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiNVRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiNVRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid DiaChiNVStore newDiaChiNV,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            DiaChiNVNoMap diaChiNV = new DiaChiNVNoMap();
            diaChiNV.setId(newDiaChiNV.getId());
            diaChiNV.setIdNV(newDiaChiNV.getIdNV());
            diaChiNV.setIdPhuongXa(newDiaChiNV.getIdPhuongXa());
            diaChiNV.setIdQuanHuyen(newDiaChiNV.getIdQuanHuyen());
            diaChiNV.setIdTinhThanh(newDiaChiNV.getIdTinhThanh());
            diaChiNV.setTrangThai(Integer.valueOf(newDiaChiNV.getTrangThai()));
            diaChiNV.setNgayTao(Date.valueOf(newDiaChiNV.getNgayTao()));
            diaChiNVNoMapRepo.save(diaChiNV);
            return ResponseEntity.ok(true);
        }
    }
}