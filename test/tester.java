package test;

public class tester {
    public static void main(String[] args) {
        Node n1=new Node("A");
        Node n2=new Node("B");
        Node n3=new Node("C");
        Node n4=new Node("D");
        Node n5=new Node("E");
        Node n6=new Node("F");
        n1.addEdge(n2);
        n1.addEdge(n3);
        n2.addEdge(n6);
        n2.addEdge(n5);
        n2.addEdge(n4);
        n3.addEdge(n1);
        System.out.println(n1.hasCycles());
        System.out.println(n2.hasCycles());
        
    }
}
