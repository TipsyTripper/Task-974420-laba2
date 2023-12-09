package kours.database.ui;

import kours.database.Main;
import kours.database.persistence.GamblerPersistence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ActionsForEnd implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = Menu.getInstance().getName();
        int gamblers = Menu.getInstance().getGamblers();
        int time = Menu.getInstance().getTime();

        Main.addGambler(name, gamblers, time);

        TheFrame frameWithTable = new TheFrame();
        GamblerPersistence gamblerPersistence = Main.getPersistence();
        Map<Integer, String> list = gamblerPersistence.getAll();
        frameWithTable.containerBoards(list.size());

        for (int t = 1; t < list.size() + 1; ++t) {
            String gambler = "Gambler numer \'" + Integer.toString(t + 1) + "\' has such information: " + list.get(t);
            frameWithTable.containerAdd(gambler);
        }
        frameWithTable.containerResult();
    }
}
