package controller.jhernandez.controller;

import controller.jhernandez.utils.UtilsImages;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.jhernandez.enums.Images;
import model.jhernandez.interfaces.IControllerBase;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();
        if (control.equals(this.viewEmployees.jBAgregar)) {
        }
    }

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
}
