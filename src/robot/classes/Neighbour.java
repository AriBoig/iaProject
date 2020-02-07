package robot.classes;

import map.Cell;
import map.TypeCase;

public class Neighbour
{
    public Cell north;
    public Cell south;
    public Cell east;
    public Cell west;
    public Cell northeast;
    public Cell northwest;
    public Cell southeast;
    public Cell southwest;

    
    public boolean findWater()
    {
        return (north.getType() == TypeCase.WATER || south.getType() == TypeCase.WATER ||
                east.getType() == TypeCase.WATER || west.getType() == TypeCase.WATER ||
                northeast.getType() == TypeCase.WATER || northwest.getType() == TypeCase.WATER ||
                southeast.getType() == TypeCase.WATER || southwest.getType() == TypeCase.WATER);
    }
}
