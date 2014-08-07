/**
 * This problem is equivalent to the problem of finding the total number of
 * different paths from the upper-left corner to the bottom-right corner in the
 * upper-right triangle of a square
 * 
 * How to solve:
 * 1. Use recursion to solve it
 * 2. Before and after each recursive call, add/delete parenthesis explicitly
 * 
 * Note: 
 * 1. To add a char to a StringBuilder, use append(), not add()
 * 2. To delete last char, use deleteCharAt(), not delete()
 * 3. Use StringBuilder instead of string concat, because 
 *     1) it is more efficient in terms of time and space
 *     2) the code is more understandable
 */
public class Solution {
	public List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return null;
		}

		List<String> res = new ArrayList<String>();

		generateParenthesisHelper(n, 0, 0, new StringBuilder(), res);

		return res;
	}

	private void generateParenthesisHelper(int n, int left, int right,
			StringBuilder parentheses, List<String> res) {
		if (left >= n && right >= n) {
			res.add(parentheses.toString());
			return;
		}

		if (left < n) {
			parentheses.append('(');
			generateParenthesisHelper(n, left + 1, right, parentheses, res);
			parentheses.deleteCharAt(parentheses.length() - 1);
		}

		if (right < left) {
			parentheses.append(')');
			generateParenthesisHelper(n, left, right + 1, parentheses, res);
			parentheses.deleteCharAt(parentheses.length() - 1);
		}
	}
}