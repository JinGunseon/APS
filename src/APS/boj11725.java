package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }

        // 연결리스트
        for(int i =0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // BFS를 통해서 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = 1;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int next: tree[curr]){
                if(parent[next] == 0){
                    parent[next] = curr;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =2; i<=n; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

    }
}
