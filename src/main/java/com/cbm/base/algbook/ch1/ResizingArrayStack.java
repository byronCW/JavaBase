package com.cbm.base.algbook.ch1;


import java.util.Iterator;

/**
 * 
 * ClassName: ResizingArrayStack <br/>
 * Description: 下压栈（能够动态调整数组大小的实现）. <br/>
 * Function: 能够动态调整数组大小的实现. <br/>
 * Reason: N/A. <br/>
 * date: 2016年11月8日 下午11:38:08 <br/>
 * 
 * @author byron
 * @version @param <Item>
 * @since JDK 1.7
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

	/**
	 * 存放元素的栈（数组）
	 */
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];

	/**
	 * 元素的数量
	 */
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		// move stack to a larger array
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null; // 避免对象游离无法释放
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {

		}

	}
}
