package gurkan.nisanci.internal.bootstrap;

import gurkan.nisanci.internal.model.Message;
import gurkan.nisanci.internal.repositories.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageLoader implements CommandLineRunner {
    public final MessageRepository messageRepository;

    public MessageLoader(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadMessages();
    }

    private void loadMessages() {
        if (messageRepository.count() == 0) {
            messageRepository.save(
                    Message.builder()
                            .message("message 1")
                            .build()
            );
            messageRepository.save(
                    Message.builder()
                            .message("message 2")
                            .build()
            );
            System.out.println("Sample Messages Loaded");
        }
    }
}
