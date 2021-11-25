/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Repository;

import MinTic.Ciclo3.Reto3.Model.Score;
import MinTic.Ciclo3.Reto3.Repository.CRUD.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gadoj
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();      
    }
    public Optional <Score> getScore(int id){
        return scoreCrudRepository.findById(id);                         
    }
    public Score save(Score s){
        return scoreCrudRepository.save(s);        
    }
    public void delete(Score s){
        scoreCrudRepository.delete(s);
    }
    
}
