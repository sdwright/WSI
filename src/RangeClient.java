import org.apache.commons.lang3.Range;

//import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class RangeClient {

    // Contains the list of zip code ranges using a custom comparator to control what this set contains.
    private static Set<Range<Integer>> ranges = new TreeSet<Range<Integer>>(new RangeComparator());

    // Alternative approach
    //private static ArrayList<RangeComparator> = new ArrayList<RangeComparator>();

    private static final String errorMessage = "Please enter 5-digit ZIP code ranges (each range includes both " +
            "their upper and lower bounds), for example - [94133,94133] [94200,94299] [94226,94399].";

    public static void main(String[] args) {

        if (args.length > 0) {

            for (String inputRange : args) {

                String[] tokens = inputRange.split(",");

                if (tokens[0] != null && tokens[1] != null &&
                        tokens[0].matches(".[0-9]{5}") && tokens[1].matches("[0-9]{5}]")) {

                    int minimum = new Integer(tokens[0].substring(1));
                    int maximum = new Integer(tokens[1].substring(0, tokens[1].length() - 1));

                    // Create a range object and add to the local collection.
                    Range<Integer> range = Range.between(minimum, maximum);
                    // Todo: Range.between() takes a comparator as a param, should that be used?

                    ranges.add(range);

                    // Alternate approach....
                    //RangeComparator rangeComparator = new RangeComparator(range);
                    //rangeComparators.add(rangeComparator);

                    /**
                     * If range overlaps, do the following....
                     *
                     * 1. Remove range that overlaps from collection.
                     * 2. Locate range that overlaps with this range.
                     * 3. See if range is overlapping on the minimum or the maximum. If the range is overlapping
                     * on both the minimum and maximum then it becomes a contains situation which is already handled in
                     * the comparator compare method.
                     * 4. Replace that range with either a different minimum or maximum in order to include the
                     * overlapping range.
                     */

                    // Alternate approach....
                    // if (rangeComparator.isRangeOverlaps() {
                    // }
                }
                else {
                    System.out.print(errorMessage);
                    break;
                }
            }

            displayMinimizedRanges();
        }
        else
            System.out.print(errorMessage);
    }

    /**
     * Displays the minimum number of ranges required to represent the same restrictions as the input.
     */
    private static void displayMinimizedRanges() {
        for (Object range : ranges)
            System.out.print(range.toString());
        // Todo: Range.toString() is called instead of RangeComparator.toString().
    }

}