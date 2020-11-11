import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex04_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input_data=br.readLine();

        int row=input_data.charAt(1)-'0';
        int column=input_data.charAt(1)-'a'+1;

        int[][] steps={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,-}};

        int result=0;

        for(int i=0;i<8;i++){
            int next_row=row+steps[i][0];
            int next_column=column+steps[i][1];

            if(1<=next_row && next_row<=8 && 1<=next_column && next_column<=8)
                result++;
        }

        System.out.println(result);
    }
}

// #a1