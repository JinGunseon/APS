package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj13235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int length = word.length();
        boolean flag = true;

        for(int i = 0; i<(length+1)/2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag);
    }
}
