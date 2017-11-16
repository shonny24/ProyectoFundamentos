/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import logica.*;

/**
 *
 * @author Shonny & juank
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private OpenDeAustralia miOpenAustralia = new OpenDeAustralia();//llamo la clase OpenDeAustralia y la inicializo (asigno espacio de memoria)
    private Jugador miJugador;//Variable de tipo jugador
    private Partido miPartido;//variable de tipo partido

    /**
     * Constructor de la ventana principal
     */
    public VentanaPrincipal() {
        initComponents();
        //PONER EL FAVICON AL PROGRAMA
        setIconImage(new ImageIcon(getClass().getResource("/interfaz/images/Australian_Open_Logo.png")).getImage());
        //*********************************
        //inicializamos la persistencia del jugador
        try {//excepción
            miOpenAustralia.inicializarAtributosJugador();
            miOpenAustralia.inicializarAtributosPista();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El archivo no pudo ser leído");
        }
        //*********************************

        //************************
        //Centrar Jframe
        setLocationRelativeTo(null);
        //************************

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstadisticas = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablemayorAsistencia = new javax.swing.JTable();
        jLGanador = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMOctavos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMCuartos = new javax.swing.JMenuItem();
        jMSemiFinal = new javax.swing.JMenuItem();
        jMFinal = new javax.swing.JMenuItem();
        jMPuntosJugador = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open de Australia");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadistica generales"));

        jTableEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador1", "Jugador2", "Pista", "Fecha/Hora", "Tiempo", "Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEstadisticas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableEstadisticas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableEstadisticasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEstadisticas);
        if (jTableEstadisticas.getColumnModel().getColumnCount() > 0) {
            jTableEstadisticas.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableEstadisticas.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTableEstadisticas.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Jugador con mayor tiempo en la cancha:");

        jLabel2.setText("Jugador con menor tiempo en la cancha:");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tiempo de Jugadores", jPanel2);

        jTablemayorAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "# Partido", "Pista", "Asistencia", "Jugador 1", "Jugador2", "Fecha/Hora"
            }
        ));
        jScrollPane2.setViewportView(jTablemayorAsistencia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cancha mayor asitencia", jPanel3);

        jLGanador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLGanador.setForeground(new java.awt.Color(0, 102, 255));
        jLGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLGanador.setText("Open de Australia");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Australian-Open.png"))); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Archivo.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/agregar2.png"))); // NOI18N
        jMenu4.setText("Agregar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/jugador-de-tenis.png"))); // NOI18N
        jMenuItem1.setText("Jugador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/pista-de-tenis.png"))); // NOI18N
        jMenuItem2.setText("Pista");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Ver.png"))); // NOI18N
        jMenu3.setText("Ver");

        jMOctavos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Etapa.png"))); // NOI18N
        jMOctavos.setText("Rondas");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/podio.png"))); // NOI18N
        jMenuItem3.setText("Octavos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMOctavos.add(jMenuItem3);

        jMCuartos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMCuartos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/podio.png"))); // NOI18N
        jMCuartos.setText("Cuartos");
        jMCuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCuartosActionPerformed(evt);
            }
        });
        jMOctavos.add(jMCuartos);

        jMSemiFinal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMSemiFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/podio.png"))); // NOI18N
        jMSemiFinal.setText("Semi Final");
        jMSemiFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSemiFinalActionPerformed(evt);
            }
        });
        jMOctavos.add(jMSemiFinal);

        jMFinal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/podio.png"))); // NOI18N
        jMFinal.setText("Final");
        jMFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFinalActionPerformed(evt);
            }
        });
        jMOctavos.add(jMFinal);

        jMenu3.add(jMOctavos);

        jMPuntosJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Puntos.png"))); // NOI18N
        jMPuntosJugador.setText("Puntos Jugador");
        jMPuntosJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPuntosJugadorActionPerformed(evt);
            }
        });
        jMenu3.add(jMPuntosJugador);

        jMenuBar1.add(jMenu3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/Ayuda2.png"))); // NOI18N
        jMenu2.setText("Ayuda");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/images/about.png"))); // NOI18N
        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jLGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLGanador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Inicializamos la ventana agregarjugador y le pasamos como parametro OpenDeAutralia para evitar que se reinicie los datos
        VentanaAgregarJugador agregarJugador = new VentanaAgregarJugador(miOpenAustralia);
        agregarJugador.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //Inicializamos la VentanaAgregarPista y le pasamos como parametro OpenDeAutralia para evitar que se reinicie los datos
        VentanaAgregarPista pistas = new VentanaAgregarPista(miOpenAustralia);
        pistas.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFinalActionPerformed
        //Inicializamos la VentanaVerRondas y le pasamos como parametro OpenDeAutralia para evitar que se reinicie los datos
        VentanaVerRondas rondas = new VentanaVerRondas(miOpenAustralia);
        int tamArreglo;
        int inicioArray;
        int finalArray;

        int inicio = 14;
        int limite = 15;
        //verificamos si el arraylist esta con contenido
        if (!(miOpenAustralia.getPartidos().isEmpty())) {
            //llamamos el numero de ganadores y verificamos si esta el rango de 14 a 15
            if (miOpenAustralia.numeroGanadores() >= 14 && miOpenAustralia.numeroGanadores() <= 15) {
                //verificamos si el arraylist tiene menos de 15
                if (miOpenAustralia.getPartidos().size() < 15) {
                    tamArreglo = 2;
                    inicioArray = 12;
                    finalArray = 14;
                    //llamamos al metodo generarPatidos
                    miOpenAustralia.generarPartidos(tamArreglo, inicioArray, finalArray);
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Final";
                } else {
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Final";
                }

            } else {
                JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todas las semi finales");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todas las semi finales");
        }

    }//GEN-LAST:event_jMFinalActionPerformed

    private void jMSemiFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSemiFinalActionPerformed
        //Inicializamos la VentanaVerRondas y le pasamos como parametro OpenDeAutralia para evitar que se reinicie los datos
        VentanaVerRondas rondas = new VentanaVerRondas(miOpenAustralia);
        int tamArreglo;
        int inicioArray;
        int finalArray;

        int inicio = 12;
        int limite = 14;
        //verificamos si el arraylist esta con contenido
        if (!(miOpenAustralia.getPartidos().isEmpty())) {
            //llamamos el numero de ganadores y verificamos si esta el rango de 12 a 15
            if (miOpenAustralia.numeroGanadores() >= 12 && miOpenAustralia.numeroGanadores() <= 15) {
                //verificamos si el arraylist tiene menos de 14
                if (miOpenAustralia.getPartidos().size() < 14) {
                    tamArreglo = 4;
                    inicioArray = 8;
                    finalArray = 12;
                    //llamamos al metodo generarPatidos
                    miOpenAustralia.generarPartidos(tamArreglo, inicioArray, finalArray);
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Semi Final";
                } else {
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Semi Final";
                }

            } else {
                JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todos los cuartos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todos los cuartos");
        }

    }//GEN-LAST:event_jMSemiFinalActionPerformed

    private void jMCuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCuartosActionPerformed
        // TODO add your handling code here:
        VentanaVerRondas rondas = new VentanaVerRondas(miOpenAustralia);
        int tamArreglo;
        int inicioArray;
        int finalArray;

        int inicio = 8;
        int limite = 12;
        //verificamos si el arraylist esta con contenido
        if (!(miOpenAustralia.getPartidos().isEmpty())) {
            //llamamos el numero de ganadores y verificamos si esta el rango de 8 a 15
            if (miOpenAustralia.numeroGanadores() >= 8 && miOpenAustralia.numeroGanadores() <= 15) {
                //verificamos si el arraylist tiene menos de 12
                if (miOpenAustralia.getPartidos().size() < 12) {
                    tamArreglo = 8;
                    inicioArray = 0;
                    finalArray = 8;
                    //llamamos al metodo generarPatidos
                    miOpenAustralia.generarPartidos(tamArreglo, inicioArray, finalArray);
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Cuartos Final";
                } else {
                    //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
                    rondas.llenarTabla(inicio, limite);
                    rondas.setVisible(true);
                    //llamamos el parametro etapa que esta en la ventanaJugarPartido
                    VentanaJugarPartido.etapa = "Cuartos Final";
                }

            } else {
                JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todos los octavos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero se tiene que jugar todos los octavos");
        }

    }//GEN-LAST:event_jMCuartosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        VentanaVerRondas rondas = new VentanaVerRondas(miOpenAustralia);
        int inicio = 0;
        int limite = 8;
        //se verifica si el arraylist esta vacio, si lo esta se agrega datos de lo contrario no se agrega nada
        if (miOpenAustralia.getPartidos().isEmpty()) {
            miOpenAustralia.generarOctavos();

        }
        //llamamos el metodo llenar tabla que esta en la ventanaVerRondas
        rondas.llenarTabla(inicio, limite);
        rondas.setVisible(true);
        //llamamos el parametro etapa que esta en la ventanaJugarPartido
        VentanaJugarPartido.etapa = "Octavos Final";

    }//GEN-LAST:event_jMenuItem3ActionPerformed
    //Evento que se ejecuta cuando se hace focus a la tabla Estadisticas
    private void jTableEstadisticasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableEstadisticasFocusGained
        //llamamos el metodo llenarTablaEstadisticas
        llenarTablaEstadisticas();
        //verificamos si el numero de ganadores es igual a 15(es por que termino el torneo)
        if (miOpenAustralia.numeroGanadores() == 15) {
            //llamamos el metodo ganador torneo para luego agregar el nombre al Jlabel Ganador
            if (miOpenAustralia.ganadorTorneo() == null) {
                jLGanador.setText("Open de Australia");
            } else {
                //obtenemos el ganador del metodo ganadorTorneo y obtenemos el nombre
                jLGanador.setText("Campeón: " + miOpenAustralia.ganadorTorneo().getNombre());
                //llenamos la tabla mayorAsistencia
                llenarTablaMayorAsistencia();

            }
        }
        jLabel3.setText(miOpenAustralia.jugadorMayorTiempo());// Se obtiene el nombre y tiempo del jugador con mayor tiempo en cancha
        jLabel4.setText(miOpenAustralia.jugadorMenorTiempo());// Se obtiene el nombre y tiempo del jugador con menor tiempo en cancha
    }//GEN-LAST:event_jTableEstadisticasFocusGained

    private void jMPuntosJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPuntosJugadorActionPerformed
        // TODO add your handling code here:
        VentanaPuntosJugador puntosJugador = new VentanaPuntosJugador(miOpenAustralia);
        puntosJugador.setVisible(true);
    }//GEN-LAST:event_jMPuntosJugadorActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        VentanaAbout about =new VentanaAbout();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLGanador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMCuartos;
    private javax.swing.JMenuItem jMFinal;
    private javax.swing.JMenu jMOctavos;
    private javax.swing.JMenuItem jMPuntosJugador;
    private javax.swing.JMenuItem jMSemiFinal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEstadisticas;
    private javax.swing.JTable jTablemayorAsistencia;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para llenar la tablaEstadisticas
     */
    public void llenarTablaEstadisticas() {
        DefaultTableModel dtm = (DefaultTableModel) jTableEstadisticas.getModel();//se usa DefaultTableModel para manipular facilmente el Tablemodel
        dtm.setRowCount(0);//eliminando la s filas que ya hay. para agregar desde el principio.
        //los datos se agregan la defaultTableModel.
        ArrayList<Partido> llenar = miOpenAustralia.getPartidos();//sacando al informacion a agregar en la tabla.

        //como se va a llenar una tabla de 5 columnas, se crea un vector de 3 elementos.
        //se usa un arreglo de Object para poder agregar a la tabla cualquier tipo de datos.
        Object[] datos = new Object[6];
        for (int i = 0; i < llenar.size(); i++) {

            Partido parti = llenar.get(i);
            //Se agrega este if para evitar que el extraiga datos en un campo null
            if (parti != null) {

                datos[0] = parti.getJugador1().getNombre();
                datos[1] = parti.getJugador2().getNombre();
                datos[2] = parti.getPista().getNombre();
                datos[3] = parti.getFechaHora();
                datos[4] = parti.getTiempo();
                if (parti.getTiempo().equals("00:00:00")) {
                    datos[5] = "0";
                } else {
                    datos[5] = parti.getAsistencia();
                }

                //agrego al TableModleo ese arreglo
                dtm.addRow(datos);
            }
        }

        // Instanciamos el TableRowSorter y lo añadimos al JTable
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);

        jTableEstadisticas.setRowSorter(elQueOrdena);

    }

    /**
     *
     */
    public void llenarTablaMayorAsistencia() {
        DefaultTableModel dtm = (DefaultTableModel) jTablemayorAsistencia.getModel();//se usa DefaultTableModel para manipular facilmente el Tablemodel
        dtm.setRowCount(0);//eliminando la s filas que ya hay. para agregar desde el principio.
        //los datos se agregan la defaultTableModel.
        Partido llenar = miOpenAustralia.mayorAsistencia();//sacando al informacion a agregar en la tabla.

        //como se va a llenar una tabla de 5 columnas, se crea un vector de 3 elementos.
        //se usa un arreglo de Object para poder agregar a la tabla cualquier tipo de datos.
        Object[] datos = new Object[6];

        //Se agrega este if para evitar que el extraiga datos en un campo null
        if (llenar != null) {

            datos[0] = llenar.getId();
            datos[1] = llenar.getPista().getNombre();
            datos[2] = llenar.getAsistencia();
            datos[3] = llenar.getJugador1().getNombre();
            datos[4] = llenar.getJugador2().getNombre();
            datos[5] = llenar.getFechaHora();

            //agrego al TableModleo ese arreglo
            dtm.addRow(datos);
        }
    }
}
