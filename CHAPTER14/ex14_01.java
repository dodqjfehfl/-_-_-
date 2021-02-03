import java.io.*;
import java.util.*;

public class ex14_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;

        PriorityQueue<student> pq = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new student(token.nextToken(), Integer.parseInt(token.nextToken()),
                    Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }

    static class student implements Comparable<student> {
        String name;
        int korea;
        int math;
        int english;

        public student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.math = math;
            this.english = english;
        }

        @Override
        public int compareTo(ex14_01.student o) {
            if (this.korea != o.korea)
                return o.korea - this.korea;
            else {
                if (this.english != o.english)
                    return this.english - o.english;
                else {
                    if (this.math != o.math)
                        return o.math - this.math;
                    else {
                        // 이름순으로
                        return this.name.compareTo(o.name);
                    }
                }
            }
        }
    }
}

// 12
// Junkyu 50 60 100
// Sangkeun 80 60 50
// Sunyoung 80 70 100
// Soong 50 60 90
// Haebin 50 60 100
// Kangsoo 60 80 100
// Donghyuk 80 60 100
// Sei 70 70 70
// Wonseob 70 70 90
// Sanghyun 70 70 80
// nsj 80 80 80
// Taewhan 50 60 90

// Donghyuk
// Sangkeun
// Sunyoung
// nsj
// Wonseob
// Sanghyun
// Sei
// Kangsoo
// Haebin
// Junkyu
// Soong
// Taewhan