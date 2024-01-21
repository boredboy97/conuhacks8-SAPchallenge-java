import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GUI implements ActionListener {
    private JButton button1, button2, button3, button4;
    private JLabel label1, label2, label3, label4, toplabel;
    private JFrame jframe;
    private JPanel panel;
    int count = 0;

public GUI() {
     jframe = new JFrame("GUI Screen");   //create JFrame object
     jframe.getContentPane().setBackground(Color.BLACK);
     
     button1 = new JButton("Total Revenue Generated");
     button2 = new JButton("Possible Revenue Missed");
     button3 = new JButton("Number of Customers Served");
     button4 = new JButton("Number of Customers Declined");  //create JButton objec
     button1.addActionListener(this);
     button2.addActionListener(this);
     button3.addActionListener(this);
     button4.addActionListener(this);

     Border border = BorderFactory.createLineBorder(Color.WHITE, 50);
     
     button1.setBorder(new LineBorder(Color.CYAN,1));
     button2.setBorder(new LineBorder(Color.BLUE,1));
     button3.setBorder(new LineBorder(Color.ORANGE,1));
     button4.setBorder(new LineBorder(Color.RED,1));

     button1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
     button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
     button3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
     button4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

     /*button1.setSize(1000, 900);
     button2.setSize(1000, 900);
     button3.setSize(1000, 900);
     button4.setSize(1000, 900);*/
     
     button1.setForeground(new Color(0,0,0));
     button2.setForeground(new Color(0,0,0));
     button3.setForeground(new Color(0,0,0));
     button4.setForeground(new Color(0,0,0));

     button1.setBackground(Color.WHITE);
     button2.setBackground(Color.WHITE);
     button3.setBackground(Color.WHITE);
     button4.setBackground(Color.WHITE);

     panel = new JPanel();
     label1 = new JLabel();
     label2 = new JLabel();
     label3 = new JLabel();
     label4 = new JLabel();
     toplabel = new JLabel();
    
     label1.setForeground(Color.WHITE);;
     label2.setForeground(Color.WHITE);
     label3.setForeground(Color.WHITE);
     label4.setForeground(Color.WHITE);

     
     toplabel.setBorder(border);
    
     panel = new JPanel();
     panel.setBackground(new Color(100,100,100));
     panel.setBorder(BorderFactory.createEmptyBorder(250, 300, 250, 300));
     panel.setLayout(new GridLayout(2, 10));

     panel.add(button1);
     panel.add(button2);
     panel.add(button3);
     panel.add(button4);

     panel.add(label1);
     panel.add(label2);
     panel.add(label3);
     panel.add(label4);
     
     jframe.setPreferredSize(new Dimension(1920,1080));
     jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //jframe.setSize(1920,1080);         //set size of GUI screen
     jframe.setVisible(true);
     jframe.pack();
     jframe.setTitle("SAP");
     jframe.add(panel, BorderLayout.CENTER);


}  
    
public static void main(String[] args) {
    new GUI();
}

public void actionPerformed(ActionEvent e) {
    count++;
    JButton actionSource = (JButton) e.getSource();
    Border border = BorderFactory.createLineBorder(Color.WHITE, 10);
    
    
    if(actionSource.equals(button1)) {
        label1.setText("Total Revenue ($)");
    }
        
    else if(actionSource.equals(button2)) {
        label2.setText("Possible Revenue ($)");
    }
    else if(actionSource.equals(button3)) {
        label3.setText("Served");
    }
    else if(actionSource.equals(button4)) {
        label4.setText("Missed");
    }
}
}


