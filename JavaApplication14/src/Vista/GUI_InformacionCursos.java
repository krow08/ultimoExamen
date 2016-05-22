/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author tecnologiamultimedia
 */
public class GUI_InformacionCursos extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionCursos
     */
    public GUI_InformacionCursos() {
        initComponents();
        cargarCreditos();
    }
    public void cargarCreditos()
    {
        this.jcb_Creditos.removeAllItems();
        for(int contador=0;contador<10;contador++)
        {
            this.jcb_Creditos.addItem(""+contador);
        }
        this.jcb_Creditos.setSelectedIndex(4);
    }
    public String[] devolverInformacion()
    {
        String arreglo[];
        arreglo=new String[4];
        arreglo[0]=this.jt_Sigla.getText();
        arreglo[1]=this.jt_Nombre.getText();
        arreglo[2]=""+this.jcb_Creditos.getSelectedIndex();
        arreglo[3]=this.jt_Horario.getText();
        
        return arreglo;
    
    }
  
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public void limpiarInterfaz()
    {
        this.jt_Horario.setText("");
        this.jt_Nombre.setText("");
        this.jt_Sigla.setText("");
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[0]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jt_Horario.setText(arreglo[2]);
    }
    public void habilitarOpciones()
    {
        this.jt_Horario.setEnabled(true);
        this.jt_Nombre.setEnabled(true);
        //this.btn_ConsultaRapida.setEnabled(false);
    }
    public void deshabilitarSigla()
    {
        this.jt_Sigla.setEnabled(false);
    }
     public void pantallaInicial()
    {
     this.jt_Nombre.setEnabled(false);
     this.jcb_Creditos.setEnabled(false);   
     this.jt_Horario.setEnabled(false);
    }
       public void limpiarCampos()
    {
        this.jt_Sigla.setText("");
        this.jt_Nombre.setText("");
        this.jt_Horario.setText("");
    }
    public void habilitarEspacios()
    {
      this.jt_Nombre.setEnabled(true);
      this.jcb_Creditos.setEnabled(true);
      this.jt_Horario.setEnabled(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Sigla = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jl_Creditos = new javax.swing.JLabel();
        jl_Horario = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_Nombre = new javax.swing.JTextField();
        jt_Horario = new javax.swing.JTextField();
        jcb_Creditos = new javax.swing.JComboBox<>();

        jl_Sigla.setText("Sigla");

        jl_Nombre.setText("Nombre");

        jl_Creditos.setText("Créditos");

        jl_Horario.setText("Horario");

        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Sigla)
                    .addComponent(jl_Nombre)
                    .addComponent(jl_Creditos)
                    .addComponent(jl_Horario))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jt_Sigla, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jt_Nombre)
                        .addComponent(jt_Horario))
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Sigla)
                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Nombre)
                    .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Creditos)
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Horario)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
