package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Message;
import java.util.List;

public interface MessageService {

    Message getMessageById(Long id); // 根据id查找留言对象

    List<Message> getMessageList(); // 获取所有留言对象的列表

    List<Message> getMessageListNotDeleted(); // 获取所有留言对象的列表

    Long addNewMessage(Message message); // 新增留言对象，返回新增对象的id

    void deleteMessageById(Long id); // 根据id删除留言对象

    void recoverMessageById(Long id);

    Long updateMessageById(Long messageId, Message updatedMessage); // 根据id更新留言对象信息，返回更新对象的id

}
