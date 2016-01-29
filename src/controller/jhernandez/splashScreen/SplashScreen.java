package controller.jhernandez.splashScreen;

import model.jhernandez.configuration.*;
import java.awt.*;
import java.io.IOException;
import model.jhernandez.dataAccess.*;
import org.apache.log4j.*;

/**
 *
 * @author WIN 8
 */
public class SplashScreen {

    final java.awt.SplashScreen splash;
    final String[] texto = {"propiedades", "base de datos", "modulos"};
    private static final Logger log = Logger.getLogger(SplashScreen.class);

    /**
     * Constructor
     */
    public SplashScreen() {
        splash = java.awt.SplashScreen.getSplashScreen();
    }

    /**
     * Método que carga SplashScreen
     *
     * @return
     */
    public boolean loadingSplash() {
        try {
            if (splash != null) {
                Graphics2D g = splash.createGraphics();
                for (int i = 1; i < texto.length; i++) {
                    renderSplashFrame(g, i);
                    splash.update();
                    switch (i) {
                        case 1:
                            new DataBaseProperties(new GeneralProperties().getFileDbMysql());
                            break;
                        case 2:
                            DataAccess.getInstance();
                            break;
                        default:
                            break;
                    }

                    Thread.sleep(800);
                }
                splash.close();
            }
            return true;
        } catch (IllegalStateException | IOException | InterruptedException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    private void renderSplashFrame(Graphics2D g, int frame) {
        //se pinta texto del array
        g.setColor(new Color(4, 52, 101));//color de fondo
        g.fillRect(203, 328, 280, 12);//para tapar texto anterior
        g.setColor(Color.white);//color de texto	        
        g.drawString("Cargando " + texto[frame - 1] + "...", 203, 338);
        g.setColor(Color.green);//color de barra de progeso
        g.fillRect(204, 308, (frame * 307 / texto.length), 12);//la barra de progreso
        //se pinta una linea segmentada encima de la barra verde
        float dash1[] = {2.0f};
        BasicStroke dashed = new BasicStroke(9.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
        g.setStroke(dashed);
        g.setColor(Color.GREEN);//color de barra de progeso
        g.setColor(new Color(4, 52, 101));
        g.drawLine(205, 314, 510, 314);
    }
}
