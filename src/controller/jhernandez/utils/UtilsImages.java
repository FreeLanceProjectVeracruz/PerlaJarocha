package controller.jhernandez.utils;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.pushingpixels.flamingo.api.common.icon.*;

/**
 *
 * @author WIN 8
 */
public class UtilsImages {

    // <editor-fold defaultstate="expanded" desc="By String">
    /**
     *
     * @param image
     * @param width
     * @param height
     * @return
     */
    public Icon getIcon(String image, int width, int height) {
        return new ImageIcon(getImage(image, width, height));
    }

    BufferedImage getImage(String image, int width, int height) {
        return GraphicsUtilities.createThumbnail(getImage(image), width, height);
    }

    Icon getIcon(String imagefilename) {
        return new ImageIcon(getImage(imagefilename));
    }

    BufferedImage getImage(String imagefilename) {
        try {
            return ImageIO.read(ClassLoader.getSystemResourceAsStream(imagefilename));
        } catch (IOException e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="By URL">
    /**
     * Obtain Image
     *
     * @param image
     * @return
     */
    public static Image getImage(URL image) {
        return Toolkit.getDefaultToolkit().createImage(image);
    }

    /**
     * Obtain Icon
     *
     * @param image
     * @param width
     * @param height
     * @return
     */
    public static Icon getIcon(URL image, int width, int height) {
        return new ImageIcon(getImage(image, width, height));
    }

    /**
     * Obtain BufferedImage
     *
     * @param url
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getImage(URL url, int width, int height) {
        try {
            return GraphicsUtilities.createThumbnail(ImageIO.read(url), width, height);
        } catch (IOException ex) {
            Logger.getLogger(UtilsImages.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param url
     * @param width
     * @param height
     * @return
     */
    public static ResizableIcon getResizableIcon(URL url, int width, int height) {
        return ImageWrapperResizableIcon.getIcon(url, new Dimension(width, height));
    }
    // </editor-fold>
}
