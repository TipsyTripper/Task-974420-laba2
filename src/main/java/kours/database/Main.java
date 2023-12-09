package kours.database;

import kours.database.persistence.GamblerPersistence;
import kours.database.ui.Menu;

public class Main {

    private static GamblerPersistence gamblerPersistence = new GamblerPersistence();

    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
    }

    public static GamblerPersistence getPersistence() {
        return gamblerPersistence;
    }

    public static void addGambler(String name, int gamblers, int time) {
        gamblerPersistence.createGambler(name, gamblers, time);
    }
}