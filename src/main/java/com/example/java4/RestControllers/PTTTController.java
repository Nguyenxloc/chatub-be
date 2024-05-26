package com.example.java4.RestControllers;
import com.example.java4.Request.PTTTReq;
import com.example.java4.entities.PTTT;
import com.example.java4.entitiesNoMap.PTTTNoMap;
import com.example.java4.repositories.PTTTRepository;
import com.example.java4.repositoriesNoMap.PTTTRepoNoMap;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("pttt")
public class PTTTController {
    @Autowired
    PTTTRepository ptttRepo;
    @Autowired
    PTTTRepoNoMap ptttRepoNoMap;
    public PTTTController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<PTTT>> getIndexPage() {
        return ResponseEntity.ok(ptttRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<PTTT> getDetail(@PathVariable(value = "id") PTTT pttt){
            return  ResponseEntity.ok(pttt);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") PTTT pttt) {
        ptttRepo.delete(pttt);
    }

    @PostMapping("/update/{id}")
    public PTTT doUpdate(@Valid @RequestBody PTTTReq newPttt, BindingResult rs, @PathVariable(value = "id") PTTT pttt) {
        if (rs.hasErrors()) {
            System.out.println("error temp: " + rs);
            return null;
        } else {
            //call insert procedure
            ptttRepo.save(pttt);
            return pttt;
        }
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> store(
            @RequestBody @Valid PTTTReq newPTTT,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        } else {
            PTTTNoMap pttt = new PTTTNoMap();
            pttt.setIdHoaDon(newPTTT.getIdHoaDon());
            pttt.setLoaiPhuongThuc(newPTTT.getLoaiPhuongThuc());
            pttt.setTrangThai(Integer.valueOf(newPTTT.getTrangThai()));
            pttt.setNgayTao(Date.valueOf(newPTTT.getNgayTao()));
            ptttRepoNoMap.save(pttt);
            return ResponseEntity.ok(true);
        }
    }
}