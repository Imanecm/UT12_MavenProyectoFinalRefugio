/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controladores.GestorUsuBDO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author Alex
 */
public class VentanaUsuarios extends javax.swing.JFrame {

    GestorUsuBDO gestorUsuarios = new GestorUsuBDO(); //Esto es el constructor vacio

    String nomArchivoBin = "ficheroBin.dat";
    String nomArchivoXML = "ficheroXML.dat";
    String[] nomColumnas = {"USUARIO", "CLAVE"};
    Object[][] matrizDatos;
    DefaultTableModel dtm = new DefaultTableModel(matrizDatos, nomColumnas);

    /**
     * Creates new form VentanaUsuarios
     */
    public VentanaUsuarios() {
        initComponents();
//        gestorUsuario.conectarBDO();  NO SE CONECTA, SE CONECTA DESDE EL CONSTRUCTOR VACIO
        dtm = new DefaultTableModel(matrizDatos, nomColumnas) {
            //para impedir edición de las celdas
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        // Establecimiento de los datos a la tabla
        jTablaDatos.setModel(dtm);

        // Configuración del tipo de selección de la tabla
        jTablaDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        // Ajuste de anchos
//        jTablaDatos.getColumn("USUARIO").setPreferredWidth(100);
//
//        jTablaDatos.getColumn("CLAVE").setPreferredWidth(90);

        jTablaDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = jTablaDatos.getSelectedRow();
                if (id >= 0) {
                    // Obtener los valores de la fila seleccionada
                    String usuario = dtm.getValueAt(id, 0).toString();
                    String clave = dtm.getValueAt(id, 1).toString();

                    // Asignar los valores a los campos de texto
                    jTF_Usuario.setText(usuario);
                    jTF_Clave.setText(clave);
                }
            }
        });

        actualizaTabla();
        //Cierro VentanaUsuarios
    }

    private void actualizaTabla() {
        matrizDatos = gestorUsuarios.obtenerTodo();
        dtm = new DefaultTableModel(matrizDatos, nomColumnas) {
            //para impedir edición de las celdas
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        jTablaDatos.setModel(dtm);
    }

    public void camposEnBlanco() {
        jTF_Usuario.setText("");
        jTF_Clave.setText("");
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
        jTablaDatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTF_Usuario = new javax.swing.JTextField();
        jTF_Clave = new javax.swing.JTextField();
        jB_Añadir = new javax.swing.JButton();
        jCheckBoxVaciar = new javax.swing.JCheckBox();
        jB_Actualizar = new javax.swing.JButton();
        jB_VaciarCampos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jB_BorrarNombre = new javax.swing.JButton();
        jB_BorrarSelec = new javax.swing.JButton();
        jB_CargarEjemplos = new javax.swing.JButton();
        jB_BorrarTodo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jB_GuardarfichBin = new javax.swing.JButton();
        jB_GuardarfichXML = new javax.swing.JButton();
        jB_CargarfichBin = new javax.swing.JButton();
        jB_CargarfichXML = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jTablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("GESTOR DE USUARIOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Usuario: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Clave:");

        jB_Añadir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_Añadir.setText("Añadir");
        jB_Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AñadirActionPerformed(evt);
            }
        });

        jCheckBoxVaciar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxVaciar.setText("Vaciar campos");
        jCheckBoxVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVaciarActionPerformed(evt);
            }
        });

        jB_Actualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_Actualizar.setText("Actualizar");
        jB_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ActualizarActionPerformed(evt);
            }
        });

        jB_VaciarCampos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_VaciarCampos.setText("Vaciar campos");
        jB_VaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VaciarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_Clave, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jTF_Usuario)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jB_Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jCheckBoxVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jB_VaciarCampos)
                .addGap(74, 74, 74)
                .addComponent(jB_Actualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTF_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jB_Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_VaciarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jB_BorrarNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_BorrarNombre.setText("Borrar por nombre");
        jB_BorrarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BorrarNombreActionPerformed(evt);
            }
        });

        jB_BorrarSelec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_BorrarSelec.setText("Borrar seleccionado");
        jB_BorrarSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BorrarSelecActionPerformed(evt);
            }
        });

        jB_CargarEjemplos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_CargarEjemplos.setText("Cargar Ejemplos");
        jB_CargarEjemplos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CargarEjemplosActionPerformed(evt);
            }
        });

        jB_BorrarTodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_BorrarTodo.setText("Borrar todo");
        jB_BorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BorrarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jB_CargarEjemplos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jB_BorrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jB_BorrarSelec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_BorrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_CargarEjemplos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_BorrarSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_BorrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_BorrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jB_GuardarfichBin.setText("Guardar fichero bin");
        jB_GuardarfichBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_GuardarfichBinActionPerformed(evt);
            }
        });

        jB_GuardarfichXML.setText("Guardar fichero XML");
        jB_GuardarfichXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_GuardarfichXMLActionPerformed(evt);
            }
        });

        jB_CargarfichBin.setText("Cargar fichero bin");
        jB_CargarfichBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CargarfichBinActionPerformed(evt);
            }
        });

        jB_CargarfichXML.setText("Cargar fichero XML");
        jB_CargarfichXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CargarfichXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_GuardarfichBin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_CargarfichBin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_GuardarfichXML, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_CargarfichXML, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_GuardarfichBin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_GuardarfichXML, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_CargarfichBin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_CargarfichXML, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AñadirActionPerformed
        String usuarioOb, claveOb;
        try {
            if (jTF_Usuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "El campo nombre no puede estar vacío");
            } else {

                    //guardamos los campos en las variables
                    usuarioOb = jTF_Usuario.getText();
                    claveOb = jTF_Clave.getText();
                    
                    //añadimos el usuario y la clave
                    gestorUsuarios.añadir(usuarioOb, claveOb);

                    // actualizamos tabla con el nuevo usuario
                    actualizaTabla();

                    // añadimos y dejamos los campos vacíos
                if (jCheckBoxVaciar.isSelected()) {
                    camposEnBlanco();
                }
            }

        } catch (EntityExistsException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Pruebe con otro nombre de usuario, puede que este esté en uso.");
        }
    }//GEN-LAST:event_jB_AñadirActionPerformed

    private void jB_CargarEjemplosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CargarEjemplosActionPerformed
        gestorUsuarios.cargarEjemplos();
        actualizaTabla();
    }//GEN-LAST:event_jB_CargarEjemplosActionPerformed

    private void jB_BorrarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BorrarNombreActionPerformed
        String nombre;
        nombre = JOptionPane.showInputDialog("Introduce el nombre de un usuario a borrar: ");
        gestorUsuarios.borrar(nombre);
        actualizaTabla();
    }//GEN-LAST:event_jB_BorrarNombreActionPerformed

    private void jCheckBoxVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVaciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVaciarActionPerformed

    private void jB_VaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VaciarCamposActionPerformed
        camposEnBlanco();
    }//GEN-LAST:event_jB_VaciarCamposActionPerformed

    private void jB_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ActualizarActionPerformed
        String nombre, clave;

        int id = jTablaDatos.getSelectedRow(); //nos da el número de la fila se leccionada de la tabla
        if (id >= 0) {
//            jTablaDatos.isCellSelected(id, 0);
//            jTablaDatos.isCellSelected(id, 1);
            nombre = jTablaDatos.getValueAt(id, 0).toString();
            clave = jTablaDatos.getValueAt(id, 1).toString();
            if (!nombre.equals(jTF_Usuario.getText()) || !clave.equals(jTF_Clave.getText())) {
                try {
                    gestorUsuarios.actualizar(nombre,jTF_Usuario.getText(), jTF_Clave.getText());
                    System.out.println("VALORES SIN ACTUALIZAR " + nombre + " y " + clave);
                    System.out.println("VALORES ACTUALIZADOS " + jTF_Usuario.getText() + " y " + jTF_Clave.getText());
                    camposEnBlanco();
                    actualizaTabla();
                    JOptionPane.showMessageDialog(rootPane, "Los datos se han actualizado perfectamente");
                } catch (EntityExistsException e) {
                    System.out.println(e);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Aún no se ha modificado nada.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "ERROR: aún no has selccionado ningún usuario");
        }
    }//GEN-LAST:event_jB_ActualizarActionPerformed

    private void jB_BorrarSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BorrarSelecActionPerformed
        String nombre;
        try {
            int id = jTablaDatos.getSelectedRow();
            System.out.println(id);
            if (id >= 0) {
                nombre = jTF_Usuario.getText();
                gestorUsuarios.borrar(nombre);
                actualizaTabla();
                camposEnBlanco();
                JOptionPane.showMessageDialog(rootPane, "El usuario ha sido borrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningún registro para borrar");
            }
        } catch (EntityExistsException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jB_BorrarSelecActionPerformed

    private void jB_BorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BorrarTodoActionPerformed
        int resp;
        resp = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de querer borrar todo?");
        System.out.println(resp);
        gestorUsuarios.borrarTodo(resp);
        actualizaTabla();
    }//GEN-LAST:event_jB_BorrarTodoActionPerformed

    private void jB_GuardarfichBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_GuardarfichBinActionPerformed
        gestorUsuarios.guardarArchivoBin(nomArchivoBin, matrizDatos);
    }//GEN-LAST:event_jB_GuardarfichBinActionPerformed

    private void jB_CargarfichBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CargarfichBinActionPerformed
        try {
            gestorUsuarios.cargarArchivoBin(nomArchivoBin);
            actualizaTabla();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_CargarfichBinActionPerformed

    private void jB_GuardarfichXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_GuardarfichXMLActionPerformed
        gestorUsuarios.guardarArchivoXML(nomArchivoXML, matrizDatos);
    }//GEN-LAST:event_jB_GuardarfichXMLActionPerformed

    private void jB_CargarfichXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CargarfichXMLActionPerformed
        try {
            gestorUsuarios.cargarArchivoXML(nomArchivoXML);
            actualizaTabla();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_CargarfichXMLActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Actualizar;
    private javax.swing.JButton jB_Añadir;
    private javax.swing.JButton jB_BorrarNombre;
    private javax.swing.JButton jB_BorrarSelec;
    private javax.swing.JButton jB_BorrarTodo;
    private javax.swing.JButton jB_CargarEjemplos;
    private javax.swing.JButton jB_CargarfichBin;
    private javax.swing.JButton jB_CargarfichXML;
    private javax.swing.JButton jB_GuardarfichBin;
    private javax.swing.JButton jB_GuardarfichXML;
    private javax.swing.JButton jB_VaciarCampos;
    private javax.swing.JCheckBox jCheckBoxVaciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_Clave;
    private javax.swing.JTextField jTF_Usuario;
    private javax.swing.JTable jTablaDatos;
    // End of variables declaration//GEN-END:variables
}
