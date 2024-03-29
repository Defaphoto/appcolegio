package dto;
// Generated 12-jun-2019 23:25:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Asignatura generated by hbm2java
 */
public class Asignatura  implements java.io.Serializable {


     private int idAsignatura;
     private String nombreAsignatura;
     private Set profesors = new HashSet(0);
     private Set notas = new HashSet(0);

    public Asignatura() {
    }

	
    public Asignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    public Asignatura(int idAsignatura, String nombreAsignatura, Set profesors, Set notas) {
       this.idAsignatura = idAsignatura;
       this.nombreAsignatura = nombreAsignatura;
       this.profesors = profesors;
       this.notas = notas;
    }
   
    public int getIdAsignatura() {
        return this.idAsignatura;
    }
    
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }
    
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    public Set getProfesors() {
        return this.profesors;
    }
    
    public void setProfesors(Set profesors) {
        this.profesors = profesors;
    }
    public Set getNotas() {
        return this.notas;
    }
    
    public void setNotas(Set notas) {
        this.notas = notas;
    }




}


