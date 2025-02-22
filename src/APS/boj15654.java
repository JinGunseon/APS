package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {
    static int n, m;
    static int[] arr;
    static boolean[] check;
    static int[] choosen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        choosen = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        perm(0, 0);
    }

    private static void perm(int level, int flag) {
        if (level == m) {
            for (int i = 0; i < choosen.length; i++) {
                System.out.print(choosen[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if ((flag & 1 << i) != 0) continue;
            choosen[level] = arr[i];
            perm(level + 1, flag | 1 << i);
//        }


//        for(int i = 0; i<arr.length; i++){
//            if(check[i] == false){
//                choosen[level] = arr[i];
//                check[i] = true;
//                perm(level+1);
//                check[i] = false;
//            }
//        }

        }
    }
}
