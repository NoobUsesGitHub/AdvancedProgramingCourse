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
        if (!edges.contains(n)) edges.add(n);
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

    public boolean hasCycles(){
        HashSet<Node> visited=new HashSet<>();
        HashSet<Node> currentBranch= new HashSet<>();
        currentBranch.add(this);
        visited.add(this);
        return cycleChecker(this.edges.iterator(),visited,currentBranch);
    }

    public boolean cycleChecker(Iterator<Node> i,HashSet<Node> v,HashSet<Node> b)
    {
        if(!i.hasNext()){return false;}
        
        Node t=i.next();
        if(b.contains(t))
            return true;
        if(!v.contains(t))//didnt visit already
        {
            v.add(t);
            b.add(t);
            boolean foundInChild=cycleChecker(t.edges.iterator(),v,b);
            b.remove(t);
            if(foundInChild) return true;
        }
        return cycleChecker(i,v,b);
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