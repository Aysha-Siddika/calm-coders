package Modules;

/**
 * Created by HARINI on 10/1/2016.
 */
import com.google.android.gms.maps.model.LatLng;

import java.util.List;


public class Route
{
    public Distance distance;
    public Modules.Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}