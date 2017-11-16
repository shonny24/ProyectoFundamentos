/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author admin
 */
public class VentanaAgregarPista extends javax.swing.JFrame {
    private OpenDeAustralia miOpenAustralia;
    private Pista miPista;
    private VentanaPrincipal miVentanaPrincipal;
    /**
     * Creates new form VentanaAgragarPista
     * @param open OpenDeAustralia
     */
    public VentanaAgregarPista(OpenDeAustralia open) {
        miOpenAustralia = open;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/interfaz/images/Australian_Open_Logo.png")).getImage());
        //************************
        //Centrar Jframe
        setLocationRelativeTo(null);
        //************************
        llenarTablaPista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTIdPista = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTNombrePista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTCapacidadPista = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePista = new javax.swing.JTable();
        jBBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Pista");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Pista"));

        jLabel1.setText("Id:");

        jTIdPista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTIdPistaKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre");

        jTNombrePista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombrePistaKeyTyped(evt);
            }
        });

        jLabel3.setText("Capacidad");

        jTCapacidadPista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCapacidadPistaKeyTyped(evt);
            }
        });

        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/agregar16.png"))); // NOI18N
        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTIdPista)
                            .addComponent(jTNombrePista)
                            .addComponent(jTCapacidadPista))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTIdPista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNombrePista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTCapacidadPista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAgregar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pistas"));

        jTablePista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Capacidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTablePista);
        if (jTablePista.getColumnModel().getColumnCount() > 0) {
            jTablePista.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTablePista.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTablePista.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jBBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/borrar16.png"))); // NOI18N
        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBorrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        
        if (ValidarDatosAgregarPista().equals("")) {
        String idPista = jTIdPista.getText();
        String nombrePista = jTNombrePista.getText();
        int capacidadMaxima = Integer.parseInt(jTCapacidadPista.getText());
        miPista = new Pista(idPista, nombrePista, capacidadMaxima);
        boolean agregarPista = miOpenAustralia.agregarPista(miPista);
        
          if (agregarPista) {
                imprimir("La pista se agrego");
                
            } else {
                imprimir("No se puede agregar la pista");
            }
         //llamamos el metodo de la tabla para llenarla
            llenarTablaPista();
          
          jTIdPista.setText(null);
          jTNombrePista.setText(null);
          jTCapacidadPista.setText(null);
    }//GEN-LAST:event_jBAgregarActionPerformed
        else{
            JOptionPane.showMessageDialog(rootPane, "ERROR!!! \n" + ValidarDatosAgregarPista(), "Validando Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        int filSelec;
        int resp;
        String id;
        boolean eliminado;
        try {
            //selecciono una fila
            filSelec = jTablePista.getSelectedRow();
            //verifico si estoy seleccionando una fila
            if (filSelec == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un item de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta pista?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    //obtengo el los datos de la columna 0
                    id = jTablePista.getValueAt(filSelec, 0).toString();
                    //llamo el metodo eliminar
                    eliminado = miOpenAustralia.eliminarPista(id);
                    
                    DefaultTableModel dtm = (DefaultTableModel) jTablePista.getModel();
                    dtm.removeRow(filSelec);

                    if (eliminado == true) {
                        imprimir("La pista se elimino correctamente");
                    } else {
                        imprimir("Error!!! no se elimino");
                    }

                }
            }
        } catch (Exception e) {
        }
     
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jTIdPistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIdPistaKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTIdPista, evt);
    }//GEN-LAST:event_jTIdPistaKeyTyped

    private void jTNombrePistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombrePistaKeyTyped
        // TODO add your handling code here:
        validarLetras(jTNombrePista, evt);
    }//GEN-LAST:event_jTNombrePistaKeyTyped

    private void jTCapacidadPistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCapacidadPistaKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTCapacidadPista, evt);      
    }//GEN-LAST:event_jTCapacidadPistaKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaAgregarPista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarPista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarPista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarPista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarPista(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCapacidadPista;
    private javax.swing.JTextField jTIdPista;
    private javax.swing.JTextField jTNombrePista;
    private javax.swing.JTable jTablePista;
    // End of variables declaration//GEN-END:variables

    private void imprimir(String msj) {
        JOptionPane.showMessageDialog(null, msj);
    }

    /**
     * metodo para llenar la tabla de Pistas
     */
    public void llenarTablaPista() {
        DefaultTableModel dtm = (DefaultTableModel) jTablePista.getModel();//se usa DefaultTableModel para manipular facilmente el Tablemodel
        dtm.setRowCount(0);//eliminando la s filas que ya hay. para agregar desde el principio.
        //los datos se agregan la defaultTableModel.
        Pista[] pistas = miOpenAustralia.getPistas();//sacando al informacion a agregar en la tabla.

        //como se va a llenar una tabla de 5 columnas, se crea un vector de 3 elementos.
        //se usa un arreglo de Object para poder agregar a la tabla cualquier tipo de datos.
        Object[] datos = new Object[3];
        
        for (int i = 0; i < pistas.length; i++) {

           Pista pist = pistas[i];
            //Se agrega este if para evitar que el extraiga datos en un campo null
            if (pist != null) {

                datos[0] = pist.getIdPista();//el primer elemetno del arreglo va a ser el id,la primera col en la Tabla.
                datos[1] = pist.getNombre();
                datos[2] = pist.getCapacidadMax();
               

                //agrego al TableModleo ese arreglo
                dtm.addRow(datos);
            }
        }
        //metodo que modifica las celdas de la tabla
        dtm.addTableModelListener(new TableModelListener() {
            //metodo que verifica si existe un cambio en la tabla
            @Override
            public void tableChanged(TableModelEvent e) {
                //if que verifica si existe cambio
                if (e.getType() == TableModelEvent.UPDATE) {
                    //se obtiene la columna en la cual se modifico la celda
                    int columna = e.getColumn();
                    //se obtiene la fila en la cual se modifico la celda
                    int fila = e.getFirstRow();
                    //se obtiene el id del jugador de la fila seleccionada 
                    String id = jTablePista.getValueAt(fila, 0).toString();
                    //se obtiene el elemento modificado
                    String dato = jTablePista.getValueAt(fila, columna).toString();

                    miOpenAustralia.modificarPista(id, dato, columna);
                }
            }
        });
        //**************************************************
    }

    /**
     * metodo que sirve para validar letras  y este es llamado cuando existe un evento de teclado
     * @param campo campo al cual se aplica la validacion
     * @param evt evento de teclado
     */
    public void validarNumeros(JTextField campo, KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                    JOptionPane.INFORMATION_MESSAGE);
            campo.setCursor(null);
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar simbolos!!!", "Validando Datos",
                    JOptionPane.INFORMATION_MESSAGE);
            campo.setCursor(null);
        }
    }

    /**
     * metodo que sirve para validar letras  y este es llamado cuando existe un evento de teclado
     * @param campo campo al cual se aplica la validacion
     * @param evt evento de teclado
     */
    public void validarLetras(JTextField campo, KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar numeros!!!", "Validando Datos",
                    JOptionPane.INFORMATION_MESSAGE);
            campo.setCursor(null);
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar simbolos!!!", "Validando Datos",
                    JOptionPane.INFORMATION_MESSAGE);
            campo.setCursor(null);
        }
    }
    
    /**
     * metodo que sirve para validar que los campos no esten vacios
     * @return un mensaje de error dependiendo si el campo esta vacio
     */
    public String ValidarDatosAgregarPista() {//Metodo para comprobar que los datos esten completos
        String msj = "";
        if (jTIdPista.getText().equals("")) {//Si jTIdPista esta vacio
            msj += "Por favor digite el Id de la pista. \n";
        }
        if (jTNombrePista.getText().equals("")) {//Si jTNombrePista esta vacio
            msj += "Por favor digite el Nombre de la pista. \n";
        }
        if (jTCapacidadPista.getText().equals("")) {//Si jTCapacidadPista esta vacio
            msj += "Por favor digite la Capacidad de la pista. \n";
        }
        return msj;//devuelve msj
    }
}
