/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Service;

import MinTic.Ciclo3.Reto3.Model.Reservation;
import MinTic.Ciclo3.Reto3.Reportes.ContadorClientes;
import MinTic.Ciclo3.Reto3.Reportes.StatusReservas;
import MinTic.Ciclo3.Reto3.Repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= reservationRepository.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepository.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorClientes> reporteClientesServicio(){
            return reservationRepository.getClientesRepositorio();
        } 
    
}
