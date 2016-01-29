package model.jhernandez.dataAccess;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import model.jhernandez.configuration.*;
import org.apache.log4j.*;

/**
 *
 * @author WIN 8
 */
public class DataAccess {

    private static volatile DataAccess INSTANCE;
    private Connection cnx;
    private final String ipHost;
    private final String puerto;
    private final String baseDatos;
    private final String usuario;
    private final String contrasena;
    private String cadenaConexion;
    private String driver;
    private final String gestorBD;
    static final Logger log = Logger.getLogger(DataAccess.class);

    /**
     *
     * @param rdMysql
     */
    public DataAccess(ReadProperties rdMysql) {
        this.ipHost = rdMysql.getIpHost();
        this.puerto = rdMysql.getPuerto();
        this.baseDatos = rdMysql.getBasedatos();
        this.usuario = rdMysql.getUsuario();
        this.contrasena = rdMysql.getContrasena();
        this.gestorBD = rdMysql.getGestor();

        if (gestorBD.equalsIgnoreCase("MYSQL")) {
            this.cadenaConexion = "jdbc:mysql://" + ipHost + ":" + puerto + "/" + baseDatos;
            this.driver = "com.mysql.jdbc.Driver";
        } else {
            log.error("No existe implementacion para ese gestor");
        }
    }

    /**
     * Método para Conexión a Base de Datos
     *
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    public boolean connectBD() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            Class.forName(this.driver).newInstance();
            cnx = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            cnx.setAutoCommit(false);
            return true;
        } catch (ClassNotFoundException ex) {
            log.error("causa: " + ex.getCause());
            log.error("Mensaje: " + ex.getMessage());
            log.error("Localizacion: " + ex.getLocalizedMessage());
            log.error("Traza: " + Arrays.toString(ex.getStackTrace()));
            throw ex;
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            log.error("causa: " + ex.getCause());
            log.error("Mensaje: " + ex.getMessage());
            log.error("Localizacion: " + ex.getLocalizedMessage());
            log.error("Traza: " + Arrays.toString(ex.getStackTrace()));
            throw ex;
        }
    }

    /**
     * Método para Desconexión a Base de Datos
     *
     * @return
     * @throws SQLException
     */
    public boolean desconnectBD() throws SQLException {
        try {
            cnx.close();
            cnx = null;
            return true;
        } catch (SQLException ex) {
            log.error("causa: " + ex.getCause());
            log.error("Mensaje: " + ex.getMessage());
            log.error("Localizacion: " + ex.getLocalizedMessage());
            log.error("Traza: " + Arrays.toString(ex.getStackTrace()));
            throw ex;
        }
    }

    /**
     * Método para obtencion de conexión
     *
     * @return
     */
    public Connection getConnection() {
        return this.cnx;
    }

    /**
     *
     * @return
     */
    public String getUrlConnection() {
        return this.cadenaConexion;
    }

    /**
     *
     * @return
     */
    public static DataAccess getInstance() {
        DataAccess localInstance = INSTANCE;
        if (INSTANCE == null) {
            synchronized (DataAccess.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    try {
                        INSTANCE = localInstance = new DataAccess(
                                new ReadProperties(new ModelProperties().getFileDbMysql()));
                        log.info("Conexión a MYSQL: " + localInstance.connectBD());
                    } catch (IOException | ClassNotFoundException | InstantiationException |
                            IllegalAccessException | SQLException ex) {
                        log.log(Priority.FATAL, ex.getMessage(), ex);
                    }
                }
            }
        }
        return localInstance;
    }
}
