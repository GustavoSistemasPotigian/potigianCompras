/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import BaseDeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class Articulos extends javax.swing.JFrame {

    /**
     * Creates new form Articulos
     */
    DefaultTableModel modelo;
    
    
    public Articulos() {
        initComponents();
        CargarTablaArticulos("");
        //al iniciar la ventana queda inhabilitado hasta darle click en nuevo.
        inhabilitar();
    }
    
    //variable para buscar variable a editar
    String id_actualizar="";
   
    void BuscarArticuloEditar(String idArticulo){
        String sSQL="";
        String idArt="",descr="",unid="",fecha="",costo="",vigente="", margen="",idprov="",cant="";
       
        ///realizamos la conexion con la bdd.
        
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
       ///ingresamos la consulta
        
        sSQL="SELECT idArticulo, descripcion, unidad_de_venta,fecha_ingreso_inicial, precio_costo, precio_vigente, margen, Proveedor_IdProveedor, cantidad_total FROM articulo " +
             "WHERE idArticulo= " + idArticulo;
        
        try 
        {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while (rs.next())///recorre cada valor de la consulta y la guarda en las variables.
            {                
                idArt=rs.getString("idArticulo");
                descr=rs.getString("descripcion");
                unid=rs.getString("unidad_de_venta");
                fecha=rs.getString("fecha_ingreso_inicial");
                costo=rs.getString("precio_costo");
                vigente=rs.getString("precio_vigente");
                margen=rs.getString("margen");
                idprov=rs.getString("Proveedor_IdProveedor");
                cant=rs.getString("cantidad_total");             
              }
            txtIdArticulo.setText(idArt);
            txtDescripcion.setText(descr);
            txtUnidadVenta.setText(unid);
            txtFechaIngreso.setText(fecha);
            txtPrecioCosto.setText(costo);
            txtPrecioVigente.setText(vigente);
            txtMargen.setText(margen);
            txtIdProveedor.setText(idprov);
            txtCantidadTotal.setText(cant);
            
            id_actualizar = idArticulo;
           
            
                        
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    
    } 
    
    //carga tabla Articulos
    void CargarTablaArticulos(String valor){
        String sSQL="";
       
        ///configuramos la tabla.
        String [] titulos= {"idArticulo","descripcion","Unidad de Venta","Fecha Ingreso","Precio Costo","Precio Vigente","Margen","IdProveedor","Cantidad Total"};
        String [] registro= new String[9];
        modelo = new DefaultTableModel(null,titulos);
        ///realizamos la conexion con la bdd.
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
       ///ingresamos la consulta
       
        sSQL="SELECT idArticulo, descripcion, unidad_de_venta,fecha_ingreso_inicial, precio_costo, precio_vigente,margen, Proveedor_IdProveedor,cantidad_total FROM articulo " +
                "WHERE CONCAT (idArticulo,' ',descripcion,' ', fecha_ingreso_inicial,' ', precio_costo,' ',precio_vigente,' ', margen,' ', Proveedor_IdProveedor) LIKE '%"+valor+"%'";
        
        try 
        {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while (rs.next())
            {
                registro[0]=rs.getString("idArticulo");
                registro[1]=rs.getString("descripcion");
                registro[2]=rs.getString("unidad_de_venta");
                registro[3]=rs.getString("fecha_ingreso_inicial");
                registro[4]=rs.getString("precio_costo");
                registro[5]=rs.getString("precio_vigente");
                registro[6]=rs.getString("margen");
                registro[7]=rs.getString("Proveedor_IdProveedor");
                registro[8]=rs.getString("cantidad_total");
                
                modelo.addRow(registro);
              }
            tblConsultaArticulos.setModel(modelo);
                        
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
  }
    
    
    
    void habilitar()
    {
          //habilita cada opción
    txtIdArticulo.setEnabled(true);
    txtDescripcion.setEnabled(true);
    txtUnidadVenta.setEnabled(true);
    txtFechaIngreso.setEnabled(true);
    txtPrecioCosto.setEnabled(true);
    txtPrecioVigente.setEnabled(true);
    txtMargen.setEnabled(true);
    txtIdProveedor.setEnabled(true);
    txtCantidadTotal.setEnabled(true);
    btnGuardarArticulo.setEnabled(true);
    btnCancelarArticulo.setEnabled(true);
    btnCalcularMargen.setEnabled(true);
    btnCalcularPrecioVigente.setEnabled(true);
    //vacia los campos en ""
    txtIdArticulo.setText("");
    txtDescripcion.setText("");
    txtUnidadVenta.setText("");
    txtFechaIngreso.setText("aaaa-mm-dd");
    txtPrecioCosto.setText("");
    txtPrecioVigente.setText("");
    txtMargen.setText("");
    txtIdProveedor.setText("");
    txtCantidadTotal.setText("");
    
    ///ubica el cursor en el primer campo
    txtIdArticulo.requestFocus();
        
        
    }
    ///metodo para cancelar la carga de datos
    void inhabilitar(){
        //deshabilita cada opción
    txtIdArticulo.setEnabled(false);
    txtDescripcion.setEnabled(false);
    txtUnidadVenta.setEnabled(false);
    txtFechaIngreso.setEnabled(false);
    txtPrecioCosto.setEnabled(false);
    txtPrecioVigente.setEnabled(false);
    txtMargen.setEnabled(false);
    txtIdProveedor.setEnabled(false);
    txtCantidadTotal.setEnabled(false);
    btnGuardarArticulo.setEnabled(false);
    btnCancelarArticulo.setEnabled(false);
    btnCalcularMargen.setEnabled(false);
    btnCalcularPrecioVigente.setEnabled(false);
    //vacia los campos en ""
    txtIdArticulo.setText("");
    txtDescripcion.setText("");
    txtUnidadVenta.setText("");
    txtFechaIngreso.setText("aaaa-mm-dd");
    txtPrecioCosto.setText("");
    txtPrecioVigente.setText("");
    txtMargen.setText("");
    txtIdProveedor.setText("");
    txtCantidadTotal.setText("");
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnEditar = new javax.swing.JMenuItem();
        mnEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnidadVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        txtPrecioCosto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioVigente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        btnNuevoArticulo = new javax.swing.JButton();
        btnGuardarArticulo = new javax.swing.JButton();
        btnCancelarArticulo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMargen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarArticulo = new javax.swing.JTextField();
        btnBuscarArticulo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaArticulos = new javax.swing.JTable();
        btnCalcularMargen = new javax.swing.JButton();
        btnCalcularPrecioVigente = new javax.swing.JButton();

        jPopupMenu1.setComponentPopupMenu(jPopupMenu1);

        mnEditar.setText("Modificar");
        mnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnEditar);

        mnEliminar.setText("Eliminar");
        mnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Potigian- Ingreso De Artículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("IdArtículo:");

        txtIdArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdArticuloActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripción:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel3.setText("Unidad de Venta:");

        txtUnidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadVentaActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha De Ingreso: ");

        txtFechaIngreso.setText("aaaa-mm-dd");
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });

        txtPrecioCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCostoActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio de Costo:");

        jLabel6.setText("Precio Vigente:");

        jLabel7.setText("Cantidad Total:");

        jLabel8.setText("idProveedor: ");

        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });

        btnNuevoArticulo.setText("Nuevo");
        btnNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArticuloActionPerformed(evt);
            }
        });

        btnGuardarArticulo.setText("Guardar");
        btnGuardarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArticuloActionPerformed(evt);
            }
        });

        btnCancelarArticulo.setText("Cancelar");
        btnCancelarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarArticuloActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel9.setText("Margen: ");

        txtMargen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMargenActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar Articulo: ");

        btnBuscarArticulo.setText("Buscar");
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });

        jLabel11.setText("Consulta de Artículos");

        tblConsultaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConsultaArticulos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblConsultaArticulos);

        btnCalcularMargen.setText("Calcular Margen");
        btnCalcularMargen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularMargenActionPerformed(evt);
            }
        });

        btnCalcularPrecioVigente.setText("Calcular Precio Vigente");
        btnCalcularPrecioVigente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPrecioVigenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtUnidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtCantidadTotal))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtPrecioVigente))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtMargen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnCalcularPrecioVigente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnCalcularMargen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevoArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardarArticulo)
                                .addGap(14, 14, 14)
                                .addComponent(btnCancelarArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarArticulo)))))
                        .addGap(0, 473, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUnidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioVigente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularMargen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularPrecioVigente))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoArticulo)
                    .addComponent(btnGuardarArticulo)
                    .addComponent(btnCancelarArticulo)
                    .addComponent(btnSalir))
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(194, 194, 194))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdArticuloActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtUnidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadVentaActionPerformed

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void txtPrecioCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCostoActionPerformed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Articulos.this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtMargenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMargenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMargenActionPerformed

    private void btnNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArticuloActionPerformed
        habilitar();//habilita los campor para la carga de datos
    }//GEN-LAST:event_btnNuevoArticuloActionPerformed

    private void btnCancelarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarArticuloActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btnCancelarArticuloActionPerformed
        
    String accion="Insertar";
    private void btnGuardarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArticuloActionPerformed
        //conexión a la bdd
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        ///STRING A UTILIZAR
        String idArt,descr, unid,fecha,pCosto,pVigente,marg,idProv,cantidad;
        String sSQL="";
        String mensaje;
        idArt=txtIdArticulo.getText();
        descr=txtDescripcion.getText();
        unid=txtUnidadVenta.getText();
        fecha=txtFechaIngreso.getText();
        pCosto=txtPrecioCosto.getText();
        pVigente= txtPrecioVigente.getText();
        marg=txtMargen.getText();
        idProv= txtIdProveedor.getText();
        cantidad=txtCantidadTotal.getText();
                
        ///creamos la consulta sql
        if (accion.equals("Insertar"))
        {
            sSQL="INSERT INTO articulo (idArticulo, descripcion, unidad_de_venta, fecha_ingreso_inicial, precio_costo,precio_vigente,margen,proveedor_idproveedor,cantidad_total) "+
                "VALUES (?,?,?,?,?,?,?,?,?)";
           mensaje="Operación Satisfactoria";
        }
        
        else if (accion.equals("Modificar"))
        {
            sSQL="UPDATE articulo " +
                 "SET idArticulo= ?," +
                 "descripcion= ?, "+
                 "unidad_de_venta= ?, " +
                 "fecha_ingreso_inicial= ?, " +
                 "precio_costo= ? ," +
                 "precio_vigente= ? ," +
                 "margen=?," +   
                 "proveedor_idproveedor= ? , "+
                 "cantidad_total= ? " +  
                 "WHERE idArticulo= " + id_actualizar;
            mensaje="Operación Satisfactoría";
        }
        
        
        try 
        {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setString(1, idArt );
            pst.setString(2, descr);
            pst.setString(3, unid);
            pst.setString(4, fecha);
            pst.setString(5, pCosto);
            pst.setString(6, pVigente);
            pst.setString(7, marg);
            pst.setString(8, idProv);
            pst.setString(9, cantidad);
            
            int n = pst.executeUpdate();
            
            if (n>0)
            {    
                mensaje="Operación Satisfactoria";
                JOptionPane.showMessageDialog(null, mensaje);
                CargarTablaArticulos("");
                habilitar();//habilita los campos para la carga de datos
                inhabilitar();
            }
            
            
            
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnGuardarArticuloActionPerformed

    
    
    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        String valor=txtBuscarArticulo.getText();
        
        CargarTablaArticulos(valor);
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void mnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarActionPerformed
         int filasel;
        String idArticulo;
        
        try
           {
               filasel=tblConsultaArticulos.getSelectedRow();
               
               if (filasel==-1)
               {
                   JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
               }
               else
               {
                   accion="Modificar";
                   modelo= (DefaultTableModel) tblConsultaArticulos.getModel();
                   idArticulo= (String) modelo.getValueAt(filasel, 0);
                   habilitar();
                   BuscarArticuloEditar(idArticulo);          
               }     
           }
        catch (Exception e)
                {
                    
                }
    }//GEN-LAST:event_mnEditarActionPerformed

    private void mnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEliminarActionPerformed
         int filasel;
        String idArticulo;
        
        try
           {
               filasel=tblConsultaArticulos.getSelectedRow();
               
               if (filasel==-1)
               {
                   JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
               }
               else
               {
                   //accion="Eliminar";
                   modelo= (DefaultTableModel) tblConsultaArticulos.getModel();
                   idArticulo= (String) modelo.getValueAt(filasel, 0);
                   habilitar();
                   BuscarUsuarioEliminar(idArticulo);          
               }     
           }
        catch (Exception e)
                {
                    
                }
    }//GEN-LAST:event_mnEliminarActionPerformed

    private void btnCalcularPrecioVigenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPrecioVigenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularPrecioVigenteActionPerformed

    private void btnCalcularMargenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularMargenActionPerformed
        int valorMargen;
      
    }//GEN-LAST:event_btnCalcularMargenActionPerformed
  void BuscarUsuarioEliminar(String idArticulo)
   {
       String sSQL="";
       
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
       ///ingresamos la consulta
        
        sSQL="DELETE FROM articulo " +
             "WHERE idArticulo= " + idArticulo;
        String mensaje="";
       
        try 
        {
            PreparedStatement pps= cn.prepareStatement(sSQL);
            int  n= pps.executeUpdate();
            
            if (n>0)
            {    
                mensaje="El usuario ha sido eliminado correctamente";
                JOptionPane.showMessageDialog(null, mensaje);
                CargarTablaArticulos("");
                inhabilitar();
            }
                       
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
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarArticulo;
    private javax.swing.JButton btnCalcularMargen;
    private javax.swing.JButton btnCalcularPrecioVigente;
    private javax.swing.JButton btnCancelarArticulo;
    private javax.swing.JButton btnGuardarArticulo;
    private javax.swing.JButton btnNuevoArticulo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnEditar;
    private javax.swing.JMenuItem mnEliminar;
    private javax.swing.JTable tblConsultaArticulos;
    private javax.swing.JTextField txtBuscarArticulo;
    private javax.swing.JTextField txtCantidadTotal;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtIdArticulo;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtMargen;
    private javax.swing.JTextField txtPrecioCosto;
    private javax.swing.JTextField txtPrecioVigente;
    private javax.swing.JTextField txtUnidadVenta;
    // End of variables declaration//GEN-END:variables
}
