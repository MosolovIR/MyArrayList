public class MyArrayList<T> {
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        if (size == elements.length) {
            resize(element);
        }

        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            return elements[index];
        }
    }

    public void resize(T element) {
        int newCapacity = (int) (elements.length * 1.5 + 1);
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            T[] arrayWithoutElement = (T[]) new Object[DEFAULT_CAPACITY];
            T removedElement = elements[index];

            if (index == 0) {
                System.arraycopy(elements, 1, arrayWithoutElement, 0, size - 1);
                arrayWithoutElement[size - 1] = null;
            } else if (index == size - 1) {
                elements[index] = null;
            } else {
                System.arraycopy(elements, 0, arrayWithoutElement, 0, size - index - 1);
                System.arraycopy(elements, index + 1, arrayWithoutElement, index, size - index - 1);
                arrayWithoutElement[size - 1] = null;
            }

            System.out.println("Element: " + removedElement + " with index: " + index + " was removed from the array");
        }
    }
}

