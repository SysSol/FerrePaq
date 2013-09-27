/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author omar
 */
public class Main extends javax.swing.JFrame {

    Statement st;
    ResultSet prods;
    
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
            String [] columns = {"Id","Clave","Tipo","Marca","Precio"};
            String [] columns2 = {"Id","Clave","Tipo","Marca","Precio","Cantidad","Subtotal"};
            
            
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
            
            Tab1.setModel(new DefaultTableModel(null,columns2));
            
            while(prods.next()){
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4),prods.getString(5)};
                tm.addRow(row);
            }
            
            Tab.setModel(tm);
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
                    if(vColIndex==5)
                    return true;
                    return false;
                }
            };

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel2.setText("Filtrar:");

            searchText.setNextFocusableComponent(Tab);
            searchText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    searchTextKeyReleased(evt);
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(323, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMouseClicked
        
        DefaultTableModel tm = (DefaultTableModel) Tab.getModel();
        DefaultTableModel tm1 = (DefaultTableModel) Tab1.getModel();
        int row = Tab.getSelectedRow();
        String cant = JOptionPane.showInputDialog("Ingrese la cantidad del producto \n"+(String)Tab.getValueAt(row, 1));
        double subt = Double.parseDouble(cant) * Double.parseDouble((String)Tab.getValueAt(row, 4));
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
        
        
    }//GEN-LAST:event_TabMouseClicked

    private void Tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab1MouseClicked
        if(Tab1.getSelectedColumn()!=5){
            DefaultTableModel tm = (DefaultTableModel) Tab.getModel();
            DefaultTableModel tm1 = (DefaultTableModel) Tab1.getModel();
                int row = Tab1.getSelectedRow();
            String [] newRow = {
                (String)Tab1.getValueAt(row, 0),
                (String)Tab1.getValueAt(row, 1),
                (String)Tab1.getValueAt(row, 2),
                (String)Tab1.getValueAt(row, 3),
                (String)Tab1.getValueAt(row, 4),        
            };
            tm.addRow(newRow);
            tm1.removeRow(Tab1.getSelectedRow()); 
            //falta poner para que se actualice el subtotal de la fila
            
        }
    }//GEN-LAST:event_Tab1MouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        String where = searchText.getText();
        String [] columns = {"Id","Clave","Tipo","Marca","Precio"};
        try {
            if("".equals(where))
                prods = st.executeQuery("SELECT * FROM productos");
            else
                prods = st.executeQuery("SELECT * FROM productos WHERE clave LIKE \""+where+"%\" ");
            DefaultTableModel tm =  new DefaultTableModel(null,columns);
                      
            while(prods.next()){
                boolean ban=true; 
                String [] row = {prods.getString(1),prods.getString(2),prods.getString(3),prods.getString(4),prods.getString(5)};
                int n=Tab1.getRowCount();
                for(int i=0;i<n;i++){                    
                    if(prods.getString(1).equals(Tab1.getValueAt(i, 0)))
                       ban=false;
                    System.out.println(i+": "+prods.getString(1)+" <-> "+Tab1.getValueAt(i, 0)+ "  ::=="+prods.getString(1).equals((String)Tab1.getValueAt(i, 1)));
                }
                if(ban)
                    tm.addRow(row);    
                System.err.println(".");
            }
            
            Tab.setModel(tm);
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_searchTextKeyReleased

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab;
    private javax.swing.JTable Tab1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
