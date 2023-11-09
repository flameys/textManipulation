package gui;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayTxt extends JFrame {

    ArrayList<JTextField> getInputFields;
    JTextArea storyGui = new JTextArea();


    JScrollPane visible;


    public DisplayTxt(ArrayList<JTextField> fields ) {
        this.getInputFields = fields;
        String result = readFile(WholeStory.pathname);

        Pattern pattern = Pattern.compile("\\{{2}([a-zA-Z0-9_+.-]+)\\}{2}");
        Matcher searchPatternInTxt = pattern.matcher(result);


        // method 1
        /*for (int i = 0; i < fields.size(); i++) {
            JTextField t = fields.get(i);
            String inputT = t.getText();


            if (searchPatternInTxt.find()) {
                String[] L = {searchPatternInTxt.group(1)};
                for (String y : L) {
                    String rplcY = y.replace(y, inputT);
                    String replacements = searchPatternInTxt.replaceAll(rplcY);
                    storyGui.append("" + replacements + "\n");
                }
            }
        }*/

        //method 2
        for (int i = 0; i < fields.size(); i++) {
            JTextField t = fields.get(i);
            String inputT = t.getText();
            String rplcIt = result.replaceAll("\\{{2}([a-zA-Z0-9_+.-]+)\\}{2}", inputT);
            storyGui.append("" + rplcIt +"\n");
        }



            storyGui.setBounds(0, 0, 375, 375);
            storyGui.setEditable(false);

            this.setSize(375, 375);

            this.setLayout(new FlowLayout());
            visible = new JScrollPane(storyGui);
            visible.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            this.setLocationRelativeTo(null);
            ImageIcon logo2 = new ImageIcon("icon_frame1.jpg");
            this.setIconImage(logo2.getImage());
            //this.setResizable(false);
            this.setTitle("This is a story about... ");
            //this.add(storyGui);
            this.add(visible);

            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } //End of constructor




    public String readFile(String fileName){
        String s1 = "";
        String s2 = "";

        File getSelectedFile = new File(fileName);


        try {
            BufferedReader read = new BufferedReader(new BufferedReader(new FileReader(getSelectedFile)));
            while ((s1 = read.readLine()) != null){
                s2 += s1 + "\n";

            }
            //storyGui.setText(s2);
            read.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s2;

    } //end of method readFile



} //End of class

/* ----------------------EIGEN AANTEKENINGEN-----------------------
int[] totalMatches = {searchPatternInTxt.groupCount()};
        int a = searchPatternInTxt.groupCount();
        long total = searchPatternInTxt.results().count();
int u = 0;
        while (searchPatternInTxt.find(u)) {
                u = searchPatternInTxt.start() + 1;

                int i = 0;
                while (i < fields.size()) {
        while (a <= i) {
        JTextField t = fields.get(i);
        String inputT = t.getText();
        String rplcM = result.replaceAll(searchPatternInTxt.group(a), inputT);
        storyGui.append("" + rplcM + "\n");
        a++;
        }
        i++;
        }

        }System.out.println("Totale matches"+total);



 */

 /*int u = 0;
        while (searchPatternInTxt.find(u)) {
            u = searchPatternInTxt.start() + 1;
            for (int a : totalMatches) {
                for (int i = 0; i < fields.size(); i++) {
                    JTextField t = fields.get(i);
                    String inputT = t.getText();
                    String rplcM = result.replaceAll(searchPatternInTxt.group(a), inputT);
                    storyGui.append("" + rplcM + "\n");
                }
            }
        }*/


/*for (int i = 0; i < fields.size(); i++) {
            JTextField t = fields.get(i);
            String inputT = t.getText();
            int u = 0;
            while (searchPatternInTxt.find(u)){
                 u = searchPatternInTxt.start() + 1;
                 for(int a : totalMatches){
                     String rplcM = result.replaceAll(searchPatternInTxt.group(a), inputT);
                     storyGui.append("" + rplcM +"\n");
                 }
            }
        }*/

//1e manier van method 2 in constructor
/*if (searchPatternInTxt.find()) {
                String[] allPatterns = {searchPatternInTxt.group(1)};
                for (String y : allPatterns) {
                    for (JTextField g: fields){
                        String p = g.getText();
                        String rpl = y.replace(y,p);
                        String allReplace = searchPatternInTxt.replaceAll(rpl);
                        storyGui.append(" " + allReplace + "\n");
                    }

                }
            }*/