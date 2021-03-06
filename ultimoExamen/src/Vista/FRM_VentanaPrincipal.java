/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaPrincipal;

/**
 *
 * @author altna
 */
public class FRM_VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form F
     */
    Controlador_FRM_VentanaPrincipal controlador;
     int numeroCita=1;
    public FRM_VentanaPrincipal() {
        initComponents();
        controlador=new Controlador_FRM_VentanaPrincipal(this);
        agregarEventos();
        this.jt_NumeroCita.setEnabled(false);
    }

    public void agregarEventos()
    {
        this.btn_Eliminar.addActionListener(controlador);
        this.btn_MayorMenor.addActionListener(controlador);
        this.btn_MenorMayor.addActionListener(controlador);
        this.btn_Modificar.addActionListener(controlador);
        this.btn_Registrar.addActionListener(controlador);
        this.btn_Llamar.addActionListener(controlador);
        this.btn_mostrarTodos.addActionListener(controlador);
    }
    
    //String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo
    public String[] devolverInfo()
    {
        String[] info=new String[6];
        info[0]=this.jt_NombreCompleto.getText();
        info[1]=this.jt_Edad.getText();
        info[2]=this.jt_Cedula.getText();
        info[3]=this.jt_NumeroCita.getText();
        info[4]=this.jt_FechaCita.getText();
        info[5]=""+this.jcb_Tipo.getSelectedItem();
        
        return info;
    }
    
    public int generarNumeroFicha(boolean registrarse)
    {
        if(registrarse)
        {
          numeroCita++;  
        }
        else
        {
          numeroCita=numeroCita;  
        }
        this.jt_NumeroCita.setText(""+numeroCita);
        return numeroCita;
    }
    
    public void imprimir(String imprimir)
    {
        this.jta_Cola.setText(imprimir);
    }
    
    public void limpiarCampos()
    {
        this.jt_Cedula.setText("");
        this.jt_Edad.setText("");
        this.jt_FechaCita.setText("");
        this.jt_NombreCompleto.setText("");
    }
    
    public void bloquearCedula()
    {
        this.jt_Cedula.setEnabled(false);
    }
    
    public void setCedula(int cedula)
    {
        this.jt_Cedula.setText(""+cedula);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jl_Edad = new javax.swing.JLabel();
        jl_Fecha = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_Edad = new javax.swing.JTextField();
        jt_FechaCita = new javax.swing.JTextField();
        jl_NumeroCita = new javax.swing.JLabel();
        jt_NumeroCita = new javax.swing.JTextField();
        btn_Registrar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jl_Atiende = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Cola = new javax.swing.JTextArea();
        jl_PromedioEdad = new javax.swing.JLabel();
        jt_PromedioEdad = new javax.swing.JTextField();
        jl_CantidadPersonas = new javax.swing.JLabel();
        jt_CantidadPersonas = new javax.swing.JTextField();
        btn_MayorMenor = new javax.swing.JButton();
        btn_MenorMayor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcb_Tipo = new javax.swing.JComboBox();
        btn_Llamar = new javax.swing.JButton();
        btn_mostrarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_Cedula.setText("Cedula:");

        jl_NombreCompleto.setText("Nombre Completo:");

        jl_Edad.setText("Edad:");

        jl_Fecha.setText("Fecha de cita:");

        jl_NumeroCita.setText("Numero de cita");
        jl_NumeroCita.setToolTipText("");

        jt_NumeroCita.setText("1");
        jt_NumeroCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_NumeroCitaActionPerformed(evt);
            }
        });

        btn_Registrar.setText("Registrar");

        btn_Eliminar.setText("Eliminar");

        btn_Modificar.setText("Modificar");

        jl_Atiende.setText("Atendiendo a:");

        jta_Cola.setColumns(20);
        jta_Cola.setRows(5);
        jScrollPane1.setViewportView(jta_Cola);

        jl_PromedioEdad.setText("Promedio de edad:");

        jl_CantidadPersonas.setText("Cantidad de Personas");

        btn_MayorMenor.setText(">");

        btn_MenorMayor.setText("<");

        jLabel1.setText("Tipo:");

        jcb_Tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "7600" }));

        btn_Llamar.setText("Llamar");

        btn_mostrarTodos.setText("mostrar todos");
        btn_mostrarTodos.setActionCommand("mostrarTodos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Cedula)
                            .addComponent(jl_NombreCompleto)
                            .addComponent(jl_Edad)
                            .addComponent(jl_Fecha)
                            .addComponent(jl_NumeroCita))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_Cedula)
                            .addComponent(jt_NombreCompleto)
                            .addComponent(jt_Edad)
                            .addComponent(jt_FechaCita)
                            .addComponent(jt_NumeroCita, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_PromedioEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jt_PromedioEdad))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_mostrarTodos)
                                    .addComponent(btn_Llamar)
                                    .addComponent(jl_Atiende))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_CantidadPersonas)
                                .addGap(18, 18, 18)
                                .addComponent(jt_CantidadPersonas))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Registrar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Modificar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(118, 118, 118)
                        .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_MayorMenor)
                        .addGap(18, 18, 18)
                        .addComponent(btn_MenorMayor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_NumeroCita)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jt_NumeroCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jl_Atiende)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Cedula)
                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Llamar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreCompleto)
                            .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_mostrarTodos))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Edad)
                            .addComponent(jt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_PromedioEdad)
                            .addComponent(jt_PromedioEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Fecha)
                            .addComponent(jt_FechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_CantidadPersonas)
                            .addComponent(jt_CantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_MayorMenor)
                        .addComponent(btn_MenorMayor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_Modificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_NumeroCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_NumeroCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_NumeroCitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Llamar;
    private javax.swing.JButton btn_MayorMenor;
    private javax.swing.JButton btn_MenorMayor;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JButton btn_mostrarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcb_Tipo;
    private javax.swing.JLabel jl_Atiende;
    private javax.swing.JLabel jl_CantidadPersonas;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Edad;
    private javax.swing.JLabel jl_Fecha;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_NumeroCita;
    private javax.swing.JLabel jl_PromedioEdad;
    private javax.swing.JTextField jt_CantidadPersonas;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Edad;
    private javax.swing.JTextField jt_FechaCita;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_NumeroCita;
    private javax.swing.JTextField jt_PromedioEdad;
    private javax.swing.JTextArea jta_Cola;
    // End of variables declaration//GEN-END:variables
}
