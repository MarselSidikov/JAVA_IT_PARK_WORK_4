package ru.itpark.comparator;

public class ArrayListSorter {
  public static <E extends Comparable<E>> void sort(ArrayList<E> arrayList) {
    for (int i = arrayList.size() - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arrayList.get(j).compareTo(arrayList.get(j+1)) < 0) {
          arrayList.swap(j, j + 1);
        }
      }
    }
  }
}
