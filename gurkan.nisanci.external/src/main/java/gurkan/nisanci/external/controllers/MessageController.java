package gurkan.nisanci.external.controllers;

import gurkan.nisanci.external.model.Message;
import gurkan.nisanci.external.proxy.InternalAppProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    protected InternalAppProxy internalAppProxy;

    @Autowired
    public MessageController(InternalAppProxy internalAppProxy) {
        super();
        this.internalAppProxy = internalAppProxy;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return internalAppProxy.getAllMessages();
    }

    @GetMapping({"/{messageId}"})
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId) {
        return internalAppProxy.getMessage(messageId);
    }

    @PostMapping
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        return internalAppProxy.saveMessage(message);
    }

    @DeleteMapping({"/{messageId}"})
    public ResponseEntity<Message> deleteMessage(@PathVariable("messageId") Long messageId) {
        return internalAppProxy.deleteMessage(messageId);
    }
}
