/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Web;

import MinTic.Ciclo3.Reto3.Model.Partyroom;
import MinTic.Ciclo3.Reto3.Service.PartyroomService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PartyroomController {
    
    @Autowired
    private PartyroomService partyroomService;
    
    @GetMapping("/all")
    public List<Partyroom> getPartyrooms(){
        return partyroomService.getAll();            
    }
    
    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id")int id){
        return partyroomService.getPartyroom(id);
    }
                
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom p){
        return partyroomService.save(p);
    }                
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom p){  
        return partyroomService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePartyroom(@PathVariable("id")int id){
        return partyroomService.deletePartyroom(id);
    }    
}
