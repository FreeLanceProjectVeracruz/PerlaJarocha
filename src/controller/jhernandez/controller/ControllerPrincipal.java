package controller.jhernandez.controller;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import view.jhernandez.components.*;
import model.jhernandez.dao.*;
import model.jhernandez.dataAccess.*;
import model.jhernandez.enums.*;
import model.jhernandez.interfaces.*;
import view.jhernandez.modals.*;
import controller.jhernandez.utils.*;
import view.jhernandez.views.*;
import org.apache.log4j.*;
import org.jdesktop.swingx.*;
import org.jdesktop.swingx.border.*;
import org.pushingpixels.flamingo.api.common.*;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.*;
import static org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority.*;
import org.pushingpixels.flamingo.api.ribbon.resize.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.SubstanceSkin;
import org.pushingpixels.substance.api.skin.SkinInfo;
import org.pushingpixels.substance.flamingo.ribbon.gallery.oob.SkinResizableIcon;

/**
 *
 * @author WIN 8
 */
public class ControllerPrincipal implements IControllerBase, ActionListener {

    private static final Logger log = Logger.getLogger(ControllerPrincipal.class);
    private javax.swing.Timer timer;
    private JLabel horario;
    private SimpleDateFormat formato;
    private Date dataSistema;

    private JTabbedPane tPane;

    // <editor-fold defaultstate="expanded" desc="Private fields Models">
    private final PrincipalDao modelPrincipal;
    private LoginDao modelLogin;
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Private fields Views">
    private final Principal viewPrincipal;
    private Login viewLogin;

    private JXPanelIntro viewPromotions;

    private Employees viewEmployees;
    private Providers viewProviders;
    private Clients viewClients;
    private Services viewServices;
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Private fields Controllers">
    private ControllerLogin controllerLogin;
    private ControllerEmployees controllerEmployee;
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Private fields JCommandButton">
    private JCommandButton promotions;
    private JCommandButton buy;
    private JCommandButton sale;

    private JCommandButton employees;
    private JCommandButton providers;
    private JCommandButton clients;
    private JCommandButton services;
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Constructor">
    /**
     * Constructor
     *
     * @param vista
     * @param modelo
     */
    public ControllerPrincipal(Principal vista, PrincipalDao modelo) {
        this.viewPrincipal = vista;
        this.modelPrincipal = modelo;

        this.setViewValues();
        this.setCommands();
        this.setControllers();
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación IControllerBase">
    /**
     *
     */
    @Override
    public final void setViewValues() {
        this.viewPrincipal.setTitle("Bienvenido a Punto de Venta [ Perla Jarocha ]");
        this.viewPrincipal.setDefaultCloseOperation(JRibbonFrame.EXIT_ON_CLOSE);
        this.viewPrincipal.setExtendedState(JRibbonFrame.MAXIMIZED_BOTH);
        Principal.setDefaultLookAndFeelDecorated(true);
        this.viewPrincipal.setResizable(false);
        this.viewPrincipal.pack();
        this.viewPrincipal.setVisible(false);
        this.viewPrincipal.setIconImage(UtilsImages.getImage(this.viewPrincipal.getClass().getResource(Images.Logo.getRuta())));
        this.viewPrincipal.ribbon = this.viewPrincipal.getRibbon();

        this.setJRibbon(this.viewPrincipal.ribbon);
        this.setCenterPanel();
        this.setCollapsiblePane();
        this.setSouthPanel();
    }

    /**
     *
     */
    @Override
    public final void setCommands() {
        this.promotions.addActionListener(this);
        this.buy.addActionListener(this);
        this.sale.addActionListener(this);

        this.employees.addActionListener(this);
        this.providers.addActionListener(this);
        this.clients.addActionListener(this);
        this.services.addActionListener(this);
    }

    @Override
    public final void setControllers() {
        this.modelLogin = new LoginDao();
        this.viewLogin = new Login(this.viewPrincipal, true);
        this.modelLogin.addObserver(this.viewPrincipal);

//        this.viewPromotions = new JXPanelIntro();
        this.viewEmployees = new Employees();
        this.viewProviders = new Providers();
        this.viewClients = new Clients();
        this.viewServices = new Services();

        this.controllerLogin = new ControllerLogin(this.viewLogin, this.modelLogin);
        this.controllerEmployee = new ControllerEmployees(this.viewEmployees);
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Implementación ActionListener">
    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();
        if (control.equals(this.timer)) {
            Calendar now = Calendar.getInstance();
            this.dataSistema = now.getTime();
            horario.setText(formato.format(dataSistema));
        } else {
            boolean flag = false;
            int index = -1;

            if (control.equals(this.promotions)) {
                // Si ya esta creada la vista
                if (this.viewPromotions != null) {
                    // Si ya se encuentra abierta
                    if (tPane.indexOfTab(this.promotions.getText()) == -1) {
                        tPane.add(this.promotions.getText(), this.viewPromotions);
                        flag = true;
                    }
                    index = tPane.indexOfComponent(this.viewPromotions);
                } else {

                }
            } else if (control.equals(this.employees)) {
                if (this.viewEmployees != null) {
                    if (tPane.indexOfTab(this.employees.getText()) == -1) {
                        tPane.add(this.employees.getText(), this.viewEmployees);
                        flag = true;
                    }
                    index = tPane.indexOfComponent(this.viewEmployees);
                } else {

                }
            } else if (control.equals(this.providers)) {
                if (this.viewProviders != null) {
                    if (tPane.indexOfTab(this.providers.getText()) == -1) {
                        tPane.add(this.providers.getText(), this.viewProviders);
                        flag = true;
                    }
                    index = tPane.indexOfComponent(this.viewProviders);
                } else {

                }
            } else if (control.equals(this.clients)) {
                if (this.viewClients != null) {
                    if (tPane.indexOfTab(this.clients.getText()) == -1) {
                        tPane.add(this.clients.getText(), this.viewClients);
                        flag = true;
                    }
                    index = tPane.indexOfComponent(this.viewClients);
                } else {

                }
            } else if (control.equals(this.services)) {
                if (this.viewServices != null) {
                    if (tPane.indexOfTab(this.services.getText()) == -1) {
                        tPane.add(this.services.getText(), this.viewServices);
                        flag = true;
                    }
                    index = tPane.indexOfComponent(this.viewServices);
                } else {

                }
            }

            this.initTabComponent(flag, index);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Métodos de JRibbonFrame">
    private void setJRibbon(JRibbon ribbon) {
        this.initializeRibbonBand();
        this.initializeFlowRibbonBand();
        this.initializeGalleryBand();
        this.initializeRibbonTask(ribbon);
        this.initializeApplicationMenu(ribbon);
        this.initializeTaskbarComponent(ribbon);
        this.initializeContextualTaskGroup(ribbon, this.viewPrincipal.lookAndFeel);
        this.initializeHelp(ribbon);

        ribbon.setApplicationIcon(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Logo.getRuta()), 98, 98));
    }

    private void initializeRibbonBand() {
        /**
         *
         * @RibbonBand General
         */
        this.viewPrincipal.principal = new JRibbonBand("Principal", null);
        this.viewPrincipal.insert = new JRibbonBand("Registrar", null);

        /**
         *
         * @RibbonBand Data
         */
        this.viewPrincipal.register = new JRibbonBand("Registrar", null);
        this.viewPrincipal.store = new JRibbonBand("Almacen", null);

        /**
         *
         * @RibbonBand Information
         */
        this.viewPrincipal.shopping = new JRibbonBand("Compras", null);
        this.viewPrincipal.sale = new JRibbonBand("Ventas", null);
        this.viewPrincipal.history = new JRibbonBand("Historicos", null);

        this.setButtonsRibbonBand();
        this.setResizePolicies();
    }

    private void initializeFlowRibbonBand() {
        this.viewPrincipal.font = new JFlowRibbonBand("Fuente", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Candado.getRuta()), 48, 48),
                (ActionEvent e) -> {
                    // Expand Button Action
                });

