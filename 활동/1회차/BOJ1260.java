package algorithm;

import java.util.*;
import java.io.*;

public class BOJ1260 {

	public static int vertex;
	public static LinkedList<Integer>[] graph;

	public static void dfs(int node, boolean[] visited, StringBuffer sb) {
		if (visited[node])
			return;
		visited[node] = true;
		sb.append(node + " ");

		for (int nextNode : graph[node]) {
			dfs(nextNode, visited, sb);
		}
	}

	public static void bfs(int node, boolean[] visited, StringBuffer sb) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(node);

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (visited[node])
				continue;

			visited[node] = true;
			sb.append(node + " ");

			for (int nextNode : graph[node])
				queue.add(nextNode);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int rootNode = Integer.parseInt(st.nextToken());

		graph = new LinkedList[vertex + 1];

		for (int i = 1; i <= vertex; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int head = Integer.parseInt(st.nextToken());
			int tail = Integer.parseInt(st.nextToken());

			graph[head].add(tail);
			graph[tail].add(head);
			
			Collections.sort(graph[head]);
			Collections.sort(graph[tail]);
		}
		StringBuffer dfsSB = new StringBuffer();
		StringBuffer bfsSB = new StringBuffer();
		
		boolean [] dfsVisited = new boolean[vertex+1];
		boolean [] bfsVisited = new boolean[vertex+1];
		
		dfs(rootNode, dfsVisited, dfsSB);
		bfs(rootNode, bfsVisited, bfsSB);
		
		System.out.println(dfsSB);
		System.out.println(bfsSB);
	}

}