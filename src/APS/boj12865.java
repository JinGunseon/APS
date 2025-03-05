package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weights = new int[N];
        int[] values = new int[N];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            weights[i] = W;
            values[i] = V;
        }

        int[][] dp = new int[N+1][K+1];
        for(int i =1; i<=N; i++) {
            for(int w =0; w<=K; w++) {
                if(weights[i-1] > w){
                    dp[i][w] = dp[i-1][w]; // 현재 물건을 넣지 못함
                } else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i-1]]+values[i-1]);
                }
            }
        }

        System.out.println(dp[N][K]);

        }
    }


