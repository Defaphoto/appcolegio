package clases;


public class CL_Profesor
{
  private int idProfesor;
  
  private String asignatura;
  
  private String colegio;
  
  private String nombreProfesor;
  
  private String fechaNacProfesor;
  
  private String estadoProfesor;
  

  public CL_Profesor() {}
  

  public int getIdProfesor()
  {
    return idProfesor;
  }
  
  public void setIdProfesor(int idProfesor) {
    this.idProfesor = idProfesor;
  }
  
  public String getAsignatura() {
    return asignatura;
  }
  
  public void setAsignatura(String asignatura) {
    this.asignatura = asignatura;
  }
  
  public String getColegio() {
    return colegio;
  }
  
  public void setColegio(String colegio) {
    this.colegio = colegio;
  }
  
  public String getNombreProfesor() {
    return nombreProfesor;
  }
  
  public void setNombreProfesor(String nombreProfesor) {
    this.nombreProfesor = nombreProfesor;
  }
  
  public String getFechaNacProfesor() {
    return fechaNacProfesor;
  }
  
  public void setFechaNacProfesor(String fechaNacProfesor) {
    this.fechaNacProfesor = fechaNacProfesor;
  }
  
  public String getEstadoProfesor() {
    return estadoProfesor;
  }
  
  public void setEstadoProfesor(String estadoProfesor) {
    this.estadoProfesor = estadoProfesor;
  }
}
