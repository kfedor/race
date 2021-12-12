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
    private static final int MAX_LEVEL = 100;

    private final int number;
    private final int level;
    private final String currentSportsman;
    @Nullable
    private Stick stick;

    public Sportsman(int number, int level) {
        this.number = number;
        this.currentSportsman = "Спортсмен № " + number;
        this.level = level;
    }

    /**
     * Этот метод нужен для того, чтобы спортсмен взял палочку.
     */
    public void takeStick(Stick stick) {
        System.out.printf("%s взял палочку\n", currentSportsman);
        this.stick = stick;
    }
    /**
     * Метод нужен, чтобы спортсмен побежал.
     * Если спортсмен упадет, метод бросает исключение.
     */
    public void runWithStick() {
        System.out.printf("%s побежал!\n", currentSportsman);
        if (!isLucky()) {
            throw new SportsmanFailedWhileRunningException
                    (String.format("%s упал во время бега!\n", currentSportsman));
        }
        System.out.printf("%s успешно пробежал!\n", currentSportsman);
    }
    /**
     * Метод описывает безопасную передачу палочки.
     */
    private void transferStick(Sportsman sportsman) {
        System.out.printf("%s передает палочку спортсмену под номером %s\n",
                currentSportsman, sportsman.getNumber());
        sportsman.takeStick(stick);
        this.stick = null;
    }
    /**
     * Метод описывает рискованную передачу палочки.
     * Спортсмен может уронить палочку, тогда метод бросает исключение.
     */
    private void riskyTransferStick(Sportsman sportsman) throws StickTransferException {
        if (!isLucky()) {
            throw new StickTransferException(String.format("%s не добросил палочку!\n", currentSportsman));
        }
        System.out.printf("%s бросает палочку спортсмену под номером %s\n",
                currentSportsman, sportsman.getNumber());
        sportsman.takeStick(stick);
        this.stick = null;
    }
    /**
     * Метод проверяет уровень удачи спортсмена.
     */
    private boolean isLucky() {
        return FAIL_CHANCE < RANDOM.nextInt(LUCKY_RANGE);
    }
    /**
     * Метод описывает механизм выбора способа передачи палочки.
     */
    public void someTransferStick(Sportsman sportsman) throws StickTransferException {

        if (level < RANDOM.nextInt(MAX_LEVEL)) {
            transferStick(sportsman);
        } else {
            riskyTransferStick(sportsman);
        }
    }
}
