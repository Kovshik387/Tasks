package Labs.JForm;

import Labs.Task3.Task;
import Labs.Task4.Task22;
import Labs.Task4.Task31;
import Labs.Utility.FileStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Labs.Task3.Task.printArray;
import static Labs.Utility.FileStream.convertToInt;
import static Labs.Utility.FileStream.writeArray;


public class FormTask4 {

    public static void main(String[] args){
        JFrame jFrame = getFrame();
    }

    static JPanel panel = new JPanel();

    static JPanel getPanelTask2(){
        var jPanel = new JPanel();

        final String[] action = new String[1];

        var jOpenButton = new JButton("Открыть");
        jPanel.add(jOpenButton);
        jOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showDialog(panel,"Открыть файл") == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    String path = file.getPath();
                    ///////////////////////////////////////////////////////

                    int[][] one = new FileStream().convertToInt(FileStream.readArray(path));

                    one = new Task22().findSaddle(one);

                    StringBuilder str = new StringBuilder();
                    for (var item : one) {
                        for (var item1 : item) {
                            str.append(item1+" ");
                        }
                        str.append("\n");
                    }


                    var jLabelArr = new JTextArea(str.toString());
                    jPanel.add(jLabelArr);

                    jPanel.revalidate();

                };

            }
        });

        var JSaveButton = new JButton("Сохранить");
        jPanel.add(JSaveButton);
        JSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                try {
                    if (fileChooser.showDialog(panel,"Сохранить") == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        String path = file.getPath();
                        //writeArray(jTextField.getText(),path);
                    }
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });

        jPanel.revalidate();

        return jPanel;
    }

    static JPanel getPanelTask1(){
        var jPanel = new JPanel();

        final String[] action = new String[1];

        var jOpenButton = new JButton("Открыть");
        jPanel.add(jOpenButton);
        jOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showDialog(panel,"Открыть файл") == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    String path = file.getPath();
                    ///////////////////////////////////////////////////////

                    int[][] one = new FileStream().convertToInt(FileStream.readArray(path));

                    new Task31().sortArray(one);

                    StringBuilder str = new StringBuilder();
                    for (var item : one) {
                        for (var item1 : item) {
                            str.append(item1+" ");
                        }
                        str.append("\n");
                    }


                    var jLabelArr = new JTextArea(str.toString());
                    jPanel.add(jLabelArr);

                    jPanel.revalidate();

                };

            }
        });

        var JSaveButton = new JButton("Сохранить");
        jPanel.add(JSaveButton);
        JSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                try {
                    if (fileChooser.showDialog(panel,"Сохранить") == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        String path = file.getPath();
                        //writeArray(jTextField.getText(),path);
                    }
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });

        jPanel.revalidate();

        return jPanel;
    }

    static JFrame getFrame(){
        JFrame jframe = new JFrame() {};
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        jframe.setBounds(toolkit.getScreenSize().width/10, toolkit.getScreenSize().height /10, 300,260);
        jframe.setTitle("Task8");


        JTabbedPane jTabbedPane = new JTabbedPane();
        jframe.add(jTabbedPane);

        jTabbedPane.add("Task22",getPanelTask2());
        jTabbedPane.add("Task31",getPanelTask1());
        jTabbedPane.setFocusable(false);

        return jframe;
    }

}

