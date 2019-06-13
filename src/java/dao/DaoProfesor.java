package dao;

import conexion.ConexionBD;
import dto.Profesor;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoProfesor {

    private Session sesion;
    private Transaction tx;

    public DaoProfesor() {
    }

    public void iniOperacion() {
        sesion = ConexionBD.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    public boolean agregar(Profesor nuevo) {
        try {
            iniOperacion();
            sesion.save(nuevo);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No agrego un profesor " + e.getMessage());
        }
    }

    public boolean eliminar(int id) {
        try {
            iniOperacion();
            Profesor profesor = buscar(id);
            sesion.delete(profesor);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No elimino el profesor " + e.getMessage());
        }
    }

    public boolean modificar(Profesor nuevo) {
        try {
            iniOperacion();
            sesion.update(nuevo);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se modifico el profesor " + e.getMessage());
        }
    }

    public Profesor buscar(int id) {
        try {
            iniOperacion();
            List<Profesor> listado = sesion.createQuery("from Profesor where idProfesor=" + id).list();
            for (Profesor item : listado) {
                return item;
            }
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se encontro el profesor " + e.getMessage());
        }
        return null;
    }

    public List<Profesor> listar() {
        try {
            iniOperacion();
            return sesion.createQuery("from Profesor").list();
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se listo los profesor " + e.getMessage());
        }
    }
}
