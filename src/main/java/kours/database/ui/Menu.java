package kours.database.ui;

import kours.database.database.MyDataBase;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    private static Menu instanse;

    private static JTextField inputName1 = new JTextField("", 5);
    private static JTextField inputNameCount1 = new JTextField("", 5);
    private static JTextField inputNameTime1 = new JTextField("", 5);

    public synchronized static Menu getInstance() {
        if (instanse == null) {
            instanse = new Menu();
            instanse.setVisible(true);
            instanse.setResizable(false);
        }

        return instanse;
    }

    public synchronized static void disposeInstance() {
        instanse.setVisible(false);
        instanse = null;
    }

    public Menu() {
        super("add gamblers");
        this.setBounds(100, 100,500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelName = new JLabel("Input name:");
        JLabel labelNameCount = new JLabel("Input how many gumblers were:");
        JLabel labelNameTime = new JLabel("Input bolt:");

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, 2,2));

        container.add(labelName);
        container.add(labelNameCount);
        container.add(labelNameTime);

        container.add(inputName1);
        container.add(inputNameCount1);
        container.add(inputNameTime1);

        JButton more = new JButton("more");
        JButton end = new JButton("end");

        container.add(more);
        container.add(end);

        more.addActionListener(new ActionsForMore());
        end.addActionListener(new ActionsForEnd());
    }

    public String getName() {
        return inputName1.getText();
    }

    public int getGamblers() {
        return Integer.parseInt(inputNameCount1.getText());
    }

    public int getTime() {
        return Integer.parseInt(inputNameTime1.getText());
    }
}
