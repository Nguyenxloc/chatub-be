package com.example.java4.RestControllers;
import com.example.java4.entitiesLv2.DiaChiKH;
import com.example.java4.entitiesNoMap.DiaChiKHNoMap;
import com.example.java4.repositoriesNoMap.DiaChiKHNoMapRepository;
import com.example.java4.requestStore.DiaChiKHStore;
import com.example.java4.requestUpdate.DiaChiKHUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("dia-chi-kh")
public class DiaChiKHController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiKHRepository  diaChiKHRepo;
    @Autowired
    DiaChiKHNoMapRepository diaChiKHNoMapRepo;
    public DiaChiKHController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<DiaChiKH>> index() {
        return ResponseEntity.ok(diaChiKHRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChiKH> getDetail(@PathVariable(name="id") DiaChiKH diaChiKH){
        return ResponseEntity.ok(diaChiKH);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") DiaChiKHNoMap diaChiKH,
                                            @RequestBody @Valid DiaChiKHUpdate newDiaChiKH,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            diaChiKH.setDiaChi(newDiaChiKH.getDiaChi());
            diaChiKH.setIdPhuongXa(newDiaChiKH.getIdPhuongXa());
            diaChiKH.setIdQuanHuyen(newDiaChiKH.getIdQuanHuyen());
            diaChiKH.setIdTinhThanh(newDiaChiKH.getIdTinhThanh());
            diaChiKH.setTrangThai(Integer.valueOf(newDiaChiKH.getTrangThai()));
            diaChiKH.setNgayTao(Date.valueOf(newDiaChiKH.getNgayTao()));
            diaChiKHNoMapRepo.save(diaChiKH);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiKHRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiKHRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid DiaChiKHStore newDiaChiKH,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            DiaChiKHNoMap diaChiKH = new DiaChiKHNoMap();
            diaChiKH.setId(newDiaChiKH.getId());
            diaChiKH.setIdKH(newDiaChiKH.getIdKH());
            diaChiKH.setIdPhuongXa(newDiaChiKH.getIdPhuongXa());
            diaChiKH.setIdQuanHuyen(newDiaChiKH.getIdQuanHuyen());
            diaChiKH.setIdTinhThanh(newDiaChiKH.getIdTinhThanh());
            diaChiKH.setTrangThai(Integer.valueOf(newDiaChiKH.getTrangThai()));
            diaChiKH.setNgayTao(Date.valueOf(newDiaChiKH.getNgayTao()));
            diaChiKHNoMapRepo.save(diaChiKH);
            return ResponseEntity.ok(true);
        }
    }
}