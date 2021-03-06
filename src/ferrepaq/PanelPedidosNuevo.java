/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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
    double sumt=0,desct=0;    
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
                jLabel7 = new javax.swing.JLabel();
                txtDesc = new javax.swing.JTextField();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                lbldesc = new javax.swing.JLabel();
                btnDescuento = new javax.swing.JButton();

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

                lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

                jLabel1.setText("Neto:");

                btnRollBack.setText("Cancelar");
                btnRollBack.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnRollBackMouseClicked(evt);
                    }
                });

                btnSave.setText("Fnalizar Pedidos");
                btnSave.setEnabled(false);
                btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnSaveMouseClicked(evt);
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

                jLabel7.setText("Descuento: ");

                txtDesc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                txtDesc.setText("0");
                txtDesc.setEnabled(false);
                txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        txtDescKeyTyped(evt);
                    }
                });

                jLabel8.setText("%");

                jLabel9.setText("Total:");

                lbldesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

                btnDescuento.setText("Aplicar");
                btnDescuento.setEnabled(false);
                btnDescuento.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        btnDescuentoMousePressed(evt);
                    }
                });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(549, 549, 549)
                                        .addComponent(btnRollBack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDescuento)
                                                .addGap(98, 98, 98)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbldesc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(lbldesc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDescuento))
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
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
        if(sumt>0 && desct>0){
            int n = Tab1.getRowCount();
            try {
                int id_emp;
                
                int pass = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese su contraseña"));
                ResultSet r = st.executeQuery("SELECT * FROM empleados WHERE password = "+pass+"");
                
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
            txtDesc.setEnabled(true);
            btnDescuento.setEnabled(true);
        }
        
    }//GEN-LAST:event_Tab2MouseClicked
        
    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
            evt.consume();
        
    }//GEN-LAST:event_txtDescKeyTyped

    private void btnDescuentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescuentoMousePressed
        
        int descuento=0;
        if(!txtDesc.getText().equals("")){
            
            descuento = Integer.parseInt(txtDesc.getText());
        } else {
            txtDesc.setText("0");
        }
        desct=sumt-sumt*(Double.parseDouble(""+descuento)/100);
        lbldesc.setText("$"+desct);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnDescuentoMousePressed
    
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
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
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
    private javax.swing.JButton btnDescuento;
    private javax.swing.JButton btnRollBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lbldesc;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField searchText1;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
