package algorithm;

import java.io.*;
import java.util.*;

public class BOJ17298 {

	static int n;
	static Stack<Integer> stack;
	static Stack<Integer> poppedStack;

	public static int NGE(int num, int idx) {

		Stack<Integer> tmpStack = poppedStack;
		;
		if (n > idx)
			while (true) {
				if (tmpStack.empty())
					return -1;
				else {
					if (tmpStack.peek() > num) {
						return tmpStack.peek();
					} else
						tmpStack.pop();
				}
			}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		poppedStack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] ans = new int[n];
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < n; i++)
			stack.push(Integer.parseInt(st.nextToken()));

		for (int i = 0; i < n; i++) {
			ans[i] = NGE(stack.peek(), i);
			poppedStack.push(stack.pop());
		}

		for (int i = n - 1; i >= 0; i--)
			sb.append(ans[i] + " ");
		System.out.println(sb);
	}
}