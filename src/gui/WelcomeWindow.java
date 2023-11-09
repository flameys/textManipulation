package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WelcomeWindow implements ActionListener {
    JButton klik;
    JFrame frame1 = new JFrame();
    JLabel background;

    public WelcomeWindow(){
        klik = new JButton("Select File");
        klik.setBounds(132,200,95,30);
        klik.addActionListener(this);
        klik.setFocusable(false); //textbox rondom text weghalen
        //klik.setForeground(new Color());
        //klik.setBackground(new Color());

        frame1.setSize(375,375);
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        frame1.setTitle("Dynamic text manipulation tool");
        frame1.getContentPane().setBackground(new Color(80,175,120 ));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(klik);
        frame1.setVisible(true);

        ImageIcon logo = new ImageIcon("icon_frame1.jpg" );
        frame1.setIconImage(logo.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == klik){
            frame1.dispose();
            JFileChooser search = new JFileChooser();
            int returnVal = search.showOpenDialog(frame1);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = search.getSelectedFile(); //store the selected file in a File object
                String pname = file.getAbsolutePath(); //pathname of the selected file object
                WholeStory new_window = new WholeStory(pname);
                //System.out.println(file); //to print out pathname of selected file
                /*try {
                    BufferedReader readText = new BufferedReader(new FileReader(file));
                    String lijn;
                    while ((lijn = readText.readLine()) != null){
                        System.out.println(lijn);
                    }
                    readText.close();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }*/
            }
        }

    }
}
