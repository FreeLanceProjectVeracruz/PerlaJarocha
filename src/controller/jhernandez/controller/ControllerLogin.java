package controller.jhernandez.controller;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import model.jhernandez.dao.*;
import model.jhernandez.interfaces.*;
import view.jhernandez.views.*;
import model.jhernandez.vo.*;

/**
 *
 * @author WIN 8
 */
public class ControllerLogin implements IControllerBase, ActionListener {

    private final Login viewLogin;
    private final LoginDao model;
    public UsersVo user;

    /**
     * Constructor
     *
     * @param vista
     * @param modelo
     */
    public ControllerLogin(Login vista, LoginDao modelo) {
        this.viewLogin = vista;
        this.model = modelo;

        this.setControllers();
        this.setViewValues();
    }

    // <editor-fold defaultstate="expanded" desc="Implementación IControllerBase">
    /**
     *
     */
    @Override
    public final void setViewValues() {
        this.viewLogin.setLocationRelativeTo(null);
        this.viewLogin.pack();
        this.viewLogin.iniciar.requestFocusInWindow();

        ImageIcon usuarioImage = new ImageIcon(this.getClass().getResource("/view/jhernandez/images/usuario.png"));
        Icon iconoUser = new ImageIcon(usuarioImage.getImage()
                .getScaledInstance(this.viewLogin.usuario.getWidth(), this.viewLogin.usuario.getHeight(), Image.SCALE_DEFAULT));
        Icon iconoPass = new ImageIcon(new ImageIcon(this.getClass().getResource("/view/jhernandez/images/candado.png")).getImage()
                .getScaledInstance(this.viewLogin.contraseña.getWidth(), this.viewLogin.contraseña.getHeight(), Image.SCALE_DEFAULT));

        this.viewLogin.usuario.setIcon(iconoUser);
        this.viewLogin.contraseña.setIcon(iconoPass);

        this.setCommands();

        this.viewLogin.repaint();
        this.viewLogin.panelMsj.setVisible(false);
        this.viewLogin.setVisible(true);
    }

    /**
     *
     */
    @Override
    public void setCommands() {
        this.viewLogin.iniciar.setActionCommand("Abrir Sesion");
        this.viewLogin.cancelar.setActionCommand("Cerrar Sesion");

        this.viewLogin.iniciar.addActionListener(this);
        this.viewLogin.cancelar.addActionListener(this);
    }

    @Override
    public final void setControllers() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación ActionListener">
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();

        if (control.equals(this.viewLogin.iniciar)) {
            this.user = this.model.getUser(this.viewLogin.usuarioTexto.getText(),
                    new String(this.viewLogin.contraseñaTexto.getPassword()));
            if (this.user.hashCode() > 0 && this.user.isActive()) {
                this.viewLogin.setVisible(false);
            } else {
                this.viewLogin.panelMsj.setVisible(true);
                this.viewLogin.mensaje.setText("Usuario o contraseña no validos!");
            }
        } else if (control.equals(this.viewLogin.cancelar)) {
            this.viewLogin.dispose();
//            this.viewLogin.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);

            System.exit(0);
        }
    }
    // </editor-fold>
}
