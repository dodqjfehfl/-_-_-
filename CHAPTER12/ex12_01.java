import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex12_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int mid = str.length() / 2;

        int left = 0;
        int right = 0;

        for (int i = 0; i < mid; i++) {
            left += str.charAt(i) - '0';
            right += str.charAt(i + mid) - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}

// 123402

// LUCKY

// 7755

// READY