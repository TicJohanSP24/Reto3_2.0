/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Repository;

import MinTic.Ciclo3.Reto3.Model.Admin;
import MinTic.Ciclo3.Reto3.Repository.CRUD.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gadoj
 */

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();      
    }
    public Optional <Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);                         
    }
    public Admin save(Admin a){
        return adminCrudRepository.save(a);        
    }
    public void delete(Admin a){
        adminCrudRepository.delete(a);
    }    
}
    

