package ru.nutscoding.race;

public class Application {

    public static void main(String[] args) throws Exception {

        Sportsman sportsman1 = new Sportsman(1);
        Sportsman sportsman2 = new Sportsman(2);
        Sportsman sportsman3 = new Sportsman(3);
        Sportsman sportsman4 = new Sportsman(4);
        Sportsman sportsman5 = new Sportsman(5);
        Sportsman sportsman6 = new Sportsman(6);
        Sportsman sportsman7 = new Sportsman(7);
        Sportsman sportsman8 = new Sportsman(8);
        Sportsman sportsman9 = new Sportsman(9);
        Sportsman sportsman10 = new Sportsman(10);

        Stick stick = new Stick();
        sportsman1.takeStick(stick);
        sportsman1.runWithStick();
        sportsman1.transferStick(sportsman2);
        sportsman2.runWithStick();
        sportsman2.riskyTransferStick(sportsman3);
        sportsman3.runWithStick();
        sportsman3.transferStick(sportsman4);
        sportsman4.runWithStick();
    }
}
