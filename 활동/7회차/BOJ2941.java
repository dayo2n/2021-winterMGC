package algorithm;

import java.io.*;

public class BOJ2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] croatia = { "c=", "c-", "d-", "lj", "nj", "s=", "z=" };
		int idx = 0;
		int cnt = 0;
		while (true) {
			if (idx == input.length() - 1) {
				cnt++;
				idx++;
			}
			if (idx >= input.length())
				break;
			String tmp;
			boolean flag3 = false;
			if (idx + 3 <= input.length()) {
				tmp = input.substring(idx, idx + 3);
				if (tmp.equals("dz=")) {
					idx += 3;
					flag3 = true;
				}
			}
			if (!flag3) {
				tmp = input.substring(idx, idx + 2);
				boolean tmpFlag = false;
				for (int i = 0; i < croatia.length; i++) {
					if (croatia[i].equals(tmp)) {
						tmpFlag = true;
						idx += 2;
						break;
					}
				}
				if (!tmpFlag) {
					idx++;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}