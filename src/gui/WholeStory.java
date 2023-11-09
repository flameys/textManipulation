package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WholeStory implements ActionListener {
    static String pathname;
    JLabel l;
    JTextField f;

    JFrame frame = new JFrame();
    JButton submit = new JButton("Submit");

    JPanel left;
    JPanel right;


    public WholeStory(String pname) {
        pathname = pname;

        submit.setPreferredSize(new Dimension(80, 25));
        submit.addActionListener(this);
        submit.setFocusable(false);


        frame.setSize(375, 375);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        left = new JPanel();
        left.setPreferredSize(new Dimension(150, 340));
        left.setBackground(Color.white);
        frame.add(left);

        right = new JPanel();
        right.setBackground(Color.white);
        right.setPreferredSize(new Dimension(208, 340));
        frame.add(right);

        ImageIcon logo1 = new ImageIcon("icon_frame1.jpg");
        frame.setIconImage(logo1.getImage());
        frame.setLocationRelativeTo(null);
        frame.setTitle("Formulier");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        readFile(pname);

    } //End of constructor

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit){
            frame.dispose();
            DisplayTxt gui = new DisplayTxt(arrayInputs);

            }

    }
    public ArrayList<JTextField> arrayInputs  = new ArrayList<JTextField>();

    //to read inhoud van geselecteerde file
    public void readFile(String filePath) {
        String lijn;

        Pattern pattern = Pattern.compile("\\{{2}([a-zA-Z0-9_+.-]+)\\}{2}");

        File getSelectedFile = new File(filePath);
        try {

            BufferedReader readText = new BufferedReader(new FileReader(getSelectedFile));

            while ((lijn = readText.readLine()) != null) {
                String result;

                Matcher searchPattern = pattern.matcher(lijn);
                if (searchPattern.find()) {

                    String[] all = {searchPattern.group(1)};
                    for (String x : all) {
                        result = " Noem een " + x + " op:";
                        l = new JLabel(result);
                        l.setLayout(new BoxLayout(l, BoxLayout.Y_AXIS));
                        l.setPreferredSize(new Dimension(150, 20));
                        left.add(l);

                        f = new JTextField("");
                        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
                        f.setPreferredSize(new Dimension(155, 20));
                        arrayInputs.add(f);
                        right.add(f);
                        right.add(submit);

                    }
                    /*result = "Noem een " + searchPattern.group(1) + " op:" + "\n";
                    System.out.println(result);*/

                }

            }
            readText.close();
            //System.out.println(collect);
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    } //End of method readFile



} // End of class

//----------------------------------------------------------------------------------------------------------------------

// EIGEN AANTEKENINGEN
    /*public void createTextField(int[] columns){

        for(int i: columns){
            JTextField totalColumns = new JTextField(i);
            totalColumns.setSize(200,340);
            //totalColumns.setText("\n");
            //paneTextField.add(totalColumns, BoxLayout.Y_AXIS);
            paneTextField.add(totalColumns);
        }
    }*/

//int data = readText.read();
                    /* while (data != -1) {
                        System.out.println((char) data);
                        data = readText.read();
                    }*/ //to read one single character (of every word), not a whole line
//output of this code: alle letters van gehele text komen onder elkaar te liggen
