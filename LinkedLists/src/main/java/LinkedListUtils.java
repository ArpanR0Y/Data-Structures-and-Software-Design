import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListUtils {

  /**
   * This method assumes the input LinkedList is already sorted in non-descending order (i.e.,such
   * that each element is greater than or equal to the one that is before it, and inserts the input
   * int value into the correct location of the list. Note that the method does not return anything,
   * but rather modifies the input LinkedList as a side effect. If the input LinkedList is null,
   * this method should simply terminate.
   */
  public static void insertSorted(LinkedList<Integer> list, int value) {
    if (list != null) {
      if (list.size() == 0) {
        list.add(value);
        return;
      }
      for (int i = 1; i < list.size(); i++) {
        if (list.get(1) > value) {
          list.addFirst(value);
          return;
        } else if (list.get(i) >= value) {
          list.add(i, value);
          return;
        } else if (list.get(list.size() - 1) < value) {
          list.addLast(value);
          return;
        }
      }
    }
  }

  /**
   * This method removes all instances of the N largest values in the LinkedList. If the input
   * LinkedList is null or if N is non-positive, this method should simply return without any
   * modifications to the input LinkedList. Keep in mind that if any of the N largest values appear
   * more than once in the LinkedList, this method should return remove all instances, so it may
   * remove more than N elements overall. The other elements in the LinkedList should not be
   * modified and their order must not be changed.
   */
  public static void removeMaximumValues(LinkedList<String> list, int N) {
    if (list != null && !list.isEmpty()) {
      if (list.size() <= N) {
        list.removeAll(list);
        return;
      }
      for (int i = 0; i < N; i++) {
        LinkedList<String> sortedList = new LinkedList<>(list);
        Comparator<String> cmp = Comparator.comparingInt(String::length)
            .thenComparing(String.CASE_INSENSITIVE_ORDER).reversed();
        sortedList.sort(cmp);
        list.removeAll(Collections.singletonList(sortedList.get(0)));
      }
    }
  }

  /**
   * This method determines whether any part of the first LinkedList contains all elements of the
   * second in the same order with no other elements in the sequence, i.e. it should return true if
   * the second LinkedList is a subsequence of the first, and false if it is not. The method should
   * return false if either input is null or empty.
   */
  public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
    if ((one != null && !one.isEmpty()) && (two != null && !two.isEmpty())) {
      if (two.equals(one)) {
        return true;
      }
      for (int i = 0; i < one.size(); i++) {
        if (one.get(i).equals(two.get(0))) {
          int j = 1;
          while (j < two.size()) {
            try {
              if (!one.get(i + 1).equals(two.get(j))) {
                return false;
              }
              i++;
              j++;
            } catch (IndexOutOfBoundsException e) {
              return false;
            }
          }
          return true;
        }
      }
    }

    return false;
  }
}
