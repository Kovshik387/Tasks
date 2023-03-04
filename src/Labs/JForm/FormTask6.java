package Labs.JForm;

import Labs.Task3.Task;
import Labs.Task5.Task12;
import Labs.Task5.Task22;
import Labs.Task6.Tablet;
import Labs.Task6.Task21;
import Labs.Utility.FileStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Labs.Task6.TableUtil.*;
import static Labs.Utility.FileStream.convertToList;
import static Labs.Utility.FileStream.writeArray;


public class FormTask6 {

    public static void main(String[] args){
        JFrame jFrame = getFrame();
    }

    static JPanel panel = new JPanel();

    static JPanel getPanelTask1(){
        var jPanel = new JPanel();

        final String[] action = new String[1];

        jPanel.add(new JLabel("Деньги"));
        JTextField money = new JTextField("",4);
        jPanel.add(money);

        JTextArea jTextArea = new JTextArea(5,80);
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

                    var result = getTabletList(path);
                    sortBuyTable(result);

                    for (var item : result) System.out.println(item.toString());

                    String str = "";
                    for (var item : result) if (item.getPrice() <= Integer.parseInt(money.getText())) {
                        str += ("Куплен товар\t" + item.toString() + "\n");
                        break;
                    }

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


        jPanel.revalidate();

        return jPanel;
    }

    static JPanel getPanelTask2(){
        var jPanel = new JPanel();

        final String[] action = new String[1];

        jPanel.add(new JLabel("Рейтинг:"));
        JTextField rating = new JTextField("",2);
        jPanel.add(rating);

        jPanel.add(new JLabel("Память"));
        JTextField memory = new JTextField("",2);
        jPanel.add(memory);

        jPanel.add(new JLabel("Количество"));
        JTextField count = new JTextField("",2);
        jPanel.add(count);

        JTextArea jTextArea = new JTextArea(5,60);
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

                    List<Tablet> tablets = getTabletList(path);
                    String str = "";

                    sortTable(tablets);

                    var result = buyTablets(tablets,Integer.parseInt(count.getText()),Integer.parseInt(String.valueOf(memory.getText())),Integer.parseInt(String.valueOf(rating.getText())));

                    for (var item : result) str+= item.toString() + "\n";

                    jTextArea.setText(str.toString());
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

        jPanel.revalidate();

        return jPanel;
    }

    static JFrame getFrame(){
        JFrame jframe = new JFrame() {};
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        jframe.setBounds(toolkit.getScreenSize().width/10, toolkit.getScreenSize().height /10, 400,260);
        jframe.setTitle("Task10");

        JTabbedPane jTabbedPane = new JTabbedPane();
        jframe.add(jTabbedPane);

        jTabbedPane.add("Task11",getPanelTask1());
        jTabbedPane.add("Task22",getPanelTask2());
        jTabbedPane.setFocusable(false);

        return jframe;
    }

}
