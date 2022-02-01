package gurkan.nisanci.internal.services;

import gurkan.nisanci.internal.model.Message;
import gurkan.nisanci.internal.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        messageRepository.findAll().forEach(messages::add);
        return messages;
    }

    @Override
    public Message getMessage(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public Message insert(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
