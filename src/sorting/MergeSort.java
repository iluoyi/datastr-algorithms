package sorting;

public class MergeSort {
	public static void mergeSort(int[] list, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(list, left, mid, temp);
			mergeSort(list, mid + 1, right, temp);
			merge(list, left, mid, right, temp);
		}
	}
	
	public static void merge(int[] list, int left, int mid, int right, int[] temp) {
		int p1 = left;
		int p2 = mid + 1;
		int p3 = 0;
		
		while (p1 <= mid && p2 <= right) {
			if (list[p1] < list[p2]) {
				temp[p3++] = list[p1++];
			} else {
				temp[p3++] = list[p2++];
			}
		}
		
		while (p1 <= mid) {
			temp[p3++] = list[p1++];
		}
		
		while (p2 <= right) {
			temp[p3++] = list[p2++];
		}
		
		for (int i = 0; i < p3; i++) {
			list[left + i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		int[] temp = new int[list.length];
		
		mergeSort(list, 0, list.length - 1, temp);
		for (int i = 0; i < list.length; i ++) {
			System.out.print(list[i] + " ");
		}
	}
}