        this.viewPrincipal.font.addFlowComponent(this.setButtonsFlowRibbonBand());
    }

    private void initializeGalleryBand() {
        this.viewPrincipal.themes = new JRibbonBand("Temas", null);

        Map<RibbonElementPriority, Integer> prefWidths = new HashMap<>();
        prefWidths.put(RibbonElementPriority.LOW, 2);
        prefWidths.put(RibbonElementPriority.MEDIUM, 4);
        prefWidths.put(RibbonElementPriority.TOP, 8);

        java.util.List<StringValuePair<java.util.List<JCommandToggleButton>>> skinGroups = new ArrayList<>();
        java.util.List<JCommandToggleButton> skinButtons = new ArrayList<>();

        Map<String, SkinInfo> skins = SubstanceLookAndFeel.getAllSkins();

        skins.entrySet().stream().forEach((entry) -> {
            try {
                final SubstanceSkin skin = (SubstanceSkin) Class.forName(
                        entry.getValue().getClassName()).newInstance();
                ResizableIcon icon = new SkinResizableIcon(skin, 60, 40);
                JCommandToggleButton skinButton = new JCommandToggleButton(skin
                        .getDisplayName(), icon);
                skinButton.addActionListener((ActionEvent e) -> {
                    SwingUtilities.invokeLater(() -> {
                        SubstanceLookAndFeel.setSkin(skin);
                    });
                });
                skinButtons.add(skinButton);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exc) {
            }
        });

        skinGroups.add(new StringValuePair<>("Skins", skinButtons));

        this.viewPrincipal.themes.addRibbonGallery("Skins", skinGroups, prefWidths,
                5, 3, RibbonElementPriority.TOP);
    }

    private void initializeRibbonTask(JRibbon ribbon) {
        this.viewPrincipal.general = new RibbonTask("General", this.viewPrincipal.principal, this.viewPrincipal.insert, this.viewPrincipal.font);
        this.viewPrincipal.data = new RibbonTask("Datos", this.viewPrincipal.register, this.viewPrincipal.store);
        this.viewPrincipal.information = new RibbonTask("Informes", this.viewPrincipal.shopping, this.viewPrincipal.sale, this.viewPrincipal.history);
        this.viewPrincipal.lookAndFeel = new RibbonTask("Apariencia", this.viewPrincipal.themes);

        ribbon.addTask(this.viewPrincipal.general);
        ribbon.addTask(this.viewPrincipal.data);
        ribbon.addTask(this.viewPrincipal.information);
        ribbon.addTask(this.viewPrincipal.lookAndFeel);
    }

    private void initializeApplicationMenu(JRibbon ribbon) {
        RibbonApplicationMenu applicationMenu = new RibbonApplicationMenu();

        RibbonApplicationMenuEntryPrimary venta = new RibbonApplicationMenuEntryPrimary(
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Venta.getRuta()), 48, 48), "Nueva Venta", (ActionEvent e) -> {
                }, JCommandButton.CommandButtonKind.ACTION_ONLY);
        venta.setActionKeyTip("N");
        RibbonApplicationMenuEntryPrimary compra = new RibbonApplicationMenuEntryPrimary(
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Compra.getRuta()), 48, 48), "Nueva Compra", (ActionEvent e) -> {
                }, JCommandButton.CommandButtonKind.ACTION_ONLY);
        compra.setActionKeyTip("C");

        applicationMenu.addMenuEntry(venta);
        applicationMenu.addMenuSeparator();
        applicationMenu.addMenuEntry(compra);

        RibbonApplicationMenuEntryFooter amFooterProps = new RibbonApplicationMenuEntryFooter(
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Help.getRuta()), 18, 18), "Ayuda",
                (ActionEvent e) -> {
                    System.out.println("Invoked Options");
                });
        RibbonApplicationMenuEntryFooter amFooterExit = new RibbonApplicationMenuEntryFooter(
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Salir.getRuta()), 18, 18), "Salir",
                (ActionEvent e) -> {
                    System.exit(0);
                });

        applicationMenu.addFooterEntry(amFooterProps);
        applicationMenu.addFooterEntry(amFooterExit);

        ribbon.setApplicationMenu(applicationMenu);
    }

    private void initializeTaskbarComponent(JRibbon ribbon) {
        JCommandButton button1 = new JCommandButton("Guardar");
        JCommandButton button2 = new JCommandButton("Imprimir");
        JCommandButton button3 = new JCommandButton("Aumentar");
        JCommandButton button4 = new JCommandButton("Disminuir");

        button1.setIcon(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Save.getRuta()), 18, 18));
        button2.setIcon(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Printer.getRuta()), 18, 18));
        button3.setIcon(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.ZoomIn.getRuta()), 18, 18));
        button4.setIcon(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.ZoomOut.getRuta()), 18, 18));

        ribbon.addTaskbarComponent(button1);
        ribbon.addTaskbarComponent(button2);
        ribbon.addTaskbarComponent(button3);
        ribbon.addTaskbarComponent(button4);
    }

    private void initializeContextualTaskGroup(JRibbon ribbon, RibbonTask task) {
        RibbonContextualTaskGroup r = new RibbonContextualTaskGroup("Diseños", new Color(100, 000, 050), task);
        ribbon.addContextualTaskGroup(r);
        ribbon.setVisible(r, true);
    }

    private void initializeHelp(JRibbon ribbon) {
        ribbon.configureHelp(UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Help.getRuta()), 18, 18),
                (ActionEvent e) -> {
                    JOptionPane.showMessageDialog(null, "Ayuda");
                });
    }

    private void setResizePolicies() {
        /**
         *
         * @Task General
         */
        java.util.List<RibbonBandResizePolicy> resizeGeneral = new ArrayList<>();
        resizeGeneral.add(new CoreRibbonResizePolicies.Mirror(this.viewPrincipal.principal.getControlPanel()));
        resizeGeneral.add(new CoreRibbonResizePolicies.Mid2Low(this.viewPrincipal.principal.getControlPanel()));

        this.viewPrincipal.principal.setResizePolicies(resizeGeneral);
        this.viewPrincipal.insert.setResizePolicies((java.util.List) Arrays.asList(new CoreRibbonResizePolicies.None(this.viewPrincipal.insert.getControlPanel()),
                new IconRibbonBandResizePolicy(this.viewPrincipal.insert.getControlPanel())));

        /**
         *
         * @Task Datos
         */
        java.util.List<RibbonBandResizePolicy> resizeData = new ArrayList<>();
        resizeData.add(new CoreRibbonResizePolicies.Mirror(this.viewPrincipal.register.getControlPanel()));
        resizeData.add(new CoreRibbonResizePolicies.Mid2Low(this.viewPrincipal.register.getControlPanel()));

        this.viewPrincipal.register.setResizePolicies(resizeData);
        this.viewPrincipal.store.setResizePolicies(resizeData);

        /**
         *
         * @Task Informes
         */
        java.util.List<RibbonBandResizePolicy> resizeInformation = new ArrayList<>();
        resizeInformation.add(new CoreRibbonResizePolicies.Mirror(this.viewPrincipal.shopping.getControlPanel()));
        resizeInformation.add(new CoreRibbonResizePolicies.Mid2Low(this.viewPrincipal.shopping.getControlPanel()));
        this.viewPrincipal.shopping.setResizePolicies(resizeInformation);
        this.viewPrincipal.sale.setResizePolicies((java.util.List) Arrays.asList(new CoreRibbonResizePolicies.None(this.viewPrincipal.register.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(this.viewPrincipal.register.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(this.viewPrincipal.register.getControlPanel()),
                new CoreRibbonResizePolicies.High2Low(this.viewPrincipal.register.getControlPanel()),
                new IconRibbonBandResizePolicy(this.viewPrincipal.register.getControlPanel())));
        this.viewPrincipal.history.setResizePolicies(resizeInformation);
    }

    private void setButtonsRibbonBand() {
        /**
         *
         * @Task General
         */
        this.promotions = new JCommandButton("Promociones", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Promociones.getRuta()), 48, 48));

        this.viewPrincipal.principal.addCommandButton(this.promotions, TOP);

        this.buy = new JCommandButton("Compra", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Compra.getRuta()), 48, 48));
        this.sale = new JCommandButton("Venta", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Venta.getRuta()), 48, 48));

        this.viewPrincipal.insert.addCommandButton(this.buy, TOP);
        this.viewPrincipal.insert.addCommandButton(this.sale, TOP);

        /**
         *
         * @Task Datos
         */
        this.employees = new JCommandButton("Empleados", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Empleados.getRuta()), 48, 48));
        this.providers = new JCommandButton("Proveedores", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Proveedores.getRuta()), 48, 48));
        this.clients = new JCommandButton("Clientes", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Clientes.getRuta()), 48, 48));
        this.services = new JCommandButton("Servicios", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Servicios.getRuta()), 48, 48));

        this.viewPrincipal.register.addCommandButton(this.employees, TOP);
        this.viewPrincipal.register.addCommandButton(this.providers, MEDIUM);
        this.viewPrincipal.register.addCommandButton(this.clients, MEDIUM);
        this.viewPrincipal.register.addCommandButton(this.services, LOW);

        JCommandButton button5 = new JCommandButton("Bebidas", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Bebidas.getRuta()), 48, 48));
        JCommandButton button6 = new JCommandButton("Alimentos", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Alimentos.getRuta()), 48, 48));
        JCommandButton button7 = new JCommandButton("Otros", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Otros.getRuta()), 48, 48));

        this.viewPrincipal.store.addCommandButton(button5, TOP);
        this.viewPrincipal.store.addCommandButton(button6, TOP);
        this.viewPrincipal.store.addCommandButton(button7, TOP);

        /**
         *
         * @Task Informes
         */
        JCommandButton button8 = new JCommandButton("Compras realizadas", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.ComprasR.getRuta()), 48, 48));
        JCommandButton button9 = new JCommandButton("Compras anuladas", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.ComprasC.getRuta()), 48, 48));

        this.viewPrincipal.shopping.addCommandButton(button8, TOP);
        this.viewPrincipal.shopping.addCommandButton(button9, TOP);

        JCommandButton button10 = new JCommandButton("Ventas realizadas", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.VentasR.getRuta()), 48, 48));
        JCommandButton button11 = new JCommandButton("Ventas anuladas", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.VentasC.getRuta()), 48, 48));
        JCommandButton button12 = new JCommandButton("Ventas por empleado", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.VentasE.getRuta()), 48, 48));

        this.viewPrincipal.sale.addCommandButton(button10, TOP);
        this.viewPrincipal.sale.addCommandButton(button11, TOP);
        this.viewPrincipal.sale.addCommandButton(button12, TOP);

        JCommandButton button13 = new JCommandButton("Stock de articulos", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.Stock.getRuta()), 48, 48));
        JCommandButton button14 = new JCommandButton("Cierre de caja", UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Images.CierreCaja.getRuta()), 48, 48));

        this.viewPrincipal.history.addCommandButton(button13, TOP);
        this.viewPrincipal.history.addCommandButton(button14, TOP);
    }

    private JCommandButtonStrip setButtonsFlowRibbonBand() {
        JCommandButtonStrip styleStrip = new JCommandButtonStrip();

        final JCommandToggleButton boldButton = new JCommandToggleButton("",
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Bold.getRuta()), 18, 18));
        final JCommandToggleButton italicButton = new JCommandToggleButton("",
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Italic.getRuta()), 18, 18));
        final JCommandToggleButton underlineButton = new JCommandToggleButton("",
                UtilsImages.getResizableIcon(this.viewPrincipal.getClass().getResource(Icons.Underline.getRuta()), 18, 18));

        boldButton.addActionListener((ActionEvent e) -> {
            if (boldButton.getActionModel().isSelected()) {
                System.out.println("Apply BOLD Style");
            } else {
                System.out.println("Clear BOLD Style");
            }
        });

        styleStrip.add(boldButton);
        styleStrip.add(italicButton);
        styleStrip.add(underlineButton);

        return styleStrip;
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Métodos de Panel Central">
    private void setCenterPanel() {
        this.tPane = new JTabbedPane();
        this.viewPromotions = new JXPanelIntro();

        tPane.add(this.promotions.getText(), this.viewPromotions);
        this.initTabComponent(true, tPane.indexOfComponent(this.viewPromotions));
        this.viewPrincipal.add(this.tPane, BorderLayout.CENTER);
    }

    private void initTabComponent(boolean createTab, int index) {
        if (createTab) {
            tPane.setTabComponentAt(tPane.getTabCount() - 1, new JPanelTabComponent(tPane));
        }
        if (index >= 0) {
            tPane.setSelectedIndex(index);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Métodos de Panel Oeste (SwingX)">
    private void setCollapsiblePane() {
        JXCollapsiblePane collapsiblePane = new JXCollapsiblePane(JXCollapsiblePane.Direction.LEFT);
        collapsiblePane.setLayout(new BorderLayout());
        collapsiblePane.add(this.setTaskPaneContainer(), BorderLayout.CENTER);

        JButton button = new JButton("");
        button.setPreferredSize(new Dimension(10, 200));
        button.addActionListener(collapsiblePane.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
        panel.add(collapsiblePane, BorderLayout.WEST);

        this.viewPrincipal.add(panel, BorderLayout.WEST);
    }

    private JScrollPane setTaskPaneContainer() {
        JXPanel panel = new JXPanel();
        panel.setLayout(new BorderLayout());

        JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();
        taskpanecontainer.setBorder(new DropShadowBorder());

        this.setTaskPane(taskpanecontainer);

        panel.add(taskpanecontainer, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(250, 200));

        return new JScrollPane(panel);
    }

    private void setTaskPane(JXTaskPaneContainer taskpanecontainer) {
        /**
         *
         * @JXTaskPane Administration
         */
        JXTaskPane administration = new JXTaskPane();
        administration.setTitle("Administración");

        final JXLabel inventory = new JXLabel();
        inventory.setFont(new Font("Arial", Font.PLAIN, 12));
        inventory.setText("Inventario");
        inventory.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.Inventario.getRuta()), 32, 32));
        inventory.setHorizontalAlignment(JXLabel.LEFT);

        final JXLabel maintenance = new JXLabel();
        maintenance.setFont(new Font("Arial", Font.PLAIN, 12));
        maintenance.setText("Mantenimiento");
        maintenance.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.Mantenimiento.getRuta()), 32, 32));
        maintenance.setHorizontalAlignment(JXLabel.LEFT);

        administration.add(inventory);
        administration.add(maintenance);

