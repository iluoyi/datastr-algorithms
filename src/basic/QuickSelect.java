package basic;

import java.util.Random;

public class QuickSelect {
	
	public static void main(String args[]) {
		int[] A = {4, 13, 2, 1, 5, 7, 9};
		QuickSelect solution = new QuickSelect();
		System.out.println(solution.quickselect(A, 4));
	}
	
	public int quickselect(int[] A, int k) {
		return quickselect(A, 0, A.length - 1, k - 1);
	}

	private int quickselect(int[] G, int first, int last, int k) {
		if (first <= last) {
			int pivot = partition(G, first, last);
			if (pivot == k) {
				return G[k];
			}
			if (pivot > k) {
				return quickselect(G, first, pivot - 1, k); // still k if not deleting the partial array
			}
			return quickselect(G, pivot + 1, last, k);
		}
		return Integer.MIN_VALUE;
	}

	// return the pivot index
		public static int partition(int[] list, int first, int last) {
			int pivot = list[first];
			int low = first + 1;
			int high = last;
			
			while (high > low) {
				while (low <= high && list[low] <= pivot) {
					low++;
				}
				while (low <= high && list[high] > pivot) {
					high--;
				}
				
				if (high > low) {
					int temp = list[high];
					list[high] = list[low];
					list[low] = temp;
				}
			}
			
			while (high > first && list[high] >= pivot) {
				high --;
			}
			
			if (pivot > list[high]) {
				list[first] = list[high];
				list[high] = pivot;
				return high;
			} else {
				return first;
			}
		}
}
