/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.HeadlessException;
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
 * @author Omar
 */
public class PanelPedidos extends javax.swing.JPanel {
    
    /**
     * Creates new form PanelPedidos
     */
    Statement st;
    ResultSet pedidos;
    double sumt =0;
    String [] columns = {"Id","Total","Cliente","Fecha"};
    String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Stock","Subtotal"};
    
    
    public PanelPedidos() {
        try {
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                pedidos = st.executeQuery("SELECT id_pedido, total_pedido, nombre_cliente, fecha_pedido "
                        + "FROM pedidos JOIN clientes ON id_clienteFK=id_cliente");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }
            
            
            
            
            initComponents();
            
            
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            tabProds.setModel(new DefaultTableModel(null,columns2));
            sumt=0;
            for(int i=0; i<tabProds.getRowCount();i++){
                sumt+=Double.parseDouble(tabProds.getValueAt(i, 7)+"");
            }
            lbltotal.setText("$"+sumt);
            while(pedidos.next()){
                String [] row = {pedidos.getString(1),pedidos.getString(2),pedidos.getString(3),pedidos.getTimestamp(4)+""};
                tm.addRow(row);
            }
            
            tabPedidos.setModel(tm);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPedidos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex){
                /*if(vColIndex==5)
                return true;*/
                return false;
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        tabProds = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex){
                /*if(vColIndex==5)
                return true;*/
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCommit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        buttonRefresh = new javax.swing.JButton();

        tabPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabPedidosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabPedidos);

        tabProds.setModel(new javax.swing.table.DefaultTableModel(
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
        tabProds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabProds);

        jLabel1.setText("Pedidos");

        jLabel2.setText("Productos");

        btnCommit.setText("Guardar");
        btnCommit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCommitMouseClicked(evt);
            }
        });

        jLabel3.setText("Total:");

        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        buttonRefresh.setText("Actualizar");
        buttonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCommit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCommit)
                            .addComponent(buttonRefresh))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void tabPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPedidosMousePressed
        
        int row = tabPedidos.getSelectedRow();
        int id_row=Integer.parseInt((String)tabPedidos.getValueAt(row, 0));
        ResultSet rs;
        DefaultTableModel tm =  new DefaultTableModel(null,columns2);
        try {
            rs = st.executeQuery(
                    "SELECT id_producto, clave, tipo , marca, precio_unit, pp.cantidad, p.cantidad, (precio_unit*pp.cantidad) as monto " +
                    "FROM productos p JOIN produtos_pedidos pp ON id_productosFK=id_producto\n" +
                    "WHERE  pp.id_pedidosFK="+id_row
                    );
            while(rs.next()){
                String [] rown = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
                tm.addRow(rown);
            }
            
            
            
            tabProds.setModel(tm);
            
            sumt=0;
            for(int i=0; i<tabProds.getRowCount();i++){
                sumt+=Double.parseDouble(tabProds.getValueAt(i, 7)+"");
            }
            lbltotal.setText("$"+sumt);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tabPedidosMousePressed
    
    private void tabProdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdsMouseClicked
        int row = tabProds.getSelectedRow();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            try {
                int cant = Integer.parseInt(JOptionPane.showInputDialog(this, "Introduce la nueva cantidad"));
                int stock = Integer.parseInt(tabProds.getValueAt(row, 6)+"");
                if(cant <= stock){
                    double subt;
                    subt=cant*Double.parseDouble((String)tabProds.getValueAt(row, 4));
                    subt=Math.floor(subt*100)/100;
                    tabProds.setValueAt(subt+"",row, 7);
                    tabProds.setValueAt(""+cant, row, 5);
                    sumt=0;
                    for(int i=0; i<tabProds.getRowCount();i++){
                        sumt+=Double.parseDouble(tabProds.getValueAt(i, 7)+"");
                    }
                    lbltotal.setText("$"+sumt);   
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede vender este producto por que no hay productos en existencia");
                }
                
            }
            catch(HeadlessException | NumberFormatException e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_tabProdsMouseClicked

    private void btnCommitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCommitMouseClicked
        try {
            for(int i=0; i<tabProds.getRowCount(); i++){
                st.execute( "UPDATE produtos_pedidos " +
                        " SET cantidad=" + tabProds.getValueAt(i, 5) +
                        " WHERE id_pedidosFK="+tabPedidos.getValueAt(tabPedidos.getSelectedRow(), 0)+
                        " and id_productosFK="+tabProds.getValueAt(i, 0));
                st.execute("UPDATE pedidos SET total_pedido = "+sumt+" WHERE id_pedido = "+tabPedidos.getValueAt(tabPedidos.getSelectedRow(), 0));
                int stock = Integer.parseInt(tabProds.getValueAt(i, 6)+"");
                int val = Integer.parseInt(tabProds.getValueAt(i, 5)+"");
                st.execute("UPDATE productos SET cantidad = "+(stock-val)+" WHERE id_producto = "+tabProds.getValueAt(i, 0));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanelPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCommitMouseClicked

    private void buttonRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRefreshMouseClicked
        try {
            try {
                Connection conn = Conexion.GetConnection();
                st = conn.createStatement();
                pedidos = st.executeQuery("SELECT id_pedido, total_pedido, nombre_cliente, fecha_pedido "
                        + "FROM pedidos JOIN clientes ON id_clienteFK=id_cliente");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            tabProds.setModel(new DefaultTableModel(null,columns2));
            sumt=0;
            for(int i=0; i<tabProds.getRowCount();i++){
                sumt+=Double.parseDouble(tabProds.getValueAt(i, 7)+"");
            }
            lbltotal.setText("$"+sumt);
            while(pedidos.next()){
                String [] row = {pedidos.getString(1),pedidos.getString(2),pedidos.getString(3),pedidos.getTimestamp(4)+""};
                tm.addRow(row);
            }
            
            tabPedidos.setModel(tm);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonRefreshMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCommit;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tabPedidos;
    private javax.swing.JTable tabProds;
    // End of variables declaration//GEN-END:variables
}
