package view.jhernandez.components;

import javax.swing.*;
import java.awt.*;

/**
 * Component to be used as tabComponent; Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
public class JPanelTabComponent extends JPanel {

    // <editor-fold defaultstate="expanded" desc="Atributos privados">
    private final JTabbedPane pane;
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Constructor">
    public JPanelTabComponent(final JTabbedPane pane) {
        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        setOpaque(false);

        //make JLabel read titles from JTabbedPane
        JLabel label = new JLabel() {
            @Override
            public String getText() {
                int i = pane.indexOfTabComponent(JPanelTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        this.add(label);
        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        this.add(new JButtonX(this.pane, this));
        //add more space to the top of the component
        this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }
    // </editor-fold>
}
