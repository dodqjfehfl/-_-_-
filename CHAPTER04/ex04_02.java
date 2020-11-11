import java.io.*;

public class ex04_02 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int H=Integer.parseInt(br.readLine());
        
        int count=0;
        
        for(int i=0;i<H+1;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    if(check(i,j,k))
                        count++;
                }
            }
        }

        System.out.println(count);

    }

	private static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
		return false;
	}
}

//5