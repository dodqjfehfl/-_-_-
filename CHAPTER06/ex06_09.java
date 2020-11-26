import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ex06_09 {
    public static void main(String[] args) {
        List<Fruit> fruits=new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for(int i=0;i<fruits.size();i++){
            System.out.println(fruits.get(i));
        }
    }

    static class Fruit implements Comparable<Fruit>{

        String name;
        int score;

		@Override
		public int compareTo(ex06_09.Fruit o) {
			return this.score-o.score;
		}

		public Fruit(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", score=" + score + "]";
		}
    }
}