import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex12_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int sum = 0;
        int[] alp = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if ('0' <= c && c <= '9') { // 숫자
                sum += c - '0';
            } else {
                alp[c - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alp[i]; j++) {
                System.out.print((char) ('A' + i));
            }
        }
        System.out.print(sum);
    }
}

// K1KA5CB7

// ABCKK13

// AJKDLSI412K4JSJ9D

// ADDIJJJKKLSS20