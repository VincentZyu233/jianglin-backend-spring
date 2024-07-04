package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.Message;
import java.util.List;

import jmu.zyu.jianglin.jparepo.MessageRepository;
import jmu.zyu.jianglin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Message> getMessageList() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessageListNotDeleted() { return messageRepository.findAllNotDeleted(); }

    @Override
    public Long addNewMessage(Message message) {
        return messageRepository.save(message).getId();
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void recoverMessageById(Long id) {
        messageRepository.recoverById(id);
    }

    @Override
    public Long updateMessageById(Long messageId, Message updatedMessage) {
        Message messageInDb = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("Message with id " + messageId + " not found"));

        messageInDb.setMessage_content( updatedMessage.getMessage_content() );

        messageRepository.save(messageInDb);

        return messageInDb.getId();
    }
}
