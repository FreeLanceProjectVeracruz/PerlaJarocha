/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.jhernandez.controller;

import controller.jhernandez.utils.UtilsImages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.jhernandez.enums.Images;
import model.jhernandez.interfaces.IControllerBase;
import view.jhernandez.modals.Clients;

/**
 *
 * @author Martin_txs
 */
public class ControllerClients implements IControllerBase, ActionListener {

    private final Clients viewClients;

    public ControllerClients(Clients viewClients) {
        this.viewClients = viewClients;
        this.setViewValues();
        this.setCommands();
    }

    @Override
    public void setViewValues() {
        this.viewClients.jBAgregar.setIcon(UtilsImages.getResizableIcon(this.viewClients.getClass().getResource(Images.agregarCliente.getRuta()), 45, 45));
        this.viewClients.jBEliminar.setIcon(UtilsImages.getResizableIcon(this.viewClients.getClass().getResource(Images.eliminarCliente.getRuta()), 45, 45));
        this.viewClients.jBModificar.setIcon(UtilsImages.getResizableIcon(this.viewClients.getClass().getResource(Images.modificarCliente.getRuta()), 45, 45));
        this.viewClients.jBBuscar.setIcon(UtilsImages.getResizableIcon(this.viewClients.getClass().getResource(Images.buscarCliente.getRuta()), 45, 45));
    }

    @Override
    public void setCommands() {
    }

    @Override
    public void setControllers() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
