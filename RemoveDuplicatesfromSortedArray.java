/**
 * We move p2 forward, at each position, we compare the element with the next one:
 *     1) if they are same, then continue move p2;
 *     2) otherwise copy p2 to p1, and move both p1 and p2 by 1. 
 * Finaly when p2 hits the last, return p1.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        // Validate input
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int p1 = 0;
        int p2 = 0;
        while (p1 < A.length && p2 < A.length) {
            while (p2 < A.length -1 && A[p2] == A[p2+1]) {
                p2++;
            }
            A[p1] = A[p2];
            p1++;
            p2++;
        }
        
        return p1;
    }
}