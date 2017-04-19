import java.util.Comparator;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class ParkState implements Comparator<KindOfPark> {

    public int compare(KindOfPark o1, KindOfPark o2) {
        return o1.getState().toString().compareTo(o2.getState().toString());
    }
}
