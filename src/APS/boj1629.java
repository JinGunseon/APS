package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b, c));
    }

    // 분할 정복을 이용한 거듭제곱
    public static long pow(long a, long b, long c) {
        if (b == 0) return 1;  // A^0 = 1
        long half = pow(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;  // 홀수일 때 추가 곱셈
        return result;
    }
}