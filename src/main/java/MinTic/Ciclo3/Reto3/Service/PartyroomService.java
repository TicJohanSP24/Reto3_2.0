/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Partyroom;
import MinTic.Ciclo3.Reto3.Repository.PartyroomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gadoj
 */
@Service
public class PartyroomService {
    
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll(){
        return partyroomRepository.getAll();        
    }
    
    public Optional <Partyroom> getPartyroom(int id){
        return partyroomRepository.getPartyroom(id);            
    }        

    public Partyroom save(Partyroom p){
        if(p.getId()==null){
            return partyroomRepository.save(p);
        }else{
            Optional<Partyroom> paux = partyroomRepository.getPartyroom(p.getId());
            if(paux.isEmpty()){
                return partyroomRepository.save(p);
            }else{
            return p;
            }
        }
    } 
    
    public Partyroom update(Partyroom p){
        if (p.getId()!=null){
            Optional<Partyroom>paux=partyroomRepository.getPartyroom(p.getId());
            if(!paux.isEmpty()){
                if(p.getName()!=null){
                    paux.get().setName(p.getName());
                }
                if(p.getOwner()!=null){
                    paux.get().setOwner(p.getOwner());
                }    
                if(p.getDescription()!=null){
                    paux.get().setDescription(p.getDescription());                        
                }
                if(p.getCapacity()!=null){
                    paux.get().setCapacity(p.getCapacity());
                }
                if(p.getCategory()!=null){
                    paux.get().setCategory(p.getCategory());
                }
                if(p.getDescription()!=null){
                return partyroomRepository.save(paux.get());                        
                }
            }    
        }
        return p;
    }
    
    public boolean deletePartyroom(int id){
        Optional<Partyroom> p=getPartyroom(id);
        if(!p.isEmpty()){
            partyroomRepository.delete(p.get());
            return true;
        }
        return false;
    } 
    
}
