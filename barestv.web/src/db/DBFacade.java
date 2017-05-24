package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

public class DBFacade {

    private static final String DATABASE = "local";
    private Connection con = null;
    private DataSource source;
    private PreparedStatement prepS;

    public DBFacade() throws NamingException {

        Context env = null;

        try {
            env = (Context) new InitialContext().lookup("java:comp/env");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        try {
            source = (DataSource) env.lookup(DATABASE);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }

    public void cerrarConexion() throws Exception {
        try {
            if (con != null) {
                con.close();
            }
            if (prepS != null) {
                prepS.close();
            }
        } catch (SQLException e) {
            throw new Exception("Error cerrando la conexión.");
        }

    }

    public void abrirConexion() throws Exception {
        try {
            con = source.getConnection();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            throw new Exception("Error abriendo la conexión.");
        }

    }

    public void commit() throws Exception {
        try {
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new Exception("Error haciendo commit.");
        }
    }

    public void rollback() throws Exception {
        try {
            con.rollback();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new Exception("Error haciendo un rollback.");
        }
    }

//	public ResultSet ejecutarConsulta(String statement) throws Exception {
//		ResultSet result = null;
//
//		try {
//			if (con == null) {
//				throw new Exception("Conexión nula, no se puede ejecutar la consulta.");
//			}
//			if (statement == null) {
//				throw new Exception("Consulta nula, no se puede ejecutar la consulta.");
//			}
//			prepS = con.prepareStatement(statement);
//			result = prepS.executeQuery();
//			
//		} catch (SQLException e) {
//			
//			throw new Exception("Error ejecutando consulta sin parametros "+e.getMessage());
//		} finally {
//
//		}
//
//		return result;
//	}
    public ResultSet ejecutarConsulta(String statement, Object... params) throws Exception {
        ResultSet result = null;

        try {
            if (con == null) {
                throw new Exception("Conexión nula, no se puede ejecutar la consulta.");
            }
            if (statement == null) {
                throw new Exception("Consulta nula, no se puede ejecutar la consulta.");
            }
            System.out.println("-------------------");
            System.out.println(statement);

            prepS = con.prepareStatement(statement);

            for (int i = 0; i < params.length; i++) {
                System.out.println("  " + (i+1) + " " + params[i].toString());
                prepS.setObject(i + 1, params[i]);
            }
            result = prepS.executeQuery();

        } catch (SQLException e) {

            throw new Exception("Error ejecutando consulta sin parametros " + e.getMessage());
        } finally {

        }

        return result;
    }

//	public int ejecutarUpdate(String statement) throws Exception {
//		int result = 0;
//		PreparedStatement prepS;
//		try {
//			if (con == null) {
//				throw new Exception("Conexión nula, no se puede ejecutar la consulta.");
//			}
//			if (statement == null) {
//				throw new Exception("Consulta nula, no se puede ejecutar la consulta.");
//			}
//			prepS = con.prepareStatement(statement);
//			result = prepS.executeUpdate(statement, Statement.RETURN_GENERATED_KEYS);
//
//			ResultSet rs = prepS.getGeneratedKeys();
//
//			if (rs.next()) {
//				result = rs.getInt(1);
//			}
//			commit();
//			System.out.println(statement);
//			return result;
//		} catch (SQLException e) {
//			rollback();
//			throw new Exception(e);
//		}
//
//	}
    public int ejecutarUpdate(String statement, Object... params) throws Exception {
        int result = 0;
        PreparedStatement prepS;
        try {
            if (con == null) {
                throw new Exception("Conexión nula, no se puede ejecutar la consulta.");
            }
            if (statement == null) {
                throw new Exception("Consulta nula, no se puede ejecutar la consulta.");
            }
            System.out.println("-------------------");
            System.out.println(statement);

            prepS = con.prepareStatement(statement);
            for (int i = 0; i < params.length; i++) {
                System.out.println("  " + (i+1) + " " + params[i].toString());
                prepS.setObject(i + 1, params[i]);
            }
            //result = prepS.executeUpdate(statement, Statement.RETURN_GENERATED_KEYS);
            result = prepS.executeUpdate();
            
            System.out.println(statement);
            return result;
        } catch (SQLException e) {
            rollback();
            throw new Exception(e);
        } 

    }

}
