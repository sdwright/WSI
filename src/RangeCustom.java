import org.apache.commons.lang3.Range;

import java.util.Comparator;

/**
 * This class is not used.  Was an alternative approach of creating a collection of RangeCustom objects instead of a
 * collection of Range objects.
 *
 * This custom class is intended as a pseudo-wrapper for the final Range class.
 */
public class RangeCustom implements Comparator<Range<Integer>> {

    // The range associated with this object.
    private Range<Integer> range;

    /**
     * The constructor for this class.
     */
    RangeCustom(Range<Integer> range) {
        this.range = range;
    }

    @Override
    public int compare(Range<Integer> obj1, Range<Integer> obj2) {
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
     * @return Range
     */
    public Range<Integer> getRange() {
        return this.range;
    }

    /**
     *
     * @return the string representation of the range
     */
    public String toString() {
        return "[" +
                range.getMinimum() +
                ',' +
                range.getMaximum() +
                "] ";
    }

}