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
public class PanelPedidosNuevo extends javax.swing.JFrame {

    /**
     * Creates new form FormPedidosNuevo
     */
    
    Statement st,st1;
    ResultSet prods,client;
    double sumt=0;
    Dimension si = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().width/3,(int)Toolkit.getDefaultToolkit().getScreenSize().height);
    
    public PanelPedidosNuevo() {
        try {
            
            
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                st1 = conn.createStatement();
                prods = st.executeQuery("SELECT * FROM productos");
                client = st1.executeQuery("SELECT * FROM clientes");
               
               
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }
            
            
            
            
            initComponents();
            String [] columns = {"Id","Clave","Tipo","Marca","Precio","Cantidad"};
            String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Subtotal"};
            String [] columns3 = {"Id","Nombre","Telefono","Direccion","Telefono Alt."};
            
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            DefaultTableModel tm1 = new DefaultTableModel(null,columns3);
            lbltotal.setText("$0.0");
            
            Tab1.setModel(new DefaultTableModel(null,columns2));

                    
            while(prods.next()){
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4),prods.getString(5),prods.getString(6)};
                tm.addRow(row);
            }
            
            while(client.next()){
                String [] row1 = {client.getString(1),client.getString(2),client.getString(3),client.getString(4),client.getString(5)};
                
                tm1.addRow(row1);
            }
            
            Tab.setModel(tm);
            Tab2.setModel(tm1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
    }

    public void fillClients(){
        
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
            lbltotal = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            btnRollBack = new javax.swing.JButton();
            btnSave = new javax.swing.JButton();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            searchText1 = new javax.swing.JTextField();
            jScrollPane3 = new javax.swing.JScrollPane();
            Tab2 = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }}
                ;
                jLabel5 = new javax.swing.JLabel();
                lblCliente = new javax.swing.JLabel();
                lblID = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();

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

                btnRollBack.setText("Cancelar");
                btnRollBack.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnRollBackMouseClicked(evt);
                    }
                });

                btnSave.setText("Fnalizar Venta");
                btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnSaveMouseClicked(evt);
                    }
                });
                btnSave.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSaveActionPerformed(evt);
                    }
                });

                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/switch.png"))); // NOI18N

                jLabel4.setText("Filtrar:");

                searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        searchText1KeyReleased(evt);
                    }
                });

                Tab2.setModel(new javax.swing.table.DefaultTableModel(
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
                Tab2.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        Tab2MouseClicked(evt);
                    }
                });
                jScrollPane3.setViewportView(Tab2);

                jLabel5.setText("Cliente:");

                jLabel6.setText("ID:");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(btnRollBack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnRollBack))
                        .addContainerGap())
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        String where = searchText.getText();
        String [] columns = {"Id","Clave","Tipo","Marca","Precio","Cantidad"};
        try {
            if("".equals(where)){
                prods = st.executeQuery("SELECT * FROM productos");
            }
            else{
                prods = st.executeQuery("SELECT * FROM productos WHERE clave LIKE \"%"+where+"%\"");
            }
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            while(prods.next()){
                boolean ban=true;
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4),prods.getString(5),prods.getString(6)};
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

        DefaultTableModel tm = (DefaultTableModel) Tab.getModel();
        DefaultTableModel tm1 = (DefaultTableModel) Tab1.getModel();
        int row = Tab.getSelectedRow();
        if(!"0".equals((String)Tab.getValueAt(row,5))){
            String cant = JOptionPane.showInputDialog("Ingrese la cantidad del producto \n"+(String)Tab.getValueAt(row, 1));
            double subt =Double.parseDouble(cant) * Double.parseDouble((String)Tab.getValueAt(row, 4));
            sumt+=subt;
            subt=Math.floor(subt*100)/100;
            sumt=Math.floor(sumt*100)/100;
            lbltotal.setText("$"+sumt);
            String [] newRow = {
                (String)Tab.getValueAt(row, 0),
                (String)Tab.getValueAt(row, 1),
                (String)Tab.getValueAt(row, 2),
                (String)Tab.getValueAt(row, 3),
                (String)Tab.getValueAt(row, 4),
                cant,
                ""+subt
            };
            tm1.addRow(newRow);
            tm.removeRow(Tab.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "No se puede vender este producto por que no hay productos en existencia");
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
                //huehue
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

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(sumt>0){
            int n = Tab1.getRowCount();
            try {
                int id_emp;
                
                int pass = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese su contraseña"));
                ResultSet r = st.executeQuery("SELECT * FROM empleados WHERE password = \""+pass+"\"");
                
                if(r.first()){
                    if(!" ".equals(lblID.getText()));{
                        id_emp = r.getInt(1);
                        int id_cli = Integer.parseInt(lblID.getText());
                        double total = sumt;
                        st.execute("INSERT INTO `ferrepaq`.`pedidos` (`id_pedido`, `total_pedido`, `id_empleadoFK`, `id_clienteFK`) VALUES (NULL, '"+total+"' , '"+id_emp+"','"+id_cli+"');");        
                        r = st.executeQuery("SELECT * from pedidos ORDER BY id_pedido DESC");
                        r.first();
                        int id_pedido = r.getInt(1);
                        for(int i=0; i<n ;i++){
                            
                            int id_prod = Integer.parseInt((String)Tab1.getValueAt(i, 0));
                            int cant = Integer.parseInt((String)Tab1.getValueAt(i, 5));

                            System.out.println("INSERT INTO `ferrepaq`.`produtos_pedidos` (`id_productosFK`, `id_pedidosFK`, `cantidad`) VALUES ('"+id_prod+"', '"+id_pedido+"', '"+cant+"');");
                            st.execute("INSERT INTO `ferrepaq`.`produtos_pedidos` (`id_productosFK`, `id_pedidosFK`, `cantidad`) VALUES ('"+id_prod+"', '"+id_pedido+"', '"+cant+"');");

                            System.out.println("UPDATE  `ferrepaq`.`productos` SET  `cantidad` = `cantidad` - "+cant+" WHERE  `productos`.`id_producto` = "+id_prod+";");
                            st.execute("UPDATE  `ferrepaq`.`productos` SET  `cantidad` = `cantidad` - "+cant+" WHERE  `productos`.`id_producto` = "+id_prod+";");
                        }
                    }
                    
                }
            } catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Usuario no encontrado, verifique su contraseña");
            }

        }

    }//GEN-LAST:event_btnSaveMouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        
        String where = searchText1.getText();
        String [] columns = {"Id","Nombre","Telefono","Direccion","Telefono Alt."};
        try {
            if(" ".equals(where)){
                client = st.executeQuery("SELECT * FROM clientes");
            }
            else{
                client = st.executeQuery("SELECT * FROM clientes WHERE nombre_cliente LIKE \"%"+where+"%\"");
            }
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            while(client.next()){
                boolean ban=true;
                String [] row = {client.getString(1),client.getString(2),client.getString(3),client.getString(4),client.getString(5)};
                int n=Tab2.getRowCount();
                for(int i=0;i<n;i++){
                    if(client.getString(1).equals(Tab2.getValueAt(i, 1)))
                    ban=false;
                    System.out.println(i+": "+client.getString(1)+" <-> "+Tab2.getValueAt(i, 1)+ "  ::=="+client.getString(1).equals((String)Tab2.getValueAt(i, 1)));
                }
                if(ban)
                tm.addRow(row);
            }

            Tab2.setModel(tm);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchText1KeyReleased

    private void Tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab2MouseClicked
        // TODO add your handling code here:
        int row = Tab2.getSelectedRow();
        
        if(!"".equals((String)Tab2.getValueAt(row,1))){
            String nombre = ((String)Tab2.getValueAt(row,1));
            String id = ((String)Tab2.getValueAt(row,0));
            lblCliente.setText(nombre);
            lblID.setText(id);
        }
        
    }//GEN-LAST:event_Tab2MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(PanelPedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPedidosNuevo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab;
    private javax.swing.JTable Tab1;
    private javax.swing.JTable Tab2;
    private javax.swing.JButton btnRollBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField searchText1;
    // End of variables declaration//GEN-END:variables
}
