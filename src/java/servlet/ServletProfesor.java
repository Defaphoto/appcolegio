package servlet;

import clases.CL_Profesor;
import com.google.gson.Gson;
import dao.DaoAsignatura;
import dao.DaoColegio;
import dao.DaoProfesor;
import dto.Asignatura;
import dto.Colegio;
import dto.Profesor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

















public class ServletProfesor
  extends HttpServlet
{
  public ServletProfesor() {}
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String accion = request.getParameter("accion");
    if (accion.equals("guardarProfesor")) {
      guardarProfesor(request, response);
    } else if (accion.equals("eliminarProfesor")) {
      eliminarProfesor(request, response);
    } else if (accion.equals("editarProfesor")) {
      editarProfesor(request, response);
    } else if (accion.equals("actualizarProfesor")) {
      actualizarProfesor(request, response);
    }
  }
  
  public void actualizarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String nombre = request.getParameter("nombre");
    String fechaNacimiento = request.getParameter("fechaNacimiento");
    String idColegio = request.getParameter("idColegio");
    String idAsignatura = request.getParameter("idAsignatura");
    String estado = request.getParameter("estado");
    String idProfesor = request.getParameter("idProfesor");
    
    Profesor nuevoProfesor = new Profesor();
    Asignatura relacionAsignatura = new Asignatura();
    relacionAsignatura.setIdAsignatura(Integer.parseInt(idAsignatura));
    Colegio relacionColegio = new Colegio();
    relacionColegio.setIdColegio(Integer.parseInt(idColegio));
    
    nuevoProfesor.setIdProfesor(Integer.parseInt(idProfesor));
    nuevoProfesor.setEstadoProfesor(estado);
    nuevoProfesor.setFechaNacProfesor(new Date(fechaNacimiento));
    nuevoProfesor.setNombreProfesor(nombre);
    nuevoProfesor.setAsignatura(relacionAsignatura);
    nuevoProfesor.setColegio(relacionColegio);
    
    DaoProfesor daoProfesor = new DaoProfesor();
    daoProfesor.modificar(nuevoProfesor);
  }
  
  public void editarProfesor(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    RequestDispatcher redirigir = request.getRequestDispatcher("profesor/profesorEditar.jsp");
    request.setAttribute("idProfesor", request.getParameter("idProfesor"));
    redirigir.forward(request, response);
  }
  
  public void eliminarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String idProfesor = request.getParameter("idProfesor");
    DaoProfesor daoProfesor = new DaoProfesor();
    daoProfesor.eliminar(Integer.parseInt(idProfesor));
    
    List<Profesor> listProfesores = daoProfesor.listar();
    List<CL_Profesor> listaProfesoresJSON = new ArrayList();
    
    DaoColegio daoColegio = new DaoColegio();
    DaoAsignatura daoAsignatura = new DaoAsignatura();
    List<Colegio> colegios = daoColegio.listar();
    List<Asignatura> asignaturas = daoAsignatura.listar();
    

    for (Profesor itemProfesor : listProfesores) {
      CL_Profesor nuevo = new CL_Profesor();
      nuevo.setIdProfesor(itemProfesor.getIdProfesor());
      nuevo.setNombreProfesor(itemProfesor.getNombreProfesor());
      nuevo.setFechaNacProfesor(itemProfesor.getFechaNacProfesor().toString());
      nuevo.setEstadoProfesor(itemProfesor.getEstadoProfesor());
      
      for (Asignatura asignatura : asignaturas) {
        if (asignatura.getIdAsignatura() == itemProfesor.getAsignatura().getIdAsignatura()) {
          nuevo.setAsignatura(asignatura.getNombreAsignatura());
          break;
        }
      }
      for (Colegio colegio : colegios) {
        if (colegio.getIdColegio() == itemProfesor.getColegio().getIdColegio()) {
          nuevo.setColegio(colegio.getNombreColegio());
          break;
        }
      }
      listaProfesoresJSON.add(nuevo);
    }
    
    response.setContentType("application/json");
    new Gson().toJson(listaProfesoresJSON, response.getWriter());
  }
  
  public void guardarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    String nombre = request.getParameter("nombre");
    String fechaNacimiento = request.getParameter("fechaNacimiento");
    String idColegio = request.getParameter("idColegio");
    String idAsignatura = request.getParameter("idAsignatura");
    String estado = request.getParameter("estado");
    
    Profesor nuevoProfesor = new Profesor();
    Asignatura relacionAsignatura = new Asignatura();
    relacionAsignatura.setIdAsignatura(Integer.parseInt(idAsignatura));
    Colegio relacionColegio = new Colegio();
    relacionColegio.setIdColegio(Integer.parseInt(idColegio));
    
    nuevoProfesor.setEstadoProfesor(estado);
    nuevoProfesor.setFechaNacProfesor(new Date(fechaNacimiento));
    nuevoProfesor.setNombreProfesor(nombre);
    nuevoProfesor.setAsignatura(relacionAsignatura);
    nuevoProfesor.setColegio(relacionColegio);
    
    DaoProfesor daoProfesor = new DaoProfesor();
    daoProfesor.agregar(nuevoProfesor);
    


    List<Profesor> listProfesores = daoProfesor.listar();
    List<CL_Profesor> listaProfesoresJSON = new ArrayList();
    
    DaoColegio daoColegio = new DaoColegio();
    DaoAsignatura daoAsignatura = new DaoAsignatura();
    List<Colegio> colegios = daoColegio.listar();
    List<Asignatura> asignaturas = daoAsignatura.listar();
    

    for (Profesor itemProfesor : listProfesores) {
      CL_Profesor nuevo = new CL_Profesor();
      nuevo.setIdProfesor(itemProfesor.getIdProfesor());
      nuevo.setNombreProfesor(itemProfesor.getNombreProfesor());
      nuevo.setFechaNacProfesor(itemProfesor.getFechaNacProfesor().toString());
      nuevo.setEstadoProfesor(itemProfesor.getEstadoProfesor());
      
      for (Asignatura asignatura : asignaturas) {
        if (asignatura.getIdAsignatura() == itemProfesor.getAsignatura().getIdAsignatura()) {
          nuevo.setAsignatura(asignatura.getNombreAsignatura());
          break;
        }
      }
      for (Colegio colegio : colegios) {
        if (colegio.getIdColegio() == itemProfesor.getColegio().getIdColegio()) {
          nuevo.setColegio(colegio.getNombreColegio());
          break;
        }
      }
      listaProfesoresJSON.add(nuevo);
    }
    
    response.setContentType("application/json");
    new Gson().toJson(listaProfesoresJSON, response.getWriter());
  }
  










  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
  }
  








  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
  }
  





  public String getServletInfo()
  {
    return "Short description";
  }
}