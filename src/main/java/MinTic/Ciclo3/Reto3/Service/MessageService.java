/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Message;
import MinTic.Ciclo3.Reto3.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gadoj
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();        
    }
    
    public Optional <Message> getMessage(int id){
        return messageRepository.getMessage(id);            
    }        

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> maux = messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(m);
            }else{
            return m;
            }
        }
    }    
    
    public Message update(Message m){
        if (m.getIdMessage()!=null){
            Optional<Message>maux=messageRepository.getMessage(m.getIdMessage());
            if(!maux.isEmpty()){
                if(m.getMessageText()!=null){
                    maux.get().setMessageText(m.getMessageText());
                }
            }    
        }
        return m;
    }
    
    public boolean deleteMessage(int id){
        Optional<Message> m=getMessage(id);
        if(!m.isEmpty()){
            messageRepository.delete(m.get());
            return true;
        }
        return false;
    } 
    
}
