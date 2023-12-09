package kours.database.ui;

import kours.database.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsForMore implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = Menu.getInstance().getName();
        int gamblers = Menu.getInstance().getGamblers();
        int time = Menu.getInstance().getTime();

        Main.addGambler(name, gamblers, time);
        Menu.disposeInstance();
        Menu.getInstance();
    }
}
