package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Graph extends ArrayList<Node>{
    
    public boolean hasCycles() {
        for(Node n:this){
            if(n.hasCycles())
                return true;    
        }
        return false;
    }

    public void createFromTopics(){
        this.clear();
        Collection<Topic> t=TopicManagerSingleton.get().getTopics();
        Map<String, Node> a = new HashMap<>();
        createTopicNodes(t.iterator(),a);//creates topics and attaches their subs
    }    
    
    private void createTopicNodes(Iterator<Topic> i, Map<String,Node>a) {
        while(i.hasNext()){
            Topic t=i.next();
            Node nT=new Node("T"+t.name);
            for(Agent s1:t.subs){
                String key = "A" + s1.getName();
                if(!a.containsKey(key)){
                    Node add=new Node(key);
                    a.put(key,add);
                    nT.addEdge(add);
                    this.add(add);
                }else{
                    nT.addEdge(a.get(key));
                }
            }
            for(Agent s2:t.pubs){
                String key = "A" + s2.getName();
                if(!a.containsKey(key)){
                    Node add=new Node(key);
                    a.put(key,add);
                    add.addEdge(nT);
                    this.add(add);
                }else{
                    a.get(key).addEdge(nT);
                }
            }
            this.add(nT);
        }
    }

    public HashSet<Agent> collectAgents(Iterator<Topic> i){
        HashSet<Agent> a=new HashSet<>();
        Topic t;
        while(i.hasNext()){
            t=i.next();
            a.addAll(t.pubs);
            a.addAll(t.subs);
        }
        return a;
    }
}
