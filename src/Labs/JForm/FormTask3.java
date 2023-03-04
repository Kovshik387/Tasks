package Labs.JForm;

import Labs.Task3.Task;
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
import static Labs.Utility.FileStream.writeArray;


public class FormTask3 {

    public static void main(String[] args){
        JFrame jFrame = getFrame();
    }

    static JPanel panel = new JPanel();

    static JPanel getPanelTask2(){
        var jPanel = new JPanel();

        JTextField jTextField = new JTextField("",20);
        jPanel.add(new JLabel("Значения:"));
        jPanel.add(jTextField);

        final String[] action = new String[1];

        var jButton = new JButton("Вычислить");
        jPanel.add(jButton);

        JTextArea jTextArea = new JTextArea(5,30);
        jTextArea.setLineWrap(true);

        jPanel.add(jTextArea);

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
                    List<Integer> one = new FileStream().<String>readArray(path).get(0).stream().map(Integer::parseInt).collect(Collectors.toList());
                    int[] arr = one.stream().mapToInt(Integer::intValue).toArray();
                    String str = printArray(new Task().findSymitry(arr),arr);
                    jTextArea.setText(str);
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
                        writeArray(jTextArea.getText(),path);
                    }
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });


        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Происходит действие
                action[0] = jTextField.getText();

                try {
                /////////////////////////////////////////////
                    int[] result = (Arrays.stream(action[0].split(" ")).mapToInt(Integer::parseInt).toArray());

                    String str = printArray(new Task().findSymitry(result),result);

                    jTextArea.setText(String.valueOf(str));
                }
                catch (Exception exception){
                    System.out.println(exception.getMessage());
                }

                jPanel.revalidate();
            }
        });

        jPanel.revalidate();

        return jPanel;
    }

    static JPanel getPanelTask1(){
        var jPanel = new JPanel();

        JTextField jTextField = new JTextField("",20);
        jPanel.add(new JLabel("Значения:"));
        jPanel.add(jTextField);

        final String[] action = new String[1];

        var jButton = new JButton("Вычислить");
        jPanel.add(jButton);

        JTextArea jTextArea = new JTextArea(5,30);
        jTextArea.setLineWrap(true);

        jPanel.add(jTextArea);

        var jOpenButton = new JButton("Открыть");
        jPanel.add(jOpenButton);
        jOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                if (fileChooser.showDialog(panel,"Открыть файл") == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    String path = file.getPath();
                    ///////////////////////////////////////////////////////
                    List<Integer> one = new FileStream().<String>readArray(path).get(0).stream().map(Integer::parseInt).collect(Collectors.toList());
                    int[] arr = one.stream().mapToInt(Integer::intValue).toArray();
                    String str = String.valueOf(new Labs.Task3.Task11().findArray(arr));
                    jTextArea.setText(str);
                };

            }
        });

        var JSaveButton = new JButton("Сохранить");
        jPanel.add(JSaveButton);
        JSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                try {
                    if (fileChooser.showDialog(panel,"Сохранить") == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        String path = file.getPath();
                        writeArray(jTextArea.getText(),path);
                    }
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Происходит действие
                action[0] = jTextField.getText();

                try {
                    ////////////////////////////////////////////////////////////////////////////
                    int result = new Labs.Task3.Task11().findArray(Arrays.stream(action[0].split(" ")).mapToInt(Integer::parseInt).toArray());

                    jTextArea.setText(String.valueOf(result));
                }
                catch (Exception exception){
                    System.out.println(exception.getMessage());
                }

                jPanel.revalidate();
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
        jframe.setTitle("Task7");


        JTabbedPane jTabbedPane = new JTabbedPane();
        jframe.add(jTabbedPane);

        jTabbedPane.add("Task22",getPanelTask2());
        jTabbedPane.add("Task11",getPanelTask1());
        jTabbedPane.setFocusable(false);

        return jframe;
    }

}
