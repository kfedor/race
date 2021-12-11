package ru.nutscoding.race;

import java.util.*;

public class Application {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {

        Stick stick = new Stick();

        Sportsman sportsman1 = new Sportsman(1, 99);
        Sportsman sportsman2 = new Sportsman(2, 41);
        Sportsman sportsman3 = new Sportsman(3, 49);
        Sportsman sportsman4 = new Sportsman(4, 13);
        Sportsman sportsman5 = new Sportsman(5, 33);
        Sportsman sportsman6 = new Sportsman(6, 17);
        Sportsman sportsman7 = new Sportsman(7, 55);
        Sportsman sportsman8 = new Sportsman(8, 21);
        Sportsman sportsman9 = new Sportsman(9, 73);
        Sportsman sportsman10 = new Sportsman(10, 60);

        List<Sportsman> team = new ArrayList<>();

        Collections.addAll(team,
                sportsman1, sportsman2, sportsman3,
                sportsman4, sportsman5, sportsman6,
                sportsman7, sportsman8, sportsman9, sportsman10);

        ListIterator<Sportsman> iterator = team.listIterator();

        Sportsman randomSportsmen = team.get(RANDOM.nextInt(team.size()));
        randomSportsmen.takeStick(stick);
        while (iterator.hasNext()) {
            iterator.next().runWithStick();
            iterator.next().someTransferStick(randomSportsmen);
        }

        System.out.println("Все добежали! Победила дружба!");
    }
}
