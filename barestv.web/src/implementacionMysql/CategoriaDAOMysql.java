package implementacionMysql;

import java.sql.ResultSet;
import java.util.ArrayList;

import beans.*;
import dao.*;
import db.DBFacade;

public class CategoriaDAOMysql implements CategoriaInterfazDAO {

    private DBFacade db = null;

    public CategoriaDAOMysql() throws Exception {
        // TODO Auto-generated constructor stub
        try {
            db = new DBFacade();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error creando DBFacade");
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Categoria get(String nombreCat) throws Exception {
        Categoria cat = null;
        try {
            db.abrirConexion();
            String sql = "select nombrecat from categoria where nombrecat ='" + nombreCat + "';";
            ResultSet rs = db.ejecutarConsulta(sql);

            while (rs.next()) {
                cat = new Categoria(rs.getString("nombrecat"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener categoria: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
            }
        }
        return cat;
    }

    @Override
    public ArrayList<Categoria> getAll() throws Exception {
        ArrayList<Categoria> categorias = null;
        try {
            db.abrirConexion();
            String sql = "select nombrecat from categoria;";
            ResultSet rs = db.ejecutarConsulta(sql);
            categorias = new ArrayList<Categoria>();
            while (rs.next()) {
                categorias.add(new Categoria(rs.getString("nombrecat")));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener categorias: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
            }
        }
        return categorias;
    }

    @Override
    public boolean edit(Categoria cat, String nombreCatNuevo) throws Exception {
        // TODO Auto-generated method stub
        Boolean esCorrecto = true;
        try {
            db.abrirConexion();
            String queryString = "UPDATE categoria SET  nombrecat = ?"
                    + " WHERE  nombrecat = ?";
            db.ejecutarUpdate(queryString, nombreCatNuevo, cat.getNombreCat());
           
            cat.setNombreCat(nombreCatNuevo);
        } catch (Exception e) {
            System.out.println("Error al modificar categoria: " + e.getMessage());
            esCorrecto = false;
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
                esCorrecto = false;
            }
        }
        return esCorrecto;
    }

    @Override
    public boolean add(Categoria cat) throws Exception {
        Boolean esCorrecto = true;
        try {
            db.abrirConexion();
            String queryString = "insert into categoria (nombrecat) values (?)";
            db.ejecutarUpdate(queryString, cat.getNombreCat());
           
        } catch (Exception e) {
            System.out.println("Error al a?adir categoria: " + e.getMessage());
            esCorrecto = false;
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
                esCorrecto = false;
            }
        }
        return esCorrecto;
    }

    @Override
    public boolean remove(Categoria cat) throws Exception {
        // TODO Auto-generated method stub
        Boolean esCorrecto = true;
        try {
            db.abrirConexion();
            String queryString = "DELETE FROM categoria WHERE nombrecat = ?";
            db.ejecutarUpdate(queryString, cat.getNombreCat());
          
        } catch (Exception e) {
            System.out.println("Error al modificar categoria: " + e.getMessage());
            esCorrecto = false;
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
                esCorrecto = false;
            }
        }
        return esCorrecto;
    }

    @Override
    public boolean exist(String nombreCat) throws Exception {
        boolean es = false;
        try {
            db.abrirConexion();
            String sql = "select * from categoria where nombrecat like ?;";
            ResultSet rs = db.ejecutarConsulta(sql, nombreCat);

            while (rs.next()) {
                es = true;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener categoria: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.cerrarConexion();
            } catch (Exception e1) {
                System.out.println("Error cerrando la conexion");
            }
        }
        return es;
    }

}
