package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Message;
import jmu.zyu.jianglin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Long> addNewMessage(@RequestBody Message message) {
        System.out.println("qwq, message obj" + message);
        return ResponseEntity.ok(messageService.addNewMessage(message));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.getMessageById(id));
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getMessageList());
    }

    @GetMapping("/all/not_deleted")
    @ResponseBody
    public ResponseEntity<List<Message>> getAllMessagesNotDeleted() { return ResponseEntity.ok(messageService.getMessageListNotDeleted()); }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long id) {
        messageService.deleteMessageById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/recover/{id}")
    public ResponseEntity<Void> recoverMessageById(@PathVariable Long id) {
        messageService.recoverMessageById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Long> updateMessageById(@PathVariable Long id, @RequestBody Message updatedMessage) {
        System.out.println("qwq, new message obj" + updatedMessage);

        return ResponseEntity.ok(messageService.updateMessageById(id, updatedMessage));
    }
}
