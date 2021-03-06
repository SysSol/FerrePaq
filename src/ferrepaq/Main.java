/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.*;

/**
 *
 * @author omar
 */
public class Main extends javax.swing.JFrame {
    
    Statement st;
    ResultSet prods;
    double sumt=0;
    Dimension si = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().width/3,(int)Toolkit.getDefaultToolkit().getScreenSize().height);
    
    public Main() {
        try {
            
            
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                prods = st.executeQuery("SELECT * FROM productos");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getErrorCode() + ": " + ex.getMessage());
            }
            
            
            
            
            initComponents();
            String [] columns = {"Id","Clave","Tipo","Marca","Precio","Cantidad"};
            String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Subtotal"};
            
            
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            lbltotal.setText("$0.0");
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
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            lbltotal = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            btnSave = new javax.swing.JButton();
            btnRollBack = new javax.swing.JButton();
            btnToAdmin = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);
            addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    formKeyPressed(evt);
                }
            });

            jLabel2.setText("Filtrar:");

            searchText.setNextFocusableComponent(Tab);
            searchText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    searchTextKeyReleased(evt);
                }
            });
            searchText.addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyTyped(KeyEvent e)
                    {
                        char caracter = e.getKeyChar();
                        if( caracter < 'A' || caracter >'Z')
                        if( caracter < 'a' || caracter > 'z' )
                        if( caracter < '0' || caracter > '9'  )
                        {
                            e.consume();
                        }
                    }
                });

                jScrollPane1.setNextFocusableComponent(jScrollPane2);

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
                Tab.setNextFocusableComponent(Tab1);
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

                btnSave.setText("Finalizar Venta");
                btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnSaveMouseClicked(evt);
                    }
                });

                btnRollBack.setText("Cancelar");
                btnRollBack.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnRollBackMouseClicked(evt);
                    }
                });

                btnToAdmin.setText("Ingresar Como Administrador");
                btnToAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnToAdminMouseClicked(evt);
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
                                .addComponent(btnToAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRollBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave)))
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnRollBack)
                            .addComponent(btnToAdmin))
                        .addContainerGap())
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents
    
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
                        int stock = Integer.parseInt(Tab1.getValueAt(row, 5)+"");
                        if(cant <= stock){
                            double subt;
                            subt=cant*Double.parseDouble((String)Tab1.getValueAt(row, 4));
                            subt=Math.floor(subt*100)/100;
                            sumt+=subt;
                            Tab1.setValueAt(subt+"",row, 6);
                            Tab1.setValueAt(""+cant, row, 5);
                            sumt=Math.floor(sumt*100)/100;
                            lbltotal.setText("$"+sumt);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se puede vender este producto por que no hay productos en existencia");
                        }
                        
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
                int pass =Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese su contraseña"));
                ResultSet r = st.executeQuery("SELECT * FROM empleados WHERE password = \""+pass+"\"");
                if(r.first()){
                    id_emp = r.getInt(1);
                    st.execute("INSERT INTO `ferrepaq`.`ventas` (`id_venta`, `id_empleadoFK`, `total_venta`, `fecha_venta`) VALUES (NULL, '"+id_emp+"' , '"+sumt+"', CURRENT_TIMESTAMP);");
                    r = st.executeQuery("SELECT * from ventas ORDER BY id_venta DESC");
                    r.first();
                    for(int i=0; i<n ;i++){
                        int id_venta = r.getInt(1);
                        int id_prod = Integer.parseInt((String)Tab1.getValueAt(i, 0));
                        int cant = Integer.parseInt((String)Tab1.getValueAt(i, 5));
                        
                        System.out.println("INSERT INTO `ferrepaq`.`produtos_ventas` (`id_productosFK`, `id_ventasFK`, `cantidad`) VALUES ('"+id_prod+"', '"+id_venta+"', '"+cant+"');");
                        st.execute("INSERT INTO `ferrepaq`.`produtos_ventas` (`id_productosFK`, `id_ventasFK`, `cantidad`) VALUES ('"+id_prod+"', '"+id_venta+"', '"+cant+"');");
                        
                        System.out.println("UPDATE  `ferrepaq`.`productos` SET  `cantidad` = `cantidad` - "+cant+" WHERE  `productos`.`id_producto` = "+id_prod+";");
                        st.execute("UPDATE  `ferrepaq`.`productos` SET  `cantidad` = `cantidad` - "+cant+" WHERE  `productos`.`id_producto` = "+id_prod+";");
                        btnRollBackMouseClicked(evt);
                    }
                }
            } catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Usuario no encontrado, verifique su contraseña");
            }
            
            
        }
        
    }//GEN-LAST:event_btnSaveMouseClicked
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode()==113){
            JOptionPane.showMessageDialog(this, "Espere porvafor...");
            FormAdministrador fm = new FormAdministrador();
            fm.setVisible(true);
        }
    }//GEN-LAST:event_formKeyPressed
    
    private void btnToAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToAdminMouseClicked
        LoginPane lp = new LoginPane();
        boolean option=lp.getOption();
        String password=lp.getPassword();
        String user=lp.getUser();
        if(option) // pressing OK button
        {
            try {
                ResultSet rs = st.executeQuery(
                        "SELECT * \n" +
                        "FROM empleados\n" +
                        "WHERE UPPER( alias ) = UPPER(  \""+user+"\" ) \n" +
                        "AND PASSWORD ="+password);
                
                if(rs.first()){
                    if(rs.getInt(4)==1){
                        JOptionPane.showMessageDialog(this, "Abriendo ventana...");
                        FormAdministrador fm = new FormAdministrador();
                        fm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,"No tienes los permisos necesarios");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this,"Usuario o contraseña inválidos");
                }
            } catch(Exception e){
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_btnToAdminMouseClicked
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab;
    private javax.swing.JTable Tab1;
    private javax.swing.JButton btnRollBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnToAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
