/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Web;

import MinTic.Ciclo3.Reto3.Model.Message;
import MinTic.Ciclo3.Reto3.Service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gadoj
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();            
    }
    
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id")int id){
        return messageService.getMessage(id);
    }
                
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }                    
}
