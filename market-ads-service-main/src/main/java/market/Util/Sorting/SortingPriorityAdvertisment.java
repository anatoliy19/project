package market.Util.Sorting;

import market.model.Advertisement;
import java.util.Comparator;

public class SortingPriorityAdvertisment implements Comparator<Advertisement> {
    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        if (o1.getPriority().booleanValue() && !o2.getPriority().booleanValue()) {
            return -1;
        } else if (!o1.getPriority().booleanValue() && o2.getPriority().booleanValue()) {
            return 1;
        } else return 0;


    }
}
