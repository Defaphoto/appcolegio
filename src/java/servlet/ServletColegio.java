package servlet;

import com.google.gson.Gson;
import dao.DaoColegio;
import dto.Colegio;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
















public class ServletColegio
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public ServletColegio() {}
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String accion = request.getParameter("accion");
    if (accion.equals("guardarColegio")) {
      guardarColegio(request, response);
    }
    else if (accion.equals("editarColegio")) {
      editarColegio(request, response);
    } else if (accion.equals("actualizarColegio")) {
      actualizarColegio(request, response);
    } else if (accion.equals("eliminarColegio")) {
      eliminarColegio(request, response);
    }
  }
  
  public void guardarColegio(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    
    DaoColegio daoColegio = new DaoColegio();
    Colegio nuevo = new Colegio();
    nuevo.setNombreColegio(nombre);
    nuevo.setDireccionColegio(direccion);
    daoColegio.agregar(nuevo);
    
    List<Colegio> listaColegios = daoColegio.listar();
    response.setContentType("application/json");
    new Gson().toJson(listaColegios, response.getWriter());
  }
  
  public void editarColegio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    RequestDispatcher redirigir = request.getRequestDispatcher("colegio/colegioEditar.jsp");
    request.setAttribute("idColegio", request.getParameter("idColegio"));
    redirigir.forward(request, response);
  }
  
  public void actualizarColegio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String idColegio = request.getParameter("idColegio");
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    
    DaoColegio daoColegio = new DaoColegio();
    Colegio nuevo = new Colegio();
    nuevo.setIdColegio(Integer.parseInt(idColegio));
    nuevo.setNombreColegio(nombre);
    nuevo.setDireccionColegio(direccion);
    daoColegio.modificar(nuevo);
  }
  
  public void eliminarColegio(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String idColegio = request.getParameter("idColegio");
    

    DaoColegio daoColegio = new DaoColegio();
    daoColegio.eliminar(Integer.parseInt(idColegio));
    
    List<Colegio> listaColegios = daoColegio.listar();
    response.setContentType("application/json");
    new Gson().toJson(listaColegios, response.getWriter());
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