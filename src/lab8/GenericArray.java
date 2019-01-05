/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 8
 * Date: November 19, 2018
 */

package lab8;

/**
 * The purpose of this class is to generate an array that store generic type
 * objects.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 * 
 */

public class GenericArray<E> {
	private int capacity;
	private int size;
	// consider renaming the array to tArray
	private E[] genericArray;

	/**
	 * This default constructor calls the initialized constructor with parameter
	 * value of 10.
	 */
	public GenericArray() {
		this(10);
	}

	/**
	 * This is a constructor that construct an empty array with the specified
	 * initial capacity.
	 * 
	 * @param initialCapacity
	 *            The initial capacity of the array.
	 * @throws IllegalArgumentException
	 *             If the specified initial capacity is negative.
	 */
	public GenericArray(int initialCapacity) throws IllegalArgumentException {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		size = 0;
		capacity = initialCapacity;
		// stringArray = new String[initialCapacity];
		genericArray = (E[]) new Object[initialCapacity];
	}

	/**
	 * This is a constructor that copies another generic array of object.
	 * 
	 * @param sa
	 *            Another generic array object.
	 * @throws NullPointerException
	 *             If the specified generic array is null.
	 */
	public GenericArray(GenericArray sa) throws NullPointerException {
		this(sa.capacity);

		if (sa == null)
			throw new NullPointerException();

		this.size = sa.size;

		for (int i = 0; i < size; i++) {
			genericArray[i] = (E) sa.get(i);
		}
	}

	/**
	 * This appends the specified element to the end of this array.
	 * 
	 * @param s
	 *            Element to be appended to this array.
	 * @throws NullPointerException
	 *             If the element is null.
	 */
	public void add(E s) throws NullPointerException {
		try {
			add(size, s);
		} catch (NullPointerException ex) {
			throw ex;
		} catch (IndexOutOfBoundsException ex) {
			// do nothing, this should never occur
		}
	}

	/**
	 * This method inserts the specified element at the specified position in the
	 * array.
	 * 
	 * @param index
	 *            Index at which the specified element is t be inserted.
	 * @param s
	 *            The element to be inserted.
	 * @throws NullPointerException
	 *             If the element is null.
	 * @throws IndexOutOfBoundsException
	 *             If the index is out of bound.
	 */
	public void add(int index, E s) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null)
			throw new NullPointerException();

		if (index > size)
			throw new IndexOutOfBoundsException();

		if (size == capacity)
			ensureCapacity(capacity + capacity / 2);

		for (int i = size; i > index; i--) {
			genericArray[i] = genericArray[i - 1];
		}

		genericArray[index] = s;

		size++;
	}

	/**
	 * This method returns the capacity of the array.
	 * 
	 * @return The capacity.
	 */
	public int capacity() {
		return capacity;
	}

	/**
	 * This method attempts to remove all elements from this array.
	 */
	public void clear() {
		for (; size > 0; size--)
			genericArray[size - 1] = null;
	}

	/**
	 * This method returns true if the array contains the specified elements
	 * otherwise return false.
	 * 
	 * @param s
	 *            The element that will be tested.
	 * @return returns true if the array contains the specified elements otherwise
	 *         return false.
	 * @throws NullPointerException
	 *             If the element is null.
	 */
	public boolean contains(E s) throws NullPointerException {
		return indexOf(s) > -1;
	}

	/**
	 * This method increases the capacity of the instances, if necessary.
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		if (minCapacity <= size)
			throw new CapacityOutOfBoundsException();

		if (capacity < minCapacity) {
			capacity = minCapacity;
			// String[] temp = new String[capacity];
			E[] temp = (E[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = genericArray[i];
			}
			genericArray = temp;
		}
	}

	/**
	 * This method returns the elements at the specified position in the array.
	 * 
	 * @param index
	 *            The index of the element to return.
	 * @return The element at the specified position in the array.
	 * @throws IndexOutOfBoundsException
	 *             If the index is out of balance.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return genericArray[index];
	}

	/**
	 * This method returns the index found.
	 * 
	 * @param s
	 *            The element to be inserted.
	 * @return The element at the specified position in the array.
	 * @throws NullPointerException
	 *             If the array is out of index.
	 */
	public int indexOf(E s) throws NullPointerException {
		if (s == null)
			throw new NullPointerException();

		int found = -1;

		for (int i = 0; i < size; i++) {
			if (s.equals(genericArray[i])) {
				found = i;
				break;
			}
		}

		return found;
	}

	/**
	 * This method checks if the array is empty.
	 * 
	 * @return The size of element left in the array.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		E old = genericArray[index];

		for (; index < size; index++) {
			genericArray[index] = genericArray[index + 1];
		}

		size--;
		return old;
	}

	public boolean remove(E s) throws NullPointerException {
		int index = indexOf(s);
		remove(index);
		return index > -1;
	}

	/**
	 * This method sets the element in generic array.
	 * 
	 * @param index
	 *            The index of the element in the array.
	 * @param s
	 *            The element to be set.
	 * @return
	 * @throws IndexOutOfBoundsException
	 *             If out of bound.
	 * @throws NullPointerException
	 *             If the element is null.
	 */
	public E set(int index, E s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (s == null)
			throw new NullPointerException();

		E old;

		if (index > capacity) {
			ensureCapacity(index + 1);
			old = null;
		} else {
			old = genericArray[index];
		}

		if (index >= size) {
			size = index + 1;
		}

		genericArray[index] = s;
		return old;
	}

	/**
	 * This method attempts to give the size of the array.
	 * 
	 * @return The size of the array.
	 */
	public int size() {
		return size;
	} // End of the method.

}// End of the class.
