package robot.algo;

import robot.enums.Mode;

import java.util.Random;

public class LearningEnhancement
{
    private static final double MOVE_EPSILON = 0.1;

    private double epsilon;

    /**
     * @author Enzo DECHAENE.
     */
    public LearningEnhancement()
    {
        epsilon = 1.0; /* Exploration Mode */
    }

    /**
     *
     * @return
     * @author Enzo DECHAENE.
     */
    public Mode getTypeMove()
    {
        if (LearningEnhancement.random() < epsilon) {
            epsilon -= MOVE_EPSILON;
            return Mode.EXPLORATION;
        }
        else {
            epsilon += MOVE_EPSILON;
            return Mode.OPERATION;
        }
    }

    /*
    void calculateQ( int trainCycles)
    {
        Random rand = new Random();
        for ( int i = 0; i < trainCycles; i++) { // Train cycles
            // Sélectionne un é tat initial alé atoire
            int crtState = rand.nextInt(statesCount);

            while (!isFinalState(crtState)) {

                int [] actionsFromCurrentState = ←$ possibleActionsFromState(crtState);
                // Ré cup ère une action alé atoire parmis les actions ←$ possibles
                int index = rand.nextInt(actionsFromCurrentState.←$ length);
                int nextState = actionsFromCurrentState[index];
                // Mise à jour de la Q- table
                double q = Q[crtState][nextState];
                double maxQ = maxQ(nextState);
                int r = R[crtState][nextState];
                Q[crtState][nextState] = q + alpha * (r + gamma * maxQ←$ - q);
                crtState = nextState;
            }
        }
    }
    
     */

    /**
     * This function is use to have a random between two integer.
     * @return
     * @author Enzo DECHAENE.
     */
    public static double random()
    {
        return Math.random();
    }
}
