/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Panke
 */
public class FormPedidosMod extends javax.swing.JFrame {

    /**
     * Creates new form FormPedidosMod
     */
    
    Statement st,st1;
    ResultSet prods,client;
    double sumt=0;
    Dimension si = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().width/3,(int)Toolkit.getDefaultToolkit().getScreenSize().height);
    
    public FormPedidosMod() {
         try {
            
            
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                prods = st.executeQuery("SELECT * FROM pedidos");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }
            
            
            
            
            initComponents();
            String [] columns = {"Id Pedido","Total","Id Empleado","Id Cliente"};
            String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Subtotal"};
            
            
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            lbltotal.setText("$0.0");
            Tab1.setModel(new DefaultTableModel(null,columns2));
            while(prods.next()){
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4)};
                tm.addRow(row);
            }
            
            Tab.setModel(tm);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }}
            ;
            jScrollPane2 = new javax.swing.JScrollPane();
            Tab1 = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int vColIndex){
                    /*if(vColIndex==5)
                    return true;*/
                    return false;
                }
            };
            jLabel1 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            lbltotal = new javax.swing.JLabel();
            btnRollBack = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel2.setText("Filtrar:");

            searchText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    searchTextKeyReleased(evt);
                }
            });

            Tab.setModel(new javax.swing.table.DefaultTableModel(
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
            Tab.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TabMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(Tab);

            Tab1.setModel(new javax.swing.table.DefaultTableModel(
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
            Tab1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Tab1MouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(Tab1);

            jLabel1.setText("Total:");

            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/switch.png"))); // NOI18N

            btnRollBack.setText("Cancelar");
            btnRollBack.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnRollBackMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1286, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1084, 1084, 1084)
                                .addComponent(btnRollBack)
                                .addGap(107, 107, 107)))
                        .addContainerGap()))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 596, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRollBack)
                        .addContainerGap()))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        String where = searchText.getText();
        String [] columns = {"Id Pedido","Total","Id Empleado","Id Cliente"};
        try {
            if("".equals(where)){
                prods = st.executeQuery("SELECT * FROM pedidos");
            }
            else{
                prods = st.executeQuery("SELECT * FROM pedidos WHERE id_pedido LIKE \"%"+where+"%\"");
            }
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            while(prods.next()){
                boolean ban=true;
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4)};
                int n=Tab1.getRowCount();
                for(int i=0;i<n;i++){
                    if(prods.getString(1).equals(Tab1.getValueAt(i, 0)))
                    ban=false;
                    System.out.println(i+": "+prods.getString(1)+" <-> "+Tab1.getValueAt(i, 0)+ "  ::=="+prods.getString(1).equals((String)Tab1.getValueAt(i, 1)));
                }
                if(ban)
                tm.addRow(row);
            }

            Tab.setModel(tm);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_searchTextKeyReleased

    private void TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMouseClicked
        int row = Tab.getSelectedRow();
        
        
        String [] columns = {"Id","Clave","Tipo","Marca","Precio","Cantidad"};
        DefaultTableModel tm = new DefaultTableModel(null,columns);
        //if(!"0".equals((String)Tab.getValueAt(row,0))){|
            try{
                String where = (String)Tab.getValueAt(row, 0);
                
                //System.out.println(where);
                //System.out.println("SELECT p.id_producto, p.clave, p.tipo, p.marca, p.precio_unit, p.cantidad FROM ferrepaq.productos p, ferrepaq.produtos_pedidos pp WHERE pp.id_pedidosFK = \"%"+where+"%\" AND pp.id_productosFK = p.id_producto");
                prods = st.executeQuery("SELECT p.id_producto, p.clave, p.tipo, p.marca, p.precio_unit, pp.cantidad FROM ferrepaq.productos p, ferrepaq.produtos_pedidos pp WHERE pp.id_pedidosFK = \""+where+"\" AND pp.id_productosFK = p.id_producto");
                
                while(prods.next()){
                    
                    String [] row1 = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4), prods.getString(5),prods.getString(6)};
                    tm.addRow(row1);
                }
                Tab1.setModel(tm);
            } catch (SQLException ex) {
                Logger.getLogger(FormPedidosMod.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }        
    }//GEN-LAST:event_TabMouseClicked

    private void Tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab1MouseClicked
        int row = Tab1.getSelectedRow();
        int id_row=Integer.parseInt((String)Tab1.getValueAt(row, 0));
        ResultSet rs;
        try {
            rs = st.executeQuery("SELECT * FROM productos WHERE id_producto = "+id_row+"");
            rs.first();
            double lastcant=Double.parseDouble((String)Tab1.getValueAt(row, 6));
            if(Tab1.getSelectedColumn()!=5){
                DefaultTableModel tm = (DefaultTableModel) Tab.getModel();
                DefaultTableModel tm1 = (DefaultTableModel) Tab1.getModel();
                String [] newRow = {
                    (String)Tab1.getValueAt(row, 0),
                    (String)Tab1.getValueAt(row, 1),
                    (String)Tab1.getValueAt(row, 2),
                    (String)Tab1.getValueAt(row, 3),
                    (String)Tab1.getValueAt(row, 4),
                    rs.getInt(6)+""
                };
                tm.addRow(newRow);
                tm1.removeRow(Tab1.getSelectedRow());
                sumt-=lastcant;
                sumt=Math.floor(sumt*100)/100;
                lbltotal.setText("$"+sumt);
                //falta poner para que se actualice el subtotal de la fila

            }else{

                if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    try {
                        sumt-=lastcant;
                        int cant = Integer.parseInt(JOptionPane.showInputDialog(this, "Introduce la nueva cantidad"));
                        double subt;
                        subt=cant*Double.parseDouble((String)Tab1.getValueAt(row, 4));
                        subt=Math.floor(subt*100)/100;
                        sumt+=subt;
                        Tab1.setValueAt(subt+"",row, 6);
                        Tab1.setValueAt(""+cant, row, 5);
                        sumt=Math.floor(sumt*100)/100;
                        lbltotal.setText("$"+sumt);
                    }
                    catch(Exception e) {
                        System.err.println(e);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Tab1MouseClicked

    private void btnRollBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRollBackMouseClicked
        try {
            sumt=0;
            searchText.setText("");
            lbltotal.setText("$0.0");
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                prods = st.executeQuery("SELECT * FROM productos");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }

            String [] columns = {"Id","Clave","Tipo","Marca","Precio","Cantidad"};
            String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Subtotal"};

            DefaultTableModel tm =  new DefaultTableModel(null,columns);

            Tab1.setModel(new DefaultTableModel(null,columns2));
            while(prods.next()){
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4),prods.getString(5),prods.getString(6)};
                tm.addRow(row);
            }

            Tab.setModel(tm);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }//GEN-LAST:event_btnRollBackMouseClicked

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
            java.util.logging.Logger.getLogger(FormPedidosMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPedidosMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPedidosMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedidosMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPedidosMod().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab;
    private javax.swing.JTable Tab1;
    private javax.swing.JButton btnRollBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
