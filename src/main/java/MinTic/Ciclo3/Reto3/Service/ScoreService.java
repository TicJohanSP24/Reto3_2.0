/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Score;
import MinTic.Ciclo3.Reto3.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gadoj
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();        
    }
    
    public Optional <Score> getScore(int id){
        return scoreRepository.getScore(id);            
    }        

    public Score save(Score s){
        if(s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> saux = scoreRepository.getScore(s.getId());
            if(saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
            return s;
            }
        }
    }    
    public Score update(Score s){
        if (s.getId()!=null){
            Optional<Score>saux=scoreRepository.getScore(s.getId());
            if(!saux.isEmpty()){
                if(s.getCalificacion()!=null){
                    saux.get().setCalificacion(s.getCalificacion());
                }
                if(s.getMensaje()!=null){
                    saux.get().setMensaje(s.getMensaje());
                }         
            }    
        }
        return s;
    }
    
    public boolean deleteScore(int id){
        Optional<Score> s=getScore(id);
        if(!s
                .isEmpty()){
            scoreRepository.delete(s.get());
            return true;
        }
        return false;
    }    
    
}
