package com.team7.computercenter.service;

import com.team7.computercenter.entities.Message;
import com.team7.computercenter.entities.Message;
import com.team7.computercenter.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    public Message save(Message m){
        if(m.getIdMessage() == null){
            return messageRepository.save(m);
        }else {
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if(e.isPresent()){
                return m;
            }else{
                return messageRepository.save(m);
            }
        }
    }
    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> q = messageRepository.getMessage(m.getIdMessage());
            if(q.isPresent()){
                if(m.getComputer()!=null){
                    q.get().setComputer(m.getComputer());
                }
                if(m.getMessageText()!=null){
                    q.get().setMessageText(m.getMessageText());
                }

                messageRepository.save(q.get());
                return q.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }
    public boolean delete(int idMessage){
        Boolean del = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return del;
    }
}

