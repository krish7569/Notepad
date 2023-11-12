package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.filechooser.*;
import java.io.*;




public class Notepad extends JFrame implements ActionListener {

    JTextArea area;
    String text;
    Notepad(){
       
       setTitle("NOTEPAD  by me");  
      //setExtendedState(MAXIMIZED_BOTH-200);
      setSize(500,700);

      
      //ImageIcon notepadIcon =new ImageIcon("C:\\Users\\ragha\\OneDrive\\Documents\\NetBeansProjects\\notepad\\src\\notepad\\icons\\cartoon-boy-images-8.jpg");
      ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/krish_img.jpg"));
      Image icon=notepadIcon.getImage();
      setIconImage(icon);
      
      
      JMenuBar  menubar = new JMenuBar();
      menubar.setBackground(Color.red);
      
      JMenu file=new JMenu( "File");
      //file.setFont(new Font( name : "AERIAL", style: Font.PLAIN ,14));
      file.setFont(new Font("AERIAL", Font.PLAIN,16));
      
      JMenuItem newdoc = new JMenuItem("New");
      newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
      newdoc.addActionListener(this);
      //newdoc.setFont(new Font("AERIAL", Font.PLAIN,20));
      //newdoc.setSize(10,10);
      //file.add(newdoc);
      
      JMenuItem open = new JMenuItem("open");
      open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
      open.addActionListener(this);
      //newdoc.setFont(new Font("AERIAL", Font.PLAIN,20));
      //newdoc.setSize(10,10);
      
      JMenuItem save = new JMenuItem("save");
      save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
      save.addActionListener(this);
      
      
      JMenuItem print = new JMenuItem("print");
      print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
      print.addActionListener(this);
      
      JMenuItem exit = new JMenuItem("Exit");
      exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK));
      exit.addActionListener(this);
      
      file.add(newdoc);
      file.add(open);
      file.add(save);
      file.add(print);
      file.add(exit);
      
      
      JMenu edit=new JMenu( "EDIT");
      //file.setFont(new Font( name : "AERIAL", style: Font.PLAIN ,14));
      edit.setFont(new Font("AERIAL", Font.PLAIN,16));
      
      JMenuItem copy = new JMenuItem("copy");
      copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
      copy.addActionListener(this);
      //newdoc.setFont(new Font("AERIAL", Font.PLAIN,20));
      //newdoc.setSize(10,10);
      //file.add(newdoc);
      
      JMenuItem paste = new JMenuItem("paste");
      paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
      paste.addActionListener(this);
      //newdoc.setFont(new Font("AERIAL", Font.PLAIN,20));
      //newdoc.setSize(10,10);
      
      JMenuItem cut = new JMenuItem("cut");
      cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
      cut.addActionListener(this);
      
      JMenuItem select_all = new JMenuItem("Select all");
      select_all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
      select_all.addActionListener(this);
      
      edit.add(copy);
      edit.add(paste);
      edit.add(cut);
      edit.add(select_all);
      
 
      JMenu helpmenu = new JMenu("Help");
      helpmenu.setFont(new Font("AERIAL",Font.PLAIN,15));
      
      JMenuItem  help=new JMenuItem("About");
      help.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
      help.addActionListener(this);
      
      
      helpmenu.add(help);
      
      
      
     
      
      
      
      
      menubar.add(file);
      menubar.add(edit);
      menubar.add(helpmenu);
      
      setJMenuBar(menubar);
      
      
      area = new JTextArea();
      area.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
      area.setWrapStyleWord(true);
      
      //add(area);
      
      JScrollPane pane = new JScrollPane(area);
      pane.setBorder(BorderFactory.createEmptyBorder());
      add(pane);
      
      
      
      
      
      
      
      
      
      
        
      setVisible(true);  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("New")){
      
        area.setText("");
        
        }
        
        else if(ae.getActionCommand().equals("open")){
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("only.txt files","txt");
            chooser.addChoosableFileFilter(restrict);
            
            
            int action = chooser.showOpenDialog(this);
            
            
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader= new BufferedReader(new FileReader(file));
                area.read(reader, null);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }
        
       
        
        else if(ae.getActionCommand().equals("save")){
           JFileChooser saveas = new JFileChooser();
           saveas.setApproveButtonText("Save");
            
            
            //JFileChooser chooser = new JFileChooser(); // sets up the file choosing dialog. ok
            //int option = chooser.showSaveDialog(this);
           int action = saveas.showSaveDialog(this);
            
             if(action != JFileChooser.APPROVE_OPTION){
                 return;
             }
             
            
            
            File filename = new File(saveas.getSelectedFile()+ ".txt");
            
            BufferedWriter outFile=null;
            
            try {
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
            }catch(Exception e){
                e.printStackTrace();
            }     
            
        }
        
        
        else if(ae.getActionCommand().equals("print")){
            try{
                area.print();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
            
        }
        
        else if(ae.getActionCommand().equals("copy")){
           text=  area.getSelectedText();
            
        }
        
        else if(ae.getActionCommand().equals("paste")){
            area.insert(text, area.getCaretPosition());
            
        }
        
        else if(ae.getActionCommand().equals("cut")){
           text=  area.getSelectedText();
           area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
            
        }
        
        else if(ae.getActionCommand().equals("Select all")){
           
            area.selectAll();
        }
        
        else if(ae.getActionCommand().equals("About")){
            
            new About().setVisible(true);
            
        }
        
        
        
        
       
       
    }
    public static void main(String[] args) {
        new Notepad();
        
    }
    
}