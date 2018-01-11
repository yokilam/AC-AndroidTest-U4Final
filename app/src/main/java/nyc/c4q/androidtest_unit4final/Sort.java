package nyc.c4q.androidtest_unit4final;

import java.util.List;

/**
 * Created by justiceo on 1/7/18.
 */

public class Sort {

    /**
     * Sorts a list using the selection sort algorithm.
     * See lecture on sorting: https://github.com/C4Q/AC-Android/tree/v2/DSA/sorting
     * <p>
     * When `isAscending` is true, the list is sorted in ascending alphabetical order from a to z,
     * otherwise it is sorted in descending order from z to a.
     *
     * @param list
     * @param isAscending
     */
    public static void selectionSort(List <String> list, boolean isAscending) {
        // TODO: Implement selection sort.
        if (isAscending) {
            for (int i = list.size(); i > 0; i--) {
                int lastColor = 0;
                for (int j = 0; j < i; j++) {
                    if (list.get(j).compareTo(list.get(lastColor)) > 0) {
                        lastColor = j;
                    }
                    String temp = list.get(lastColor);
                    list.set(lastColor, list.get(i - 1));
                    list.set(i - 1, temp);
                }
            }
        } else {
            for (int i = list.size(); i > 0; i--) {
                int lastColor = 0;
                for (int j = 0; j < i; j++) {
                    if (list.get(j).compareTo(list.get(lastColor)) < 0) {
                        lastColor = j;
                    }
                    String temp = list.get(lastColor);
                    list.set(lastColor, list.get(i - 1));
                    list.set(i - 1, temp);
                }
            }
        }
        // You may not use Collections.sort or its equivalent
        // You may not implement another sorting algorithm that is not "selection sort"
        // Tip: Try a version without ordering first.
    }
}
