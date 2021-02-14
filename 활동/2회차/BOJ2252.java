package algorithm;

import java.util.*;
import java.io.*;

public class BOJ2252 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // number of student
		int m = Integer.parseInt(st.nextToken()); // num of compare

		// A B = > A가 B보다 작음 (앞에 서야해)

		ArrayList[] li = new ArrayList[n + 1];
		int[] pre = new int[n + 1]; // 선행자 수를 담아줄 , 인덱스로 학생번호 구분

		for (int i = 1; i <= n; i++) {
			li[i] = new ArrayList<Integer>();// 일단 학생들로 리스트 만들어주고(아직 비교안해서 진입차수 0)
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a is predecessor for b
			li[a].add(b);
			pre[b]++;
		}

		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();// 위상정렬 처리해줄 스택
		for (int i = 1; i <= n; i++)
			if (pre[i] == 0) // 선행자없는거부터 스택에 넣어주고
				stack.push(i);

		while (!stack.isEmpty()) {
			sb.append(stack.peek() + " ");
			int tmp = stack.pop();

			for (int i = 0; i < li[tmp].size(); i++) {
				int next = (int) li[tmp].get(i);
				pre[next]--;
				if (pre[next] == 0)
					stack.push(next);
			}
		}
		System.out.println(sb);
	}
}

