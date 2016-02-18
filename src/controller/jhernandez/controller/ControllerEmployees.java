package controller.jhernandez.controller;

import controller.jhernandez.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.jhernandez.enums.Icons;
import model.jhernandez.enums.Images;
import model.jhernandez.interfaces.IControllerBase;
import org.jdesktop.swingx.decorator.*;
import view.jhernandez.modals.Employees;
import view.jhernandez.utils.FileChooser;

/**
 *
 * @author WIN 8
 */
public class ControllerEmployees implements IControllerBase, ActionListener, MouseListener {

    private final Employees viewEmployees;
    private File file;
    private FileInputStream fis = null;

    // <editor-fold defaultstate="expanded" desc="Constructor">
    public ControllerEmployees(Employees viewEmployees) {

        this.viewEmployees = viewEmployees;

        this.setViewValues();
        this.setCommands();
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación IControllerBase">
    @Override
    public void setViewValues() {
        this.viewEmployees.jBAgregar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Agregar.getRuta()), 45, 45));
        this.viewEmployees.jBModificar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Modificar.getRuta()), 45, 45));
        this.viewEmployees.jBBuscar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Buscar.getRuta()), 45, 45));
        this.viewEmployees.jBEliminar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Eliminar.getRuta()), 45, 45));
        this.viewEmployees.Photo.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.NoPhoto.getRuta()), 100, 100));

        this.viewEmployees.btnFirst.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Icons.GoFirst.getRuta()), 18, 18));
        this.viewEmployees.btnLast.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Icons.GoLast.getRuta()), 18, 18));
        this.viewEmployees.btnNext.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Icons.GoNext.getRuta()), 18, 18));
        this.viewEmployees.btnPrevious.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Icons.GoPrevious.getRuta()), 18, 18));
        this.viewEmployees.btnRefresh.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Icons.ViewRefresh.getRuta()), 18, 18));

        this.setNorthPanel();
        this.enableComponents(this.viewEmployees.jPDatosEmpleado, false);
    }

    @Override
    public void setCommands() {
        this.viewEmployees.jBAgregar.addActionListener(this);
        this.viewEmployees.Photo.addMouseListener(this);
    }

    @Override
    public void setControllers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación ActionListener">
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();
        if (control.equals(this.viewEmployees.jBAgregar)) {
            this.enableComponents(this.viewEmployees.jPDatosEmpleado, true);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación MouseListener">
    @Override
    public void mouseClicked(MouseEvent e) {
        int resultado;

        FileChooser chooser = new FileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        chooser.jfchCargarFoto.setFileFilter(extension);

        resultado = chooser.jfchCargarFoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado) {
            this.file = chooser.jfchCargarFoto.getSelectedFile();
            try {
                fis = new FileInputStream(this.file);
                Icon icono = new ImageIcon(new ImageIcon(this.file.toString()).getImage().getScaledInstance(this.viewEmployees.Photo.getWidth(), this.viewEmployees.Photo.getHeight(), Image.SCALE_DEFAULT));
                this.viewEmployees.Photo.setIcon(icono);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControllerEmployees.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerEmployees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    // </editor-fold>

    private void setNorthPanel() {
        this.viewEmployees.jxTableEmployees.setModel(new EmployeesTableModel());
        this.viewEmployees.jxTableEmployees.setColumnControlVisible(true);
        this.viewEmployees.jxTableEmployees.setShowHorizontalLines(true);
        this.viewEmployees.jxTableEmployees.setShowVerticalLines(true);

        this.viewEmployees.jxTableEmployees.addHighlighter(HighlighterFactory.createAlternateStriping());

//        Color lightBlue = new Color(0xC0D9D9);
//        Color gold = new Color(0xDBDB70);
//        this.viewEmployees.jxTableEmployees.addHighlighter(HighlighterFactory.createAlternateStriping(lightBlue, gold));
//        this.viewEmployees.jxTableEmployees.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW,
//                new Color(0x330000ff, true), Color.BLACK));

        /* On agrandit les colonnes au maximum */
        this.viewEmployees.jxTableEmployees.packAll();
    }

    private void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }
}
