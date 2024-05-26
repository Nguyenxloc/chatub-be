package com.example.java4.RestControllers;
import com.example.java4.Request.HDCTReq;
import com.example.java4.entities.HDCT;
import com.example.java4.entitiesNoMap.HDCTNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.HDCTRepoNoMap;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
@Controller
@RequestMapping("hdct")
public class HDCTController {
    @Autowired
    HoaDonRepository hdRepo;
    @Autowired
    ChiTietSPfullRepository spctFullRepository;
    @Autowired
    ChiTietSPRepository spctRepository;
    @Autowired
    HDCTRepository hdctRepository;
    @Autowired
    HDCTRepoNoMap hdctRepoNoMap;
    public HDCTController() {
    }

    public Timestamp StringsToTimeStampt(String date, String time){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            java.util.Date parsedDate = dateFormat.parse(date +" "+time+":00.000");
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println("timestamp:"+timestamp);
            return timestamp;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[]  TimeStampToStrings(Timestamp timeStampt){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(timeStampt);
            String[] parts = s.split(" ");
            return parts;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @CrossOrigin()
    @GetMapping("/index")
    public ResponseEntity<List<HDCT>> getIndex() {
        return ResponseEntity.ok(hdctRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HDCT> getDetail(@PathVariable(value = "id") HDCT hdct){
        return ResponseEntity.ok(hdct);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") HDCT hdct) {
        hdctRepository.delete(hdct);
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HDCTReq newHDCT, BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: " + result);
            return ResponseEntity.ok(false);
        } else {
            HDCTNoMap hdct = new HDCTNoMap();
            hdct.setIdHoaDon(newHDCT.getIdHoaDon());
            hdct.setIdChiTietSP(newHDCT.getIdChiTietSP());
            hdct.setTrangThai(Integer.valueOf(newHDCT.getTrangThai()));
            hdct.setNgayTao(Date.valueOf(newHDCT.getNgayTao()));
            hdct.setSoLuong(Integer.valueOf(newHDCT.getSoLuong()));
            return ResponseEntity.ok(true);
        }
    }
}