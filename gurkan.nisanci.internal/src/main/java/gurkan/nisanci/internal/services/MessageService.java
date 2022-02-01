package gurkan.nisanci.internal.services;

import gurkan.nisanci.internal.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages();

    Message getMessage(Long id);

    Message insert(Message message);

    void delete(Long id);
}
