/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Repository;

import MinTic.Ciclo3.Reto3.Model.Client;
import MinTic.Ciclo3.Reto3.Model.Reservation;
import MinTic.Ciclo3.Reto3.Reportes.ContadorClientes;
import MinTic.Ciclo3.Reto3.Repository.CRUD.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gadoj
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();      
    }
    
    public Optional <Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);                         
    }
    
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);        
    }
    
    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }  
    
    public List<Reservation> ReservacionStatusRepositorio (String status){
         return reservationCrudRepository.findAllByStatus(status);
     }    
    
    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b); 
     }   
    
    public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
}
