package algorithm;

import java.util.*;
import java.io.*;

class Point2178 {
	int x, y;

	public Point2178(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ2178 {

	public static int n, m;
	public static int[][] maze;
	public static boolean[][] visited;
	public static int[] moveX = { -1, 0, 1, 0 };
	public static int[] moveY = { 0, -1, 0, 1 };

	public static void bfs(int x, int y, boolean[][] visited) {
		Queue<Point2178> queue = new LinkedList<Point2178>();

		queue.offer(new Point2178(x, y));

		while (!queue.isEmpty()) {
			Point2178 p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = p.x + moveX[i];
				int nextY = p.y + moveY[i];

				// 범위 벗어날때 예외처리

				if (nextX < 1 || nextY < 1 || nextX > n || nextY > m)
					continue;

				if (visited[nextX][nextY] || maze[nextX][nextY] == 0)
					continue;

				visited[nextX][nextY] = true;
				queue.add(new Point2178(nextX, nextY));
				maze[nextX][nextY] = maze[p.x][p.y] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j + 1] = str.charAt(j) - '0';
			}
		}

		visited[1][1] = true;
		bfs(1, 1, visited);

		System.out.println(maze[n][m]);
	}

}

