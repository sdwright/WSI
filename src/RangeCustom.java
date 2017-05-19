import org.apache.commons.lang3.Range;

import java.util.Comparator;

/**
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
        // Not sure about how to implement the comparator logic, or access what is already in the Range class.
        //return obj1.compareTo(obj2);
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
        StringBuilder buf = new StringBuilder(13);

        buf.append('[');
        buf.append(range.getMinimum());
        buf.append(',');
        buf.append(range.getMaximum());
        buf.append("] ");

        return buf.toString();
    }

}