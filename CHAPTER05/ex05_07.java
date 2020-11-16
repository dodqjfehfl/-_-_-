import java.util.ArrayList;

public class ex05_07 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> graph=new ArrayList<ArrayList<Node>>();

        for(int i=0;i<3;i++)
            graph.add(new ArrayList<Node>());

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        graph.get(0).add(new Node(0, 7));

        graph.get(0).add(new Node(0, 5));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }

    class Node{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public void show(){
            System.out.print("(" + this.index + "," + this.distance + ") ");
        }
    }
}
