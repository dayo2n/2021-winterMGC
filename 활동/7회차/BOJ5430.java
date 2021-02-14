package algorithm;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ5430 {

	static int tc;
	static boolean[] reverse;
	static boolean[] error;
	static StringBuffer sb;

	public static void Reverse(int idx) {
		if (reverse[idx]) // 역순 정렬로 되어있면 오름차순으로
			reverse[idx] = false;
		else
			reverse[idx] = true;
	}

	public static void Delete(Deque<Integer> num, int idx) {
		if (num.isEmpty())
			error[idx] = true;
		else {
			if (reverse[idx])
				num.pollLast();
			else
				num.pollFirst();
		}
	}

	public static void print(Deque<Integer> num, int idx) {
		if (num.isEmpty())
			sb.append("[]\n");
		else {
			if (reverse[idx]) {
				sb.append("[" + num.pollLast());
				while (!num.isEmpty())
					sb.append("," + num.pollLast());
			} else {
				sb.append("[" + num.pollFirst());
				while (!num.isEmpty())
					sb.append("," + num.pollFirst());
			}
			sb.append("]\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		tc = Integer.parseInt(br.readLine());
		reverse = new boolean[tc];
		error = new boolean[tc];

		Deque<Integer> arr = new LinkedList<Integer>();

		for (int i = 0; i < tc; i++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();
			arrStr = arrStr.substring(1, arrStr.length() - 1);
			String[] arrSplit = arrStr.split(",");

			arr.clear();

			for (int k = 0; k < n; k++) {
				arr.add(Integer.parseInt(arrSplit[k]));
			}

			for (int j = 0; j < command.length(); j++) {
				char order = command.charAt(j);
				if (order == 'R')
					Reverse(i);
				else {
					Delete(arr, i);
				}
			}

			if (error[i])
				sb.append("error\n");
			else
				print(arr, i);
		}
		System.out.println(sb);
	}
}

