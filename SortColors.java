/**
 * Three cases:
 * 1) If the current is 0, swap it to left. Move BOTH left and current by 1;
 * 2) If the current is 1, no swap needed. Move ONLY current by 1;
 * 3) If the current is 2, swap it to right. Move ONLY right by 1!!! This is because the right element swapped to current may be 0, so we may need to swap it further to left, so we need one more iteration to handle it, and must not move current at this iteration.
 **/
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int left = 0;
        int right = A.length - 1;
        int p = 0;
        
        while (p <= right) {
            if (A[p] < 1) {
                swap(A, p, left);
                left++;
                p++;
            }
            else if (A[p] == 1) {
                p++;
            }
            else {
                swap(A, p, right);
                right--;
            }
        }
    }
    
    private void swap(int[] A, int a, int b) {
        if (A == null || A.length == 0 || a < 0 || b >= A.length) {
            return;
        }
        
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}