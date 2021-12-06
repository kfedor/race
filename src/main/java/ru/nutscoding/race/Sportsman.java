package ru.nutscoding.race;

import lombok.Data;
import ru.nutscoding.race.exception.SportsmanFailedWhileRunningException;
import ru.nutscoding.race.exception.StickTransferException;

import javax.annotation.Nullable;
import java.util.Random;

@Data
public class Sportsman {

    private static final Random RANDOM = new Random();
    private static final int LUCKY_RANGE = 100;
    private static final int FAIL_CHANCE = 20;

    private final int number;
    private final String currentSportsman;
    @Nullable
    private Stick stick;

    public Sportsman(int number) {
        this.number = number;
        this.currentSportsman = "Спортсмен № " + number;
    }

    public void takeStick(Stick stick) {
        System.out.printf("%s взял палочку\n", currentSportsman);
        this.stick = stick;
    }

    public void runWithStick() {
        System.out.printf("%s побежал!\n", currentSportsman);
        if (!isLucky()) {
            throw new SportsmanFailedWhileRunningException
                    (String.format("%s упал во время бега!\n", currentSportsman));
        }
        System.out.printf("%s успешно пробежал!\n", currentSportsman);
    }

    public void transferStick(Sportsman sportsman) {
        doTransferStick(sportsman);
    }

    public void riskyTransferStick(Sportsman sportsman) throws StickTransferException {
        if (!isLucky()) {
            throw new StickTransferException(String.format("%s не добросил палочку!\n", currentSportsman));
        }
        doTransferStick(sportsman);
    }

    private boolean isLucky() {
        return FAIL_CHANCE < RANDOM.nextInt(LUCKY_RANGE);
    }

    private void doTransferStick(Sportsman sportsman) {
        System.out.printf("%s передает палочку спортсмену под номером %s\n",
                currentSportsman, sportsman.getNumber());
        sportsman.takeStick(stick);
        this.stick = null;
    }
}
