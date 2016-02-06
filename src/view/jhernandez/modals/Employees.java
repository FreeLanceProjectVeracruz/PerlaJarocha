package view.jhernandez.modals;

/**
 *
 * @author WIN 8
 */
public class Employees extends javax.swing.JPanel {

    /**
     * Creates new form Employees
     */
    public Employees() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTBContenedorBontones = new javax.swing.JToolBar();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jPanelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTClaveEmp = new javax.swing.JTable();
        jPDatosEmpleado = new javax.swing.JPanel();
        jPFoto = new javax.swing.JPanel();
        Photo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Izquierda = new javax.swing.JPanel();
        jLClave = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jLCelular = new javax.swing.JLabel();
        jLCorreoE = new javax.swing.JLabel();
        jLPuesto = new javax.swing.JLabel();
        jLFechaIng = new javax.swing.JLabel();
        Derecha = new javax.swing.JPanel();
        jTFClave = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFDomicilio = new javax.swing.JTextField();
        jTFCelular = new javax.swing.JTextField();
        jTFCorreoE = new javax.swing.JTextField();
        jCBPuesto = new javax.swing.JComboBox();
        jXDPCalendario = new org.jdesktop.swingx.JXDatePicker();

        setLayout(new java.awt.BorderLayout());

        jTBContenedorBontones.setFloatable(false);
        jTBContenedorBontones.setRollover(true);

        jBAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jBAgregar.setText("Agregar");
        jBAgregar.setFocusable(false);
        jBAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBContenedorBontones.add(jBAgregar);

        jBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminar.setText("Eliminar");
        jBEliminar.setFocusable(false);
        jBEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBContenedorBontones.add(jBEliminar);

        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar");
        jBBuscar.setFocusable(false);
        jBBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBContenedorBontones.add(jBBuscar);

        jBModificar.setForeground(new java.awt.Color(255, 255, 255));
        jBModificar.setText("Modificar");
        jBModificar.setFocusable(false);
        jBModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBContenedorBontones.add(jBModificar);

        add(jTBContenedorBontones, java.awt.BorderLayout.PAGE_START);

        jPanelCenter.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 400));

        jTClaveEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTClaveEmp.setColumnSelectionAllowed(true);
        jTClaveEmp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTClaveEmp.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTClaveEmp);
        jTClaveEmp.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTClaveEmp.getColumnModel().getColumnCount() > 0) {
            jTClaveEmp.getColumnModel().getColumn(0).setResizable(false);
            jTClaveEmp.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanelCenter.add(jScrollPane1, java.awt.BorderLayout.WEST);

        jPDatosEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Datos del empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 3, 14))); // NOI18N
        jPDatosEmpleado.setLayout(new java.awt.BorderLayout());

        jPFoto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        Photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Photo.setPreferredSize(new java.awt.Dimension(100, 100));
        jPFoto.add(Photo);

        jPDatosEmpleado.add(jPFoto, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.BorderLayout());

        Izquierda.setLayout(new org.jdesktop.swingx.VerticalLayout());

        jLClave.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLClave.setText("Clave:");
        jLClave.setMinimumSize(new java.awt.Dimension(15, 15));
        jLClave.setPreferredSize(new java.awt.Dimension(100, 40));
        Izquierda.add(jLClave);

        jLNombre.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLNombre.setText("Nombre:");
        jLNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        jLNombre.setPreferredSize(new java.awt.Dimension(100, 40));
        Izquierda.add(jLNombre);

        jLDomicilio.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLDomicilio.setText("Domicilio:");
        jLDomicilio.setMinimumSize(new java.awt.Dimension(100, 40));
        jLDomicilio.setPreferredSize(new java.awt.Dimension(100, 40));
        Izquierda.add(jLDomicilio);

        jLCelular.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLCelular.setText("Celular:");
        jLCelular.setMinimumSize(new java.awt.Dimension(100, 40));
        jLCelular.setPreferredSize(new java.awt.Dimension(100, 40));
        Izquierda.add(jLCelular);

        jLCorreoE.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLCorreoE.setText("EMail:");
        jLCorreoE.setMinimumSize(new java.awt.Dimension(100, 40));
        jLCorreoE.setPreferredSize(new java.awt.Dimension(110, 40));
        Izquierda.add(jLCorreoE);

        jLPuesto.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLPuesto.setText("Puesto:");
        jLPuesto.setMinimumSize(new java.awt.Dimension(100, 40));
        jLPuesto.setPreferredSize(new java.awt.Dimension(100, 40));
        Izquierda.add(jLPuesto);

        jLFechaIng.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jLFechaIng.setText("Fecha de Ingreso:");
        jLFechaIng.setMinimumSize(new java.awt.Dimension(100, 40));
        jLFechaIng.setPreferredSize(new java.awt.Dimension(100, 40));
        jLFechaIng.setRequestFocusEnabled(false);
        Izquierda.add(jLFechaIng);

        jPanel3.add(Izquierda, java.awt.BorderLayout.WEST);

        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(5);
        Derecha.setLayout(verticalLayout1);

        jTFClave.setPreferredSize(new java.awt.Dimension(100, 35));
        Derecha.add(jTFClave);

        jTFNombre.setPreferredSize(new java.awt.Dimension(100, 35));
        jTFNombre.setRequestFocusEnabled(false);
        Derecha.add(jTFNombre);

        jTFDomicilio.setToolTipText("");
        jTFDomicilio.setPreferredSize(new java.awt.Dimension(100, 35));
        jTFDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDomicilioActionPerformed(evt);
            }
        });
        Derecha.add(jTFDomicilio);

        jTFCelular.setPreferredSize(new java.awt.Dimension(100, 35));
        Derecha.add(jTFCelular);

        jTFCorreoE.setPreferredSize(new java.awt.Dimension(100, 35));
        jTFCorreoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCorreoEActionPerformed(evt);
            }
        });
        Derecha.add(jTFCorreoE);

        jCBPuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBPuesto.setPreferredSize(new java.awt.Dimension(100, 35));
        Derecha.add(jCBPuesto);

        jXDPCalendario.setPreferredSize(new java.awt.Dimension(100, 35));
        Derecha.add(jXDPCalendario);

        jPanel3.add(Derecha, java.awt.BorderLayout.CENTER);

        jPDatosEmpleado.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanelCenter.add(jPDatosEmpleado, java.awt.BorderLayout.CENTER);

        add(jPanelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDomicilioActionPerformed

    private void jTFCorreoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCorreoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCorreoEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Derecha;
    private javax.swing.JPanel Izquierda;
    public javax.swing.JLabel Photo;
    public javax.swing.JButton jBAgregar;
    public javax.swing.JButton jBBuscar;
    public javax.swing.JButton jBEliminar;
    public javax.swing.JButton jBModificar;
    private javax.swing.JComboBox jCBPuesto;
    private javax.swing.JLabel jLCelular;
    private javax.swing.JLabel jLClave;
    private javax.swing.JLabel jLCorreoE;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLFechaIng;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLPuesto;
    private javax.swing.JPanel jPDatosEmpleado;
    private javax.swing.JPanel jPFoto;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jTBContenedorBontones;
    private javax.swing.JTable jTClaveEmp;
    private javax.swing.JTextField jTFCelular;
    private javax.swing.JTextField jTFClave;
    private javax.swing.JTextField jTFCorreoE;
    private javax.swing.JTextField jTFDomicilio;
    private javax.swing.JTextField jTFNombre;
    private org.jdesktop.swingx.JXDatePicker jXDPCalendario;
    // End of variables declaration//GEN-END:variables
}
