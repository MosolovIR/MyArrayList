import java.util.Comparator;

public class QuickSort {
    public static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator) {
        quickSort(list, 0, list.getSize() - 1, comparator);
    }

    private static <T> void quickSort(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);

            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                swapElements(list, i, j);
            }
        }
        swapElements(list, i + 1, high);

        return i + 1;
    }

    private static <T> void swapElements(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(17);
        list.add(14);
        list.add(15);
        list.add(28);
        list.add(6);
        list.add(8);
        list.add(-6);
        list.add(1);
        list.add(3);
        list.add(18);

        System.out.println("Unsorted Array: ");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }

        QuickSort.quickSort(list, Comparator.naturalOrder());

        System.out.println("\nSorted Array: ");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
