package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.repositories.ChatLieuRepository;
import com.example.java4.requestStore.ChatLieuStore;
import com.example.java4.requestUpdate.ChatLieuUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
@Controller
@RequestMapping("chat-lieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuRepository chatLieuRepo;
    public ChatLieuController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<ChatLieu>> index() {
        return ResponseEntity.ok(chatLieuRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChatLieu> getDetail(@PathVariable("id") ChatLieu chatLieu){
        return ResponseEntity.ok(chatLieu);
    }
    @CrossOrigin
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid ChatLieuUpdate newChatLieu,
            BindingResult result, @PathVariable(value = "id") ChatLieu cl
    ) {
        if (result.hasErrors()){
            System.out.println("Error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            cl.setTen(newChatLieu.getTen());
            cl.setTrangThai(Integer.valueOf(newChatLieu.getTrangThai()));
            cl.setNgayTao(Date.valueOf(newChatLieu.getNgayTao()));
            chatLieuRepo.save(cl);
            return  ResponseEntity.ok(true);
        }
    }
    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(chatLieuRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(chatLieuRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid ChatLieuStore newChatLieu,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("error temp at mausac: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            String ma = "CHL"+(chatLieuRepo.getCount()+1);
            ChatLieu cl = new ChatLieu();
            cl.setMa(ma);
            cl.setTen(newChatLieu.getTen());
            cl.setTrangThai(Integer.valueOf(newChatLieu.getTrangThai()));
            cl.setNgayTao(Date.valueOf(newChatLieu.getNgayTao()));
            chatLieuRepo.save(cl);
            return ResponseEntity.ok(true);
        }
    }
}