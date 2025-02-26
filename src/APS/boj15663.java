package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj15663 {
    static int n, m;
    static int[] arr, choosen;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        choosen = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 사전순 출력을 위해 정렬
        perm(0);
        System.out.print(sb);
    }

    private static void perm(int level) {
        if (level == m) {
            for (int num : choosen) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 같은 depth에서 같은 숫자가 반복되지 않도록 체크
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true;
                choosen[level] = arr[i];
                prev = arr[i]; // 같은 depth에서 중복 방지
                perm(level + 1);
                visited[i] = false;
            }
        }
    }
}
