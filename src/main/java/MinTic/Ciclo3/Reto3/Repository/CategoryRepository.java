/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Repository;

import MinTic.Ciclo3.Reto3.Model.Category;
import MinTic.Ciclo3.Reto3.Repository.CRUD.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gadoj
 */

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();      
    }
    public Optional <Category> getCategory(int id){
        return categoryCrudRepository.findById(id);                         
    }
    public Category save(Category c){
        return categoryCrudRepository.save(c);        
    }    
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }
}
    

