package nyc.c4q.androidtest_unit4final;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by justiceo on 1/7/18.
 */

public class SortTest {

    @Test
    public void selectionSort_works_on_empty_list() {
        ArrayList<String> list = new ArrayList<>();
        Sort.selectionSort(list, true);
        assertEquals("it should work on an empty list", new ArrayList<String>(), list);
    }

    @Test
    public void selectionSort_works_on_single_item_list() {
        List<String> list = makeList("2");
        Sort.selectionSort(list, true);
        assertEquals("it should work on a single-item list", makeList("2"), list);
        Sort.selectionSort(list, false);
        assertEquals("it should work on a single-item list descending", makeList("2"), list);

    }



    @Test
    public void selectionSort_works_on_alpha_nums() {
        List<String> list = makeList("Z", "224", "223", "a", "@", "A", "9");
        Sort.selectionSort(list, true);
        assertEquals("it should work on any ascii character", makeList("223", "224", "9", "@", "A", "Z", "a"), list);

    }

    @Test
    public void selectionSort_works_on_linkedList() {
        LinkedList<String> list = new LinkedList<>(makeList("Z", "224", "223", "a", "_a", "A", "9"));
        Sort.selectionSort(list, true);
        assertEquals("it should work on any kind of list", makeList("223", "224", "9", "A", "Z", "_a", "a"), list);
    }

    @Test
    public void selectionSort_works_on_duplicate_items() {
        List<String> list = makeList("B", "B", "B", "z", "A", "A", "A", "C");
        Sort.selectionSort(list, true);
        assertEquals("it should work with list with duplicate items", makeList( "A", "A", "A", "B", "B", "B", "C", "z"), list);
        Sort.selectionSort(list, false);
        assertEquals("it should work with list with duplicate items descending", makeList( "z", "C", "B", "B", "B", "A", "A", "A"), list);
    }

    @Test
    public void selectionSort_works_on_sorted_list() {
        List<String> list = makeList("1", "2", "3");
        Sort.selectionSort(list, true);
        assertEquals("it should work with already sorted list", makeList( "1", "2", "3"), list);
    }

    @Test
    public void selectionSort_can_sort_descending() {
        List<String> list = makeList("1", "2", "3", "4");
        Sort.selectionSort(list, false);
        assertEquals("it should sort in descending order", makeList( "4", "3", "2", "1"), list);
    }

    public List makeList(String... items) {
        ArrayList<String> l = new ArrayList<>();
        for(String s: items) {
            l.add(s);
        }
        return l;
    }
}
