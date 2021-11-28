import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Sportsman n1 = new Sportsman("Вася");
        Sportsman n2 = new Sportsman("Петя");
        Sportsman n3 = new Sportsman("Коля");
        Sportsman n4 = new Sportsman("Дима");
        Sportsman n5 = new Sportsman("Серега");
        Sportsman n6 = new Sportsman("Саша");
        Sportsman n7 = new Sportsman("Леха");
        Sportsman n8 = new Sportsman("Володя");
        Sportsman n9 = new Sportsman("Женя");
        Sportsman n10 = new Sportsman("Артём");

        List<Sportsman> listOfSportsmen = new ArrayList<>();
        listOfSportsmen.add(n1);
        listOfSportsmen.add(n2);
        listOfSportsmen.add(n3);
        listOfSportsmen.add(n4);
        listOfSportsmen.add(n5);
        listOfSportsmen.add(n6);
        listOfSportsmen.add(n7);
        listOfSportsmen.add(n8);
        listOfSportsmen.add(n9);
        listOfSportsmen.add(n10);

        Stick stick = new Stick();
        n1.safeStickTransfer(stick);

    }
}
