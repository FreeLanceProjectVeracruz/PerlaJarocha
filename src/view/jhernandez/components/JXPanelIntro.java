package view.jhernandez.components;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.jdesktop.swingx.painter.*;

/**
 *
 * @author WIN 8
 */
public class JXPanelIntro extends JXPanel {

    private SlidingPainter textImagePainter;
    private ImagePainter introImagePainter;

    public JXPanelIntro() {
        this.setName("Perla Jarocha Ofertas!!");

        introImagePainter = new ImagePainter();
        introImagePainter.setFillHorizontal(true);
        introImagePainter.setVerticalAlignment(AbstractLayoutPainter.VerticalAlignment.CENTER);

        textImagePainter = new SlidingPainter();
        textImagePainter.setVisible(false);
        textImagePainter.setHorizontalAlignment(AbstractLayoutPainter.HorizontalAlignment.LEFT);
        textImagePainter.setVerticalAlignment(AbstractLayoutPainter.VerticalAlignment.TOP);

        Image image = new ImageIcon(JXPanelIntro.class.getResource("/mx/com/jhernandez/images/promotions/home_notext.png")).getImage();
        Image image2 = new ImageIcon(JXPanelIntro.class.getResource("/mx/com/jhernandez/images/promotions/home_text.png")).getImage();

        this.setIntroImage(image);
        this.setTextImage(image2);
        this.setBackgroundPainter(new CompoundPainter<>(introImagePainter, textImagePainter));
        this.bind();
    }

    /**
     *
     */
    private void bind() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                slideTextIn();
            }
        });
    }

    /**
     * Configures the intro image painter with the given image, converting to a
     * BufferedImage if necessary.
     *
     * @param image
     */
    private void setIntroImage(Image image) {
        introImagePainter.setImage(image instanceof BufferedImage
                ? (BufferedImage) image : GraphicsUtilities.convertToBufferedImage(image));
    }

    /**
     * Configures the text image painter with the given image, converting to a
     * BufferedImage if necessary.
     *
     * @param image
     */
    // <snip> ImagePainters for intro
    // the image is loaded via resource injection
    private void setTextImage(Image image) {
        textImagePainter.setImage(image instanceof BufferedImage
                ? (BufferedImage) image : GraphicsUtilities.convertToBufferedImage(image));
    }
    // </snip>

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // <snip> ImagePainters for intro
        // start animation of text
        if (!textImagePainter.isVisible()) {
            //slideTextIn();
            slideTextOut();
            textImagePainter.setVisible(true);
        }
    }

    // create, configure and start an animator on the painter's
    // horizontal location
    public void slideTextIn() {
        Animator animator = new Animator(800,
                new PropertySetter(textImagePainter, "x", getWidth(), 30));
        animator.setStartDelay(800);
        animator.setAcceleration(.2f);
        animator.setDeceleration(.5f);
        animator.start();
        // </snip>
    }

    public void slideTextOut() {
        Animator animator = new Animator(600,
                new PropertySetter(textImagePainter, "x", textImagePainter.getX(), -getWidth()));
        animator.setStartDelay(10);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.2f);
        animator.start();
    }

    public class SlidingPainter extends ImagePainter {

        public SlidingPainter(BufferedImage image) {
            super(image);
            // move out of the way ;-)
            setX(2000);
        }

        public SlidingPainter() {
            this(null);
        }

        public final void setX(int x) {
            setInsets(new Insets(110, x, 0, 0));
            // hack around an open issue in swingx:
            // CompoundPainter doesn't propagate property changes of contained
            // painters
            repaint();
        }

        public int getX() {
            return getInsets() != null ? getInsets().left : 0;
        }
    }
}
