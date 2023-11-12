
package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class About extends JFrame implements ActionListener{
    JButton b1;
    About(){
        
        setBounds(400,100,600,500);
        setTitle("About");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("notepad/icons/krish_img.jpg"));
        Image i2= i1.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel headerIcon = new JLabel(i3);
        add(headerIcon);
        
        headerIcon.setBounds(200,0,400,600);
        
        JLabel text = new JLabel("MY Notepad");
        text.setBounds(300,400 , 100, 30);
        add(text);
        
        
        b1= new JButton("ok");
        b1.setBounds(400,400,120,25);
        b1.addActionListener(this);
        add(b1);
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent  ae){
        this.setVisible(false);
        
        
    }
    
    public static void main(String[] args){
        new About();
    }
}