/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Omar Benitez
 */
public class LoginPane {
    
    private JPasswordField pass = new JPasswordField(10);
    private JTextField usr = new JTextField(10);
    private int option;
    public LoginPane(){
        JPanel panel = new JPanel();
        JLabel lblps= new JLabel("Contraseña:"), lblus = new JLabel("Usuario:");
        
        usr.addKeyListener(new KeyAdapter()
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
        
        pass.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char caracter = e.getKeyChar();
                if(((caracter < '0') ||
                        (caracter > '9')) &&
                        (caracter != KeyEvent.VK_BACK_SPACE))
                {
                    e.consume();
                }
            }
        });
        
        
        
        panel.add(lblus);
        panel.add(usr);
        panel.add(lblps);
        panel.add(pass);
        
        
        String[] options = new String[]{"Cancelar", "OK"};
        option = JOptionPane.showOptionDialog(null, panel, "Ingrese su Id y su Contraseña",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
    }

    public String getPassword(){
        return pass.getText();
    }
    
    public String getUser(){
        return usr.getText();
    }
    
    public boolean getOption(){
        if(option == 1)
            return true;
        else
            return false;
    }
}
