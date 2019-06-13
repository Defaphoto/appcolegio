package dao;

import conexion.ConexionBD;
import dto.Asignatura;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoAsignatura {

    private Session sesion;
    private Transaction tx;

    public DaoAsignatura() {
    }

    public void iniOperacion() {
        sesion = ConexionBD.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    public boolean agregar(Asignatura nuevo) {
        try {
            iniOperacion();
            sesion.save(nuevo);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No agrego un asignatura " + e.getMessage());
        }
    }

    public boolean eliminar(int id) {
        try {
            iniOperacion();
            Asignatura asignatura = buscar(id);
            sesion.delete(asignatura);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No elimino el asignatura " + e.getMessage());
        }
    }

    public boolean modificar(Asignatura nuevo) {
        try {
            iniOperacion();
            sesion.update(nuevo);
            tx.commit();
            sesion.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se modifico el asignatura " + e.getMessage());
        }
    }

    public Asignatura buscar(int id) {
        try {
            iniOperacion();
            List<Asignatura> listado = sesion.createQuery("from Asignatura where idAsignatura=" + id).list();
            for (Asignatura item : listado) {
                return item;
            }
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se encontro el asignatura " + e.getMessage());
        }
        return null;
    }

    public List<Asignatura> listar() {
        try {
            iniOperacion();
            return sesion.createQuery("from Asignatura").list();
        } catch (Exception e) {
            tx.rollback();
            sesion.close();
            throw new RuntimeException("No se listo los asignaturas " + e.getMessage());
        }
    }
}
