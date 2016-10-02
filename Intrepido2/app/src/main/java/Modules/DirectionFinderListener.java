package Modules;

/**
 * Created by HARINI on 10/1/2016.
 */

import java.util.List;

/**
 * Created by Mai Thanh Hiep on 4/3/2016.
 */
public interface DirectionFinderListener
{
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
