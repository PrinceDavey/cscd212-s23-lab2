package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {

    public int compare(Television t1, Television t2){
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        }
        if (!(t1 instanceof Television)) {
            return -1;
        } else if (!(t2 instanceof Television)) {
            return 1;
        }

        return t1.getScreenSize() - t2.getScreenSize();

    }

}
