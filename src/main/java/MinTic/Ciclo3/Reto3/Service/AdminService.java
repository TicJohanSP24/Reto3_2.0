/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Admin;
import MinTic.Ciclo3.Reto3.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gadoj
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();        
    }
    
    public Optional <Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);            
    }        

    public Admin save(Admin a){
        if(a.getId()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> aaux = adminRepository.getAdmin(a.getId());
            if(aaux.isEmpty()){
                return adminRepository.save(a);
            }else{
            return a;
            }
        }
    }    
    
}
