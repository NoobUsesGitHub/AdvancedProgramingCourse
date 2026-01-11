package test;

import graph.Message;
import java.util.*;


public class Node {
    private String name;
    private List<Node> edges;
    private Message msg;

    public Node(String inputName){
        this.name=inputName;
        this.edges=new ArrayList<>();
        this.msg=null;
    }

    public void addEdge(Node n){
        this.edges.add(n);
    }

  
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getEdges() {
        return edges;
    }

    public void setEdges(List<Node> edges) {
        this.edges = edges;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
    


}