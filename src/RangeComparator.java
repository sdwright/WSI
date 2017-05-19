import org.apache.commons.lang3.Range;

import java.util.Comparator;

/**
 * This class implements a Range comparator.
 */
class RangeComparator implements Comparator<Range> {

    @Override
    public int compare(Range obj1, Range obj2) {

        // Check if the specified range is contained in this range, if so don't include.
        if (obj1.containsRange(obj2)) {
            return 0;
        }

        // Check if the specified range is overlapping with this range.
        if (obj1.overlapsRange(obj2)) {
            return -1;
        }

        return 1;
    }

    /**
     *
     * @return the string representation of the range
     */
    @Override
    public String toString() {
        return "[" +
                //range.getMinimum() +
                ',' +
                //range.getMaximum() +
                "] ";
    }
}