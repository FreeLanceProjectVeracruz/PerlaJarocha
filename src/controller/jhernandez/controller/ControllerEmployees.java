package controller.jhernandez.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.viewEmployees.Photo.setIcon(null);
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
