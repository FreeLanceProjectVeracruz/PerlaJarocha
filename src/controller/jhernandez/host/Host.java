package controller.jhernandez.host;

import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import controller.jhernandez.controller.*;
import model.jhernandez.dao.*;
import controller.jhernandez.splashScreen.*;
import view.jhernandez.views.*;
import org.apache.log4j.*;
import org.pushingpixels.substance.api.skin.*;

/**
 *
 * @author WIN 8
 */
public class Host {

    private static boolean loaded;
    static final Logger log = Logger.getLogger(Host.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log.info("Iniciando aplicación..");

        try {
            SwingUtilities.invokeAndWait(() -> {
                loaded = new SplashScreen().loadingSplash();
            });

            if (loaded) {
                // Code to start system (nothing that touches the GUI)
                SwingUtilities.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());
                    } catch (UnsupportedLookAndFeelException ex) {
                        log.error(ex);
                    }
                    new ControllerPrincipal(new Principal(), new PrincipalDao());
                });
            }
        } catch (InterruptedException | InvocationTargetException ex) {
            log.error(ex);
        }
    }
}
