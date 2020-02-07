package robot.classes;

import map.Case;
import map.TypeCase;

public class Neighbour
{
    public Case north;
    public Case south;
    public Case east;
    public Case west;
    public Case northeast;
    public Case northwest;
    public Case southeast;
    public Case southwest;

    
    public boolean findWater()
    {
        return (north.getType() == TypeCase.WATER || south.getType() == TypeCase.WATER ||
                east.getType() == TypeCase.WATER || west.getType() == TypeCase.WATER ||
                northeast.getType() == TypeCase.WATER || northwest.getType() == TypeCase.WATER ||
                southeast.getType() == TypeCase.WATER || southwest.getType() == TypeCase.WATER);
    }
}
