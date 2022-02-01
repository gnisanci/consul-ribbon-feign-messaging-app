package gurkan.nisanci.internal.controllers;

import gurkan.nisanci.internal.model.Message;
import gurkan.nisanci.internal.services.MessageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping({"/{messageId}"})
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId) {
        return new ResponseEntity<>(messageService.getMessage(messageId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        Message message1 = messageService.insert(message);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("message", "/api/v1/message/" + message1.getId().toString());
        return new ResponseEntity<>(message1, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping({"/{messageId}"})
    public ResponseEntity<Message> deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.delete(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
