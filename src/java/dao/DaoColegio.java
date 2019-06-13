package dao;

import conexion.ConexionBD;
import dto.Colegio;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class DaoColegio
{
  private Session sesion;
  private Transaction tx;
  
  public DaoColegio() {}
  
  public void iniOperacion()
  {
    sesion = ConexionBD.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
  }
  
  public boolean agregar(Colegio nuevo) {
    try {
      iniOperacion();
      sesion.save(nuevo);
      tx.commit();
      sesion.close();
      return true;
    } catch (Exception e) {
      tx.rollback();
      sesion.close();
      throw new RuntimeException("No agrego un colegio " + e.getMessage());
    }
  }
  
  public boolean eliminar(int id)
  {
    try {
      iniOperacion();
      Colegio colegio = buscar(id);
      sesion.delete(colegio);
      tx.commit();
      sesion.close();
      return true;
    } catch (Exception e) {
      tx.rollback();
      sesion.close();
      throw new RuntimeException("No elimino el colegio " + e.getMessage());
    }
  }
  
  public boolean modificar(Colegio nuevo)
  {
    try {
      iniOperacion();
      sesion.update(nuevo);
      tx.commit();
      sesion.close();
      return true;
    } catch (Exception e) {
      tx.rollback();
      sesion.close();
      throw new RuntimeException("No se modifico el colegio " + e.getMessage());
    }
  }
  
  public Colegio buscar(int id) {
    try {
      iniOperacion();
      List<Colegio> listado = sesion.createQuery("from Colegio where idColegio=" + id).list();
        for (Colegio item : listado) {
            return item;
        }
    }
     catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se encontro el producto "+e.getMessage());
        }
        return null;
  }
  
  public List<Colegio> listar()
  {
    try {
      iniOperacion();
      return sesion.createQuery("from Colegio").list();
    }
    catch (Exception e) {
      tx.rollback();
      sesion.close();
      throw new RuntimeException("No se listo los colegios " + e.getMessage());
    }
  }
}
