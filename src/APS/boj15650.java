package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
    static int n,m;
    static int[] arr;
    static int[] choosen;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        choosen = new int[m];

        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        // 수열의 개수 구하기
        // 1. 1부터 n까지 자연수 중에서 "중복없이" m개 선택
        // 2. 오름차순 -> 순서가 중요
        // -> permutation 만들기

        perm(0);
    }

    private static void perm(int level) {

        if(level == m) {
            for (int i = 0; i<m; i++) {
                System.out.print(choosen[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(level >0 && arr[i] < choosen[level-1]) continue;
                choosen[level] = arr[i];
                visited[i] = true;
                perm(level+1);
                visited[i] = false;
            }
        }
    }
}
