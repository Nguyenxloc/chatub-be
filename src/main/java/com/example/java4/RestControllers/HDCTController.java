package com.example.java4.RestControllers;
import com.example.java4.Request.HDCTReq;
import com.example.java4.entities.HDCT;
import com.example.java4.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public HDCTController() {
    }

    public Timestamp StringsToTimeStampt(String date, String time){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(date +" "+time+":00.000");
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

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") HDCT hdct) {
        hdctRepository.delete(hdct);
    }

    @PostMapping("/save")
    public HDCT save(
            @RequestBody @Valid HDCTReq newHDCT, BindingResult result
    ) {
        HDCT hdct = new HDCT();
        if (result.hasErrors()) {
            System.out.println("temp error: " + result);
            return null;
        } else {
            hdct = hdctRepository.save(hdct);
        }
        return hdct;
    }
}