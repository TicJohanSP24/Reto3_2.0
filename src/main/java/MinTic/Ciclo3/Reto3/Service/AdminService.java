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
    public Admin update(Admin a){
        if (a.getId()!=null){
            Optional<Admin>aaux=adminRepository.getAdmin(a.getId());
            if(!aaux.isEmpty()){
                if(a.getNombre()!=null){
                    aaux.get().setNombre(a.getNombre());
                }
                if(a.getContraseña()!=null){
                    aaux.get().setContraseña(a.getContraseña());
                }                
            }    
        }
        return a;
    }
    
    public boolean deleteAdmin(int id){
        Optional<Admin> p=getAdmin(id);
        if(!p.isEmpty()){
            adminRepository.delete(p.get());
            return true;
        }
        return false;
    } 
    
}        
