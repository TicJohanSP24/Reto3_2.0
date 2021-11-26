/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Web;

/**
 *
 * @author gadoj
 */
import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    
   @GetMapping("/user")
   public Map<String, Object> user (@AuthenticationPrincipal OAuth2User principal){
       return Collections.singletonMap("name", principal.getAttribute("name"));
  }
    
//    @GetMapping("/sin-restriccion")
//    public String notRestricted() {
//       return "no es necesario estar conectado";
//    }
//    
//    @GetMapping("/saludo")
//    public String saludar() {
//       return "hola te saludo sin iniciar sesion";
//    }
//    
//    @GetMapping("/saludo-seguro")
//    public String saludar2(@AuthenticationPrincipal OAuth2User principal) {
//       return "hola "+principal.getAttribute("name");
//    }
//
//    @GetMapping("/restringido")
//    public Map<String, Object> restricted(@AuthenticationPrincipal OAuth2User principal) {
//        return  principal.getAttributes();
//    }
}