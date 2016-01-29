package model.jhernandez.dao;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import model.jhernandez.dataAccess.*;
import model.jhernandez.interfaces.*;
import model.jhernandez.vo.UsersVo;
import org.apache.log4j.*;

public class LoginDao extends Observable implements IUsersDao {

    static final Logger log = Logger.getLogger(LoginDao.class);

    /**
     * Constructor
     */
    public LoginDao() {
    }

    // <editor-fold defaultstate="expanded" desc="Implementación IUsersDao">
    /**
     *
     *
     * @return
     */
    @Override
    public List<UsersVo> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que obtiene la identificacion del usuario
     *
     * @param user
     * @param pass
     * @return
     */
    @Override
    public UsersVo getUser(String user, String pass) {
        UsersVo persona = new UsersVo();

        try {
            CallableStatement proc = DataAccess.getInstance()
                    .getConnection()
                    .prepareCall("{CALL `seguridad.getuser`(?,?)}");
            //se cargan los parametros de entrada
            proc.setString(1, user);
            proc.setString(2, pass);

            proc.execute();
            ResultSet rs = proc.getResultSet();

            while (rs.next()) {
                persona.setIdUser(Integer.parseInt(rs.getString("idUser")));
                persona.setIdentification(rs.getString("identification"));
                persona.setName(rs.getString("name"));
                persona.setEmail(rs.getString("email"));
                if (rs.getBytes("imageFile") != null) {
                    //se lee la cadena de bytes de la base de datos
                    byte[] b = rs.getBytes("imageFile");
                    // esta cadena de bytes sera convertida en una imagen                
                    persona.setImageFile(this.convertirImagen(b));
                }
                persona.setActive(rs.getBoolean("active"));
            }

            if (persona.isActive()) {
                setChanged();
                notifyObservers(persona.getImageFile());
            }

            return persona;
        } catch (IOException | SQLException | NumberFormatException e) {
            log.error(e);
            return null;
        }
    }
    // </editor-fold>

    //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
    private Image convertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("JPG");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();

        return reader.read(0, param);
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
    }
}
