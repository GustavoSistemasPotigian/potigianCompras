/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import BaseDeDatos.ConexionMySQL;
import Reportes.GenerarReportes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class ConsultaVariables extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaVariables
     */
    DefaultTableModel modelo;
    public ConsultaVariables() {
        initComponents();
        CargarTablaPlanesVariables("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItemImprimir = new javax.swing.JMenuItem();
        jMenuItemArticulos = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarPlan = new javax.swing.JTextField();
        btnBuscarPlan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaPlanes = new javax.swing.JTable();
        btnSalirConsulta = new javax.swing.JButton();

        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemImprimir);

        jMenuItemArticulos.setText("Ver Articulos");
        jMenuItemArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArticulosActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemArticulos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Plan Variable", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Buscar Plan: ");

        txtBuscarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPlanActionPerformed(evt);
            }
        });

        btnBuscarPlan.setText("Buscar");
        btnBuscarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlanActionPerformed(evt);
            }
        });

        tblConsultaPlanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConsultaPlanes.setComponentPopupMenu(jPopupMenu2);
        tblConsultaPlanes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblConsultaPlanes);

        btnSalirConsulta.setText("Salir");
        btnSalirConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarPlan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(btnSalirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalirConsulta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtBuscarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarPlan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Consulta Planes Variables");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPlanActionPerformed
///METODOS DE LOS BOTONES BUSCAR Y SALIR
    private void btnBuscarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlanActionPerformed
       String valor="";
        valor= txtBuscarPlan.getText();

        CargarTablaPlanesVariables(valor);
    }//GEN-LAST:event_btnBuscarPlanActionPerformed

    private void btnSalirConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConsultaActionPerformed
       ConsultaVariables.this.dispose();
    }//GEN-LAST:event_btnSalirConsultaActionPerformed

    //ACCION DEL CLICK DERECHO POR MENU IMPRIMIR Y VER ARTICULOS SELECCIONADOS
    private void jMenuItemImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirActionPerformed
        // TODO add your handling code here:
        int filasel;
        int idplanVariable=0;
        String idString="";
        GenerarReportes repVariable= new GenerarReportes(); 
        modelo= (DefaultTableModel) tblConsultaPlanes.getModel();
        try
           {
             ///** GUARDA EL VALOR DEL ORDEN DEL ELEMENTO SELECCIONADO EN LA TABLA
               filasel=tblConsultaPlanes.getSelectedRow();

               if (filasel==-1)
               {
                   ///MENSAJE SI NO SELECCIONA NINGUN REGISTRO
                   JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
               }
               else
               {///ESTOS METODOS SI SE AGREGA LA OPCION DE MODIFICAR O ELIMINAR
                   //accion="Modificar";
                  
                   idString= (String)modelo.getValueAt(filasel, 0);
                   System.out.println(idString);
                  
                   //habilitar();
                   idplanVariable= Integer.valueOf(idString);
                   System.out.println(idplanVariable);
                   repVariable.reportePlanVariable(idplanVariable);
               }     
           }
        catch (Exception e)
                {
                    
                }
        
    }//GEN-LAST:event_jMenuItemImprimirActionPerformed

    private void jMenuItemArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArticulosActionPerformed
         // TODO add your handling code here:
        int filasel;
        int idplanVariable=0;
        String idString="";
        GenerarReportes repVariable= new GenerarReportes(); 
        //modelo= (DefaultTableModel) tblArticulosVariables.getModel();
        try
           {
               filasel=tblConsultaPlanes.getSelectedRow();
               idString=(String)modelo.getValueAt(filasel, 0);;
               ConsultaArticulos articulosVentana= new ConsultaArticulos();
               articulosVentana.CargarTablaPlanes(idString);
               articulosVentana.setExtendedState(JFrame.MAXIMIZED_BOTH);
               articulosVentana.setVisible(true);

               if (filasel==-1)
               {
                   //MENSAJE SI NO SELECCIONA NADA
                   JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
               }
               }
        catch (Exception e)
                {
                }
        
    }//GEN-LAST:event_jMenuItemArticulosActionPerformed

    ///////CLASES GENERALES
    //carga tabla Articulos
    private void CargarTablaPlanesVariables(String valor){
        String sSQL="";
       
        ///configuramos la tabla.
        String [] titulos= {"Nro de Plan","Tipo","Proveedor","Fecha","Sucursal","Sector","MotivoSNC",
                             "Dev. Desde","Dev. Hasta","Acción Comercial","Aplicación", "Comprador" };
        String [] registro= new String[12];
        modelo = new DefaultTableModel(null,titulos);
        ///realizamos la conexion con la bdd.
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
       ///ingresamos la consulta
        sSQL="select pl.idPlan_descuento as Plan_Nro, pl.tipo_plan as Tipo,pr.razon_social as Proveedor, "+
             "pl.fechaActual as Fecha,suc.descripcion as Sucursal,sec.descripcion as Sector, mot.descripcion as MotivoSNC,  "+
             "pl.fecha_Devengamiento_Desde as Desde,pl.fecha_Devengamiento_Hasta as Hasta, pl.accion_comercial as Accion, pl.aplicacion as Aplicacion, "+
             "concat (usr.apellido, ' ' , usr.nombre) as Comprador "+
             "from plan_descuento as pl "+ 
             "INNER JOIN proveedor as pr ON pr.idproveedor = pl.Proveedor_idProveedor "+
             "INNER JOIN sector as sec ON sec.idSector= pl.Sector_idSector "+
             "INNER JOIN motivo_snc as mot ON mot.idMotivo_SNC= pl.Motivo_SNC_idMotivo_SNC "+
             "INNER JOIN usuario as usr ON usr.idUsuario= pl.Usuario_idUsuario "+
             "INNER JOIN sucursal as suc ON suc.idSucursal= pl.Sucursal_idSucursal "+
             "WHERE "+ 
             "CONCAT(pl.idPlan_descuento, ' ',pl.tipo_plan, ' ',pr.razon_social, ' ', pl.fechaActual,' ',"
                + "pl.fecha_Devengamiento_Desde ,' ', pl.fecha_Devengamiento_Hasta, "+
             "sec.descripcion, ' ',mot.descripcion, ' ' ,pl.aplicacion, ' ', "+
             "concat (usr.apellido, ' ' , usr.nombre)) "+ 
             "LIKE '%"+ valor +"%' order by Plan_Nro" ; 
        
        try 
        {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while (rs.next())
            {
                registro[0]=rs.getString("Plan_Nro");
                registro[1]=rs.getString("Tipo");
                registro[2]=rs.getString("Proveedor");
                registro[3]=rs.getString("Fecha");
                registro[4]=rs.getString("Sucursal");
                registro[5]=rs.getString("Sector");
                registro[6]=rs.getString("MotivoSNC");
                registro[7]=rs.getString("Desde");
                registro[8]=rs.getString("Hasta");
                registro[9]=rs.getString("Accion");
                registro[10]=rs.getString("Aplicacion");
                registro[11]=rs.getString("Comprador");
                modelo.addRow(registro);
              }
            tblConsultaPlanes.setModel(modelo);
                        
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
  }
    
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
            java.util.logging.Logger.getLogger(ConsultaVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaVariables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPlan;
    private javax.swing.JButton btnSalirConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemArticulos;
    private javax.swing.JMenuItem jMenuItemImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultaPlanes;
    private javax.swing.JTextField txtBuscarPlan;
    // End of variables declaration//GEN-END:variables
}
