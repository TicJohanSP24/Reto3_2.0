/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Repository;

import MinTic.Ciclo3.Reto3.Model.Reservation;
import MinTic.Ciclo3.Reto3.Repository.CRUD.ReservationCrudRepository;
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
}
