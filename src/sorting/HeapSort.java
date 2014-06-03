package sorting;

import dataStrct.HeapInArray;

public class HeapSort {

	public static void heapSort(int[] list) {
		HeapInArray heap = new HeapInArray();
		
		for (int i = 0; i < list.length; i++) {
			heap.insert(list[i]);
		}
		
		for (int i = 0; i < list.length; i++) {
			list[i] = heap.delete(0);
		}
	}
	
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		heapSort(list);
		
		for (int i = 0; i < list.length; i ++) {
			System.out.print(list[i] + " ");
		}
	}
}
