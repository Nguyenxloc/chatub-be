package com.example.java4.RestControllers;
import com.example.java4.Request.MauSacRq;
import com.example.java4.entities.MauSac;
import com.example.java4.repositories.MauSacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("mau_sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;
    public MauSacController() {
    }

    @GetMapping("index")
    public ResponseEntity<List<MauSac>> index() {
        return ResponseEntity.ok(msRepo.findAll());
    }

    @PostMapping("update/{id}")
    public MauSac doUpdate(
            @RequestBody @Valid MauSac req,
            BindingResult result, @PathVariable(value = "id") MauSac ms
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return null;
        }
        else{
            ms.setTen(req.getTen());
            ms.setMa(req.getMa());
            ms.setTrangThai(req.getTrangThai());
            msRepo.save(ms);
        }
        return ms;
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") MauSac ms) {
        msRepo.delete(ms);
    }

    @PostMapping("save")
    public MauSac save(
            @RequestBody @Valid MauSacRq newMauSac,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return null;
        }
        else{
            MauSac ms = new MauSac();
            msRepo.save(ms);
            return ms;
        }

    }
}