/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Reservation;
import MinTic.Ciclo3.Reto3.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gadoj
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();        
    }
    
    public Optional <Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);            
    }        

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
            return r;
            }
        }
    }    

    public Reservation update(Reservation r){
        if (r.getIdReservation()!=null){
            Optional<Reservation>raux=reservationRepository.getReservation(r.getIdReservation());
            if(!raux.isEmpty()){
                if(r.getStartDate()!=null){
                    raux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    raux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    raux.get().setStatus(r.getStatus());
                }
            }    
        }
        return r;
    }
    
    public boolean deleteReservation(int id){
        Optional<Reservation> r=getReservation(id);
        if(!r.isEmpty()){
            reservationRepository.delete(r.get());
            return true;
        }
        return false;
    }     
    
}
