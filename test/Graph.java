package test;

import graph.*;
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
        Map<Agent, Node> a = new HashMap<>();
        //we have a shit ton of topics
        // we have a shit ton of agents
        // I want to run on all topics and Agents
        // then create a node for every Agent and Topic, each attached to its other 
        createTopicNodes(t.iterator(),a);//creates topics and attaches their subs
    }    
    
    private void createTopicNodes(Iterator<Topic> i, Map<Agent,Node>a) {
        HashSet<String> strSet=new HashSet<>();
        while(i.hasNext()){
            Topic t=i.next();
            Node nT=new Node("T"+t.name);
            for(Agent s1:t.subs){
                if(!a.containsKey(s1)){
                    Node add=new Node("A"+s1.getName());
                    a.put(s1,add);
                    nT.addEdge(add);
                    this.add(add);
                    strSet.add(add.getName());
                }else{
                    nT.addEdge(a.get(s1));
                }
            }
            for(Agent s2:t.pubs){
                if(!strSet.contains("A"+s2.getName())){
                    Node add=new Node("A"+s2.getName());
                    a.put(s2,add);
                    add.addEdge(nT);
                    this.add(add);
                    strSet.add(add.getName());
                }else{
                    a.get(s2).addEdge(nT);
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
