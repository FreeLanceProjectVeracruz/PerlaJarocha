package model.jhernandez.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author WIN 8
 */
public class ReadProperties {

    private java.net.URL ruta;
    private String ipHost;
    private String puerto;
    private String basedatos;
    private String usuario;
    private String contrasena;
    private String gestor;
    static final Logger log = Logger.getLogger(ReadProperties.class);

    /**
     * Constructor
     *
     * @param path
     * @throws IOException
     */
    public ReadProperties(URL path) throws IOException {
        this.ruta = path;
        init();
    }

    private void init() throws IOException {
        try {
            Properties props = new Properties();
            try (InputStream in = ruta.openStream()) {
                props.load(in);
                ipHost = props.getProperty("iphost");
                puerto = props.getProperty("puerto");
                basedatos = props.getProperty("namedb");
                usuario = props.getProperty("usuario");
                contrasena = props.getProperty("contrasena");
                gestor = props.getProperty("gestor");
            }
        } catch (IOException ex) {
            log.error("causa: " + ex.getCause());
            log.error("Mensaje: " + ex.getMessage());
            log.error("Localizacion: " + ex.getLocalizedMessage());
            log.error("Traza: " + Arrays.toString(ex.getStackTrace()));
            throw ex;
        }
    }

    /**
     *
     * @return
     */
    public URL getRuta() {
        return ruta;
    }

    /**
     *
     * @param ruta
     */
    public void setRuta(URL ruta) {
        this.ruta = ruta;
    }

    /**
     *
     * @return
     */
    public String getIpHost() {
        return ipHost;
    }

    /**
     *
     * @param ipHost
     */
    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    /**
     *
     * @return
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     *
     * @param puerto
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     *
     * @return
     */
    public String getBasedatos() {
        return basedatos;
    }

    /**
     *
     * @param basedatos
     */
    public void setBasedatos(String basedatos) {
        this.basedatos = basedatos;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *
     * @return
     */
    public String getGestor() {
        return gestor;
    }

    /**
     *
     * @param gestor
     */
    public void setGestor(String gestor) {
        this.gestor = gestor;
    }
}
