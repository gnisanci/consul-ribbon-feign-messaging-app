package gurkan.nisanci.external.proxy;

import gurkan.nisanci.external.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "InternalApp")
public interface InternalAppProxy {
    @GetMapping({"/message"})
    public ResponseEntity<List<Message>> getAllMessages();

    @GetMapping({"/message/{messageId}"})
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId);

    @PostMapping({"/message"})
    public ResponseEntity<Message> saveMessage(@RequestBody Message message);

    @DeleteMapping({"/message/{messageId}"})
    public ResponseEntity<Message> deleteMessage(@PathVariable("messageId") Long messageId);
}
