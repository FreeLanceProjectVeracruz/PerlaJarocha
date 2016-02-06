package controller.jhernandez.controller;

import controller.jhernandez.utils.UtilsImages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.jhernandez.enums.Images;
import model.jhernandez.interfaces.IControllerBase;
import view.jhernandez.modals.Employees;

/**
 *
 * @author WIN 8
 */
public class ControllerEmployees implements IControllerBase, ActionListener{

    private final Employees viewEmployees;

    public ControllerEmployees(Employees viewEmployees) {

        this.viewEmployees = viewEmployees;
        this.viewEmployees.jBAgregar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Agregar.getRuta()), 45, 45));
        this.viewEmployees.jBModificar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Modificar.getRuta()), 45, 45));
        this.viewEmployees.jBBuscar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Buscar.getRuta()), 45, 45));
        this.viewEmployees.jBEliminar.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.Eliminar.getRuta()), 45, 45));
        this.viewEmployees.Photo.setIcon(UtilsImages.getResizableIcon(this.viewEmployees.getClass().getResource(Images.NoPhoto.getRuta()), 100, 100));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setViewValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCommands() {
        this.viewEmployees.jBAgregar.addActionListener(this);
    }

    @Override
    public void setControllers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
