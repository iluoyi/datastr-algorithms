package dataStrct;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Yi: Heap siftdown might contain bugs, should be checked later.
 */
public class HeapInArray {
	
	ArrayList<Integer> minHeap;
	//ArrayList<Integer> minHeap;
	
	public HeapInArray() {
		minHeap = new ArrayList<Integer>();
	}
	
	public HeapInArray(Integer[] initArray) {
		minHeap = new ArrayList<Integer>(Arrays.asList(initArray));
		//initDown();
	}
	
	// O(nlogn)
	private void initUp() {
		for (int i = 0; i < minHeap.size(); i ++) {
			bubbleUp(i);
		}
	}
	// T(n) = 2^(h-2) + 2^(h-3)*2 + ... + 2^0*h = O(n)
	private void initDown() {
		for (int i = (minHeap.size() - 1) / 2; i >= 0; i --) {
			siftDown(i);
		}
	}
	
	public void insert(int x) {
		minHeap.add(x);
		bubbleUp(minHeap.size() - 1);
	}
	
	private void bubbleUp(int index) {
		Integer temp = minHeap.get(index);
		int crt = index;
		int parent = (crt - 1) / 2;
		boolean flag = false;
		
		while (crt > 0) {
			if (minHeap.get(parent) > temp) {
				minHeap.set(crt, minHeap.get(parent));
				crt = parent;
				parent = (crt - 1) / 2;
				flag = true;
			} else {
				break;
			}
		}
		if (flag) {
			minHeap.set(crt, temp);
		}
	}
	
	public int delete(int index) {
		if (index >= 0) {
			int value = minHeap.get(index);
			minHeap.set(index, minHeap.get(minHeap.size() - 1));
			minHeap.remove(minHeap.size() - 1);
			siftDown(index);
			return value;
		}
		return -1;
	}
	
	private void siftDown(int index) {
		if (index < minHeap.size()) {
			Integer temp = minHeap.get(index);
			int child = index;
			int crt = index;
			boolean flag = false;
			
			while (2 * crt + 1 < minHeap.size()) {// if 2 * crt + 1 >= minHeap.size(), it has no child
				// find the smallest child to compare
				if (2 * crt + 1 == minHeap.size() - 1) { // it only has left child
					child = 2 * crt + 1;
				} else { // it has two children, 2 * index + 1 < minHeap.size() - 1
					if (minHeap.get(2 * crt + 1) < minHeap.get(2 * crt + 2)) {
						child = 2 * crt + 1;
					} else {
						child = 2 * crt + 2;
					}
				}
				if (temp > minHeap.get(child)) {
					minHeap.set(crt, minHeap.get(child));
					crt = child;
					flag = true;
				} else {
					break;
				}
			}
			if (flag) {
				minHeap.set(crt, temp);
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < minHeap.size(); i++) {
			System.out.print(minHeap.get(i) + ",");
		}
	}
	
	public static void main(String args[]) {  
		Integer[] testInput = {5, 10, 3, 7, 11, 15, 17, 20, 2, 1};

		HeapInArray minHeap = new HeapInArray(testInput);
	
//		minHeap.delete(0);
//		minHeap.insert(0);
//		minHeap.insert(0);
		minHeap.print();
    }  
}
