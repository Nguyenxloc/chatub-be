package com.example.java4.RestControllers;
import com.example.java4.Request.HoaDonReq;
import com.example.java4.entities.HoaDon;
import com.example.java4.entitiesNoMap.HoaDonNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.HoaDonRepoNoMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private HoaDonRepoNoMap hoaDonRepoNoMap;
    public HoaDonController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<HoaDon>> index() {
        return ResponseEntity.ok(hdRepo.findAll());
    }

    @CrossOrigin
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<HoaDon> getDetail(@PathVariable(value = "id") HoaDon hoaDon){
             return ResponseEntity.ok(hoaDon);
    }
    @PostMapping("update/{id}")
    public String doUpdate(
            @RequestBody  @Valid HoaDonReq newHoaDon,
            BindingResult result, @PathVariable(value = "id") HoaDon hd
    ) {
        if (result.hasErrors()){
            System.out.println("tempt error: "+result);
            return null;
        }
        else{
            return "redirect:/hoa_don/index";
        }
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") HoaDon hd) {
        hdRepo.delete(hd);
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HoaDonReq newHoaDon,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("temp error: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            //conduct ma by select count
            HoaDonNoMap hd = new HoaDonNoMap();
            hd.setMa(newHoaDon.getMa());
            hd.setIdPttt(newHoaDon.getIdPTTT());
            hd.setIdKhuyenMai(newHoaDon.getIdKhuyenMai());
            hd.setIdNhanVien(newHoaDon.getIdNhanVien());
            hd.setIdKhachHang(newHoaDon.getIdKhachHang());
            hd.setIdGiaoHang(newHoaDon.getIdGiaoHang());
            hd.setNgayTao(Date.valueOf(newHoaDon.getNgayTao()));
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayThanhToan()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            return ResponseEntity.ok(true);
        }
    }
}