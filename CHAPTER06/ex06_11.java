import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ex06_11 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(token.nextToken());
        List<Student> students=new ArrayList<>();
        for(int i=0;i<N;i++){
            token=new StringTokenizer(br.readLine());
            students.add(new Student(token.nextToken(), Integer.parseInt(token.nextToken())));
        }

        Collections.sort(students);

        for(int i=0;i<N;i++){
            System.out.print(students.get(i).getName()+" ");
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int key;

        public Student(String name, int key) {
            this.name = name;
            this.key = key;
        }

		@Override
		public int compareTo(ex06_11.Student o) {
			return this.key-o.key;
		}

        public String getName() {
            return name;
        }
    }
}

// 2
// 홍길동 95
// 이순신 77