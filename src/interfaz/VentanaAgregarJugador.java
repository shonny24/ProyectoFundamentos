/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Shonny
 */
public class VentanaAgregarJugador extends javax.swing.JFrame {

    private OpenDeAustralia miOpenAustralia;
    private Jugador miJugador;

    /**
     * Creates new form VentanaAgregarJugador
     */
    public VentanaAgregarJugador(OpenDeAustralia open) {
        miOpenAustralia = open;
        initComponents();

        //************************
        //Centrar Jframe
        setLocationRelativeTo(null);
        //************************
        llenarTablaJugador();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTidJugador = new javax.swing.JTextField();
        jTnombreJugador = new javax.swing.JTextField();
        jTrankingJugador = new javax.swing.JTextField();
        jTedadJugador = new javax.swing.JTextField();
        jBagregarJugador = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTpuntosATP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Jugador");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Jugador"));

        jLabel1.setText("Id:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Ranking ATP:");

        jLabel4.setText("Edad:");

        jTidJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTidJugadorKeyTyped(evt);
            }
        });

        jTnombreJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTnombreJugadorKeyTyped(evt);
            }
        });

        jTrankingJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTrankingJugadorKeyTyped(evt);
            }
        });

        jTedadJugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTedadJugadorKeyTyped(evt);
            }
        });

        jBagregarJugador.setText("Agregar");
        jBagregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregarJugadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Puntos ATP:");

        jTpuntosATP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTpuntosATPKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBagregarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTnombreJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jTidJugador)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTedadJugador)
                            .addComponent(jTpuntosATP)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTrankingJugador)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTidJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTnombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTedadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTpuntosATP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTrankingJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jBagregarJugador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Jugadores"));

        jTableJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Edad", "Puntos ATP", "Ranking ATP"
            }
        ));
        jScrollPane1.setViewportView(jTableJugadores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jBagregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregarJugadorActionPerformed
        // TODO add your handling code here:
        if (ValidarDatosAgregarJugador().equals("")) {
            String idJuga = jTidJugador.getText();
            String nombre = jTnombreJugador.getText();
            int edad = Integer.parseInt(jTedadJugador.getText());
            int puntosATP = Integer.parseInt(jTpuntosATP.getText());
            int rankinAtp = Integer.parseInt(jTrankingJugador.getText());
            miJugador = new Jugador(idJuga, nombre, edad, rankinAtp, puntosATP);
            boolean agregarJuga = miOpenAustralia.agregarJugador(miJugador);

            if (agregarJuga) {
                imprimir("El Jugador se agrego");
            } else {
                imprimir("No se puede agregar el jugador");
            }
            llenarTablaJugador();
            jTidJugador.setText(null);
            jTnombreJugador.setText(null);
            jTedadJugador.setText(null);
            jTpuntosATP.setText(null);
            jTrankingJugador.setText(null);
        } else {
            JOptionPane.showMessageDialog(rootPane, "ERROR!! \n" + ValidarDatosAgregarJugador(), "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBagregarJugadorActionPerformed

    private void jTidJugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTidJugadorKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTidJugador, evt);
    }//GEN-LAST:event_jTidJugadorKeyTyped

    private void jTnombreJugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTnombreJugadorKeyTyped
        // TODO add your handling code here:
        validarLetras(jTnombreJugador, evt);
    }//GEN-LAST:event_jTnombreJugadorKeyTyped

    private void jTedadJugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTedadJugadorKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTedadJugador, evt);
    }//GEN-LAST:event_jTedadJugadorKeyTyped

    private void jTpuntosATPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpuntosATPKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTpuntosATP, evt);
    }//GEN-LAST:event_jTpuntosATPKeyTyped

    private void jTrankingJugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTrankingJugadorKeyTyped
        // TODO add your handling code here:
        validarNumeros(jTrankingJugador, evt);
    }//GEN-LAST:event_jTrankingJugadorKeyTyped
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
            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarJugador(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBagregarJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableJugadores;
    private javax.swing.JTextField jTedadJugador;
    private javax.swing.JTextField jTidJugador;
    private javax.swing.JTextField jTnombreJugador;
    private javax.swing.JTextField jTpuntosATP;
    private javax.swing.JTextField jTrankingJugador;
    // End of variables declaration//GEN-END:variables
public static void imprimir(String msj) {
        JOptionPane.showMessageDialog(null, msj);
    }

    public void llenarTablaJugador() {
        DefaultTableModel dtm = (DefaultTableModel) jTableJugadores.getModel();//se usa DefaultTableModel para manipular facilmente el Tablemodel
        dtm.setRowCount(0);//eliminando la s filas que ya hay. para agregar desde el principio.
        //los datos se agregan la defaultTableModel.

        Jugador[] juga = miOpenAustralia.getJugadores();//sacando al informacion a agregar en la tabla.

        //como se va a llenar una tabla de 5 columnas, se crea un vector de 3 elementos.
        //se usa un arreglo de Object para poder agregar a la tabla cualquier tipo de datos.
        Object[] datos = new Object[5];

        for (int i = 0; i < juga.length; i++) {

            Jugador jugador = juga[i];
            //Se agrega este if para evitar que el extraiga datos en un campo null
            if (jugador != null) {

                datos[0] = jugador.getIdJugador();//el primer elemetno del arreglo va a ser el id,la primera col en la Tabla.
                datos[1] = jugador.getNombre();
                datos[2] = jugador.getEdad();
                datos[3] = jugador.getPuntosObtenidos();
                datos[4] = jugador.getRankinATP();

                //agrego al TableModleo ese arreglo
                dtm.addRow(datos);
            }
        }
    }

    public void validarNumeros(JTextField campo, KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            campo.setCursor(null);
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar simbolos!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            campo.setCursor(null);
        }
    }

    public void validarLetras(JTextField campo, KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar numeros!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            campo.setCursor(null);
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar simbolos!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            campo.setCursor(null);
        }
    }

    public String ValidarDatosAgregarJugador() {//Metodo para comprobar que los datos esten completos
        String msj = "";
        if (jTidJugador.getText().equals("")) {//Si jTnombreCita esta vacio
            msj += "Por favor digite el Id. \n";
        }
        if (jTnombreJugador.getText().equals("")) {//Si jTidCita esta vacio
            msj += "Por favor digite el Nombre. \n";
        }
        if (jTedadJugador.getText().equals("")) {//Si jTidCita esta vacio
            msj += "Por favor digite la Edad. \n";
        }
        if (jTpuntosATP.getText().equals("")) {//Si jTidCita esta vacio
            msj += "Por favor digite los Puntos ATP. \n";
        }
        if (jTrankingJugador.getText().equals("")) {//Si jTidCita esta vacio
            msj += "Por favor digite el Ranking ATP. \n";
        }
        return msj;//devuelve msj
    }

}
