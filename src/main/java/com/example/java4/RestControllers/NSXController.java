package com.example.java4.RestControllers;
import com.example.java4.Request.NSXReq;
import com.example.java4.entities.NSX;
import com.example.java4.repositories.NSXRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("nsx")
public class NSXController {
    @Autowired
    NSXRepository nsxRepo;

    public NSXController() {
    }

    @GetMapping("/index")
    public ResponseEntity<List<NSX>> getIndexPage(Model model) {
        return ResponseEntity.ok(nsxRepo.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") NSX nsx) {
        nsxRepo.delete(nsx);
    }

    @PostMapping("/update/{id}")
    public NSX doUpdate(@Valid @RequestBody NSXReq newNSX, BindingResult rs, @PathVariable(value = "id") NSX nsx) {
        if (rs.hasErrors()) {
            System.out.println("error temp: " + rs);
            return null;
        } else {
            //call insert procedure
            nsxRepo.save(nsx);
            return nsx;
        }
    }

    @PostMapping("save")
    public NSX store(
            @RequestBody @Valid NSXReq newNSX,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return null;
        } else {
            NSX nsx = new NSX();
            nsxRepo.save(nsx);
            return nsx;
        }
    }
}