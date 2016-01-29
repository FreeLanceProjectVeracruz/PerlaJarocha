package view.jhernandez.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author WIN 8
 */
public class JButtonX extends JButton implements MouseListener {

    // <editor-fold defaultstate="expanded" desc="Constructor">
    public JButtonX(JTabbedPane tPane, JPanelTabComponent jPane) {
        int size = 17;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("Cerrar pestaña");
        //Make the button looks the same for all Laf's
        setUI(new BasicButtonUI());
        //Make it transparent
        setContentAreaFilled(false);
        //No need to be focusable
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);

        setRolloverEnabled(true);

        addActionListener((ActionEvent e) -> {
            int i = tPane.indexOfTabComponent(jPane);
            if (i != -1) {
                tPane.remove(i);
            }
        });
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación MouseListener">
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Método abstracto de JButton">
    @Override
    public void updateUI() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Método abstracto de JComponent">
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        //shift the image for pressed buttons
        if (getModel().isPressed()) {
            g2.translate(1, 1);
        }
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        if (getModel().isRollover()) {
            g2.setColor(Color.MAGENTA);
        }
        int delta = 6;
        g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
        g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
        g2.dispose();
    }
    // </editor-fold>
}
