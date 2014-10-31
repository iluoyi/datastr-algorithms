package leetcode;

public class FindMinInRotatedSortedArrayII {
	/**
	 * may contain duplicates!!
	 * 
	 * O(n)
	 */
	public int findMin(int[] num) {
		if(num == null || num.length == 0) {
            return -1; // should throw an exception, not sure if leetcode supports it
        }
        int l = 0;
        int r = num.length-1;
        while(l < r) {
            if(num[l] < num[r]) {
                return num[l];
            }
            int m = l + (r-l)/2;
            if(num[l] > num[m]) {
                r = m;
            } else if(num[l] < num[m]) {
                l = m+1;
            } else { // num[l] == num[m]
                if(num[l] == num[r]) {
                    l++;
                    r--;
                } else { // only the num[l] == num[m] >  num[r] case left
                    l = m+1;
                }
            }
        }
        return num[l];
	}
	
	/**
	 * O(n) / O(1)
	 * 
	 */
	public int findMinAC(int[] num) {
		if (num != null && num.length > 0) {
			int left = 0, right = num.length - 1;
			int mid = 0;
		   
			while (left < right) {
				if (num[left] < num[right]) {
					return num[left];
				}
				// else: num[left] >= num[right]
				mid = left + (right - left) / 2;
				if (num[mid] > num[right]) { // i.e. num[mid] >= num[left] > num[right]
					left = mid + 1;
				} else if (num[mid] < num[left]) { // i.e. num[mid] < num[left] >= num[right]
					right = mid;
				} else { // i.e. num[mid] == num[left] == num[right]
					left ++;
					right --;
				}
			}
			return num[left];
		}
		return -1;
	}
	
	public int findMinACClean(int[] num) {
		if (num != null && num.length > 0) {
			int left = 0, right = num.length - 1;
			int mid = 0;
		   
			while (left < right && num[left] >= num[right]) {
				mid = left + (right - left) / 2;
				if (num[mid] > num[right]) { // i.e. num[mid] >= num[left] > num[right]
					left = mid + 1;
				} else if (num[mid] < num[left]) { // i.e. num[mid] < num[left] >= num[right]
					right = mid;
				} else { // i.e. num[mid] == num[left] == num[right]
					left ++;
					right --;
				}
			}
			return num[left];
		}
		return -1;
	}
	
	public static void main(String args[]) {
		FindMinInRotatedSortedArrayII solution = new FindMinInRotatedSortedArrayII();
		int[] num = {3, 3, 1};
		System.out.println(solution.findMin(num));
	}
}
