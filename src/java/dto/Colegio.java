package dto;
// Generated 12-jun-2019 23:25:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Colegio generated by hbm2java
 */
public class Colegio  implements java.io.Serializable {


     private Integer idColegio;
     private String nombreColegio;
     private String direccionColegio;
     private Set profesors = new HashSet(0);

    public Colegio() {
    }

    public Colegio(String nombreColegio, String direccionColegio, Set profesors) {
       this.nombreColegio = nombreColegio;
       this.direccionColegio = direccionColegio;
       this.profesors = profesors;
    }
   
    public Integer getIdColegio() {
        return this.idColegio;
    }
    
    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }
    public String getNombreColegio() {
        return this.nombreColegio;
    }
    
    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }
    public String getDireccionColegio() {
        return this.direccionColegio;
    }
    
    public void setDireccionColegio(String direccionColegio) {
        this.direccionColegio = direccionColegio;
    }
    public Set getProfesors() {
        return this.profesors;
    }
    
    public void setProfesors(Set profesors) {
        this.profesors = profesors;
    }




}


