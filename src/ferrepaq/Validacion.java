/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Panke
 * Comentarios locos para el commit
 */


public class Validacion extends JPanel{
    public Validacion(){}
    public void SoloLetras(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isLetter(c) && !Character.isSpaceChar(c)){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    public void SoloNumeros(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c) && c!='.'){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    public void LetrasYNums(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isLetterOrDigit(c)){
                    getToolkit().beep();
                    e.consume();
                }
            }

           
        });
    }
}