//        taskpane.add(new AbstractAction() {
//            {
//                putValue(Action.NAME, "task pane item 2 : an action");
//                putValue(Action.SHORT_DESCRIPTION, "perform an action");
//                putValue(Action.SMALL_ICON, UtilsImages.getIcon(Principal.class
//                        .getClass().getResource(Images.Usuario.getRuta()), 32, 32));
//            }
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label.setText("an action performed");
//            }
//        });
        /**
         *
         * @JXTaskPane Utility
         */
        JXTaskPane utility = new JXTaskPane();
        utility.setTitle("Utilidades");

        final JXLabel exportPDF = new JXLabel();
        exportPDF.setFont(new Font("Arial", Font.PLAIN, 12));
        exportPDF.setText("Exportar a PDF");
        exportPDF.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.ExportarPDF.getRuta()), 32, 32));
        exportPDF.setHorizontalAlignment(JXLabel.LEFT);

        final JXLabel exportExcel = new JXLabel();
        exportExcel.setFont(new Font("Arial", Font.PLAIN, 12));
        exportExcel.setText("Exportar a Excel");
        exportExcel.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.ExportarExcel.getRuta()), 32, 32));
        exportExcel.setHorizontalAlignment(JXLabel.LEFT);

        utility.add(exportPDF);
        utility.add(exportExcel);

        /**
         *
         * @JXTaskPane System
         */
        JXTaskPane system = new JXTaskPane();
        system.setTitle("Sistema");

        final JXLabel changePassword = new JXLabel();
        changePassword.setFont(new Font("Arial", Font.PLAIN, 12));
        changePassword.setText("Cambiar clave");
        changePassword.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.CambiarClave.getRuta()), 32, 32));
        changePassword.setHorizontalAlignment(JXLabel.LEFT);

        final JXLabel printer = new JXLabel();
        printer.setFont(new Font("Arial", Font.PLAIN, 12));
        printer.setText("Impresora");
        printer.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.Impresora.getRuta()), 32, 32));
        printer.setHorizontalAlignment(JXLabel.LEFT);

        final JXLabel changeUser = new JXLabel();
        changeUser.setFont(new Font("Arial", Font.PLAIN, 12));
        changeUser.setText("Finalizar sesión");
        changeUser.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.CambiarSesion.getRuta()), 32, 32));
        changeUser.setHorizontalAlignment(JXLabel.LEFT);

        final JXLabel exit = new JXLabel();
        exit.setFont(new Font("Arial", Font.PLAIN, 12));
        exit.setText("Salir");
        exit.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.Salir.getRuta()), 32, 32));
        exit.setHorizontalAlignment(JXLabel.LEFT);

        system.add(changePassword);
        system.add(printer);
        system.add(changeUser);
        system.add(exit);

        // add the task pane to the taskpanecontainer
        taskpanecontainer.add(administration);
        taskpanecontainer.add(utility);
        taskpanecontainer.add(system);
    }
    // </editor-fold>

    // <editor-fold defaultstate="expanded" desc="Métodos de Panel Sur">
    private void setSouthPanel() {
        JPanelRound panelMain = new JPanelRound();
        panelMain.setLayout(new GridLayout(1, 3));
        panelMain.setBorder(new EmptyBorder(3, 8, 3, 8));

        //CENTER
        this.horario = new JLabel();
        this.horario.setHorizontalTextPosition(JLabel.CENTER);
        this.horario.setHorizontalAlignment(JLabel.RIGHT);

        this.formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataSistema = new Date();

        this.timer = new javax.swing.Timer(1000, this);
        this.timer.start();

        //WEST
        JLabel connection = new JLabel();
        connection.setText(DataAccess.getInstance().getUrlConnection());
        connection.setIcon(UtilsImages.getIcon(Principal.class.getClass().getResource(Images.BasedeDatos.getRuta()), 32, 32));

        //EAST
        JPanel panelEAST = new JPanel();
        panelEAST.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        panelEAST.setOpaque(false);
//        panelEAST.setBackground(new Color(0, 0, 0, 55));

        this.viewPrincipal.imagen = new JLabel();

        JLabel user = new JLabel();
        user.setText("Administrador");

        panelEAST.add(user);
        panelEAST.add(this.viewPrincipal.imagen);

        panelMain.add(connection);
        panelMain.add(this.horario);
        panelMain.add(panelEAST);

        this.viewPrincipal.add(panelMain, BorderLayout.SOUTH);
    }
    // </editor-fold>
}
