package robot.enums;

/**
 * @author Enzo DECHAENE
 */
public enum Mode {
    NOTHING,        /* Il s'agit du mode ou le robot est amene a rien faire   */
    EXPLORATION,    /* il s'agit du mode permettant l'exploration             */
    OPERATION,      /* il s'agit du mode permettant l'exploitation            */
    WORK,           /* il s'agit du mode permettant de travailler sur la case */
    DELIVERY,       /* il s'agit du mode permettant la livraison des biens    */
    REPAIR          /* il s'agit du mode permettant la reparation du robot    */
}