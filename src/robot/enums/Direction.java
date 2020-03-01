package robot.enums;

import java.util.Random;

/**
 * @author Enzo DECHAENE
 */
public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    NORTHEAST,
    NORTHWEST,
    SOUTHEAST,
    SOUTHWEST;

    /**
     *
     * @return
     * @author Enzo DECHAENE
     */
    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
