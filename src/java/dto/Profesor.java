package dto;
// Generated 12-jun-2019 23:25:35 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Profesor generated by hbm2java
 */
public class Profesor  implements java.io.Serializable {


     private Integer idProfesor;
     private Asignatura asignatura;
     private Colegio colegio;
     private String nombreProfesor;
     private Date fechaNacProfesor;
     private String estadoProfesor;

    public Profesor() {
    }

    public Profesor(Asignatura asignatura, Colegio colegio, String nombreProfesor, Date fechaNacProfesor, String estadoProfesor) {
       this.asignatura = asignatura;
       this.colegio = colegio;
       this.nombreProfesor = nombreProfesor;
       this.fechaNacProfesor = fechaNacProfesor;
       this.estadoProfesor = estadoProfesor;
    }
   
    public Integer getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    public Colegio getColegio() {
        return this.colegio;
    }
    
    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }
    public String getNombreProfesor() {
        return this.nombreProfesor;
    }
    
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
    public Date getFechaNacProfesor() {
        return this.fechaNacProfesor;
    }
    
    public void setFechaNacProfesor(Date fechaNacProfesor) {
        this.fechaNacProfesor = fechaNacProfesor;
    }
    public String getEstadoProfesor() {
        return this.estadoProfesor;
    }
    
    public void setEstadoProfesor(String estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }




}

