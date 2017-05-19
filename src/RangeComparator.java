import org.apache.commons.lang3.Range;

import java.util.Comparator;

/**
 * This class implements a Range comparator.
 */
class RangeComparator implements Comparator<Range<Integer>> {

    private boolean rangeOverlaps = false;

    // The range associated with this object.
    private Range<Integer> range;

    /**
     * Alternative approach
     * The constructor for this class.
     */
    //RangeComparator(Range<Integer> range) {
        //this.range = range;
    //}

    @Override
    public int compare(Range<Integer> obj1, Range<Integer> obj2) {

        // Check if the specified range is contained in this range, if so don't include.
        if (obj1.containsRange(obj2)) {
            return 0;
        }

        // Check if the specified range is overlapping with this range.
        if (obj1.overlapsRange(obj2)) {
            rangeOverlaps = true;
            return -1;
        }

        return 1;
    }

    /**
     *
     * @return boolean rangeOverlaps
     */
    public boolean isRangeOverlaps() {
        return this.rangeOverlaps;
    }

    /**
     *
     * @return the string representation of the range
     */
    @Override
    public String toString() {
        return "[" +
                range.getMinimum() +
                ',' +
                range.getMaximum() +
                "] ";
    }
}