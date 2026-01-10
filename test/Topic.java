package test;

import java.util.LinkedList;

public class Topic {
    public final String name;
    public LinkedList<Agent> subs;
    public LinkedList<Agent> pubs;
    
    Topic(String name){
        this.name=name;
        this.subs= new LinkedList<>();
        this.pubs= new LinkedList<>();
    }

    public void subscribe(Agent a){
        subs.add(a);
    }
    public void unsubscribe(Agent a){
        subs.remove(a);
    }

    public void publish(Message m)
    {
        for( Agent sub : subs){
            sub.callback(this.name, m);

        }
    }

    public void addPublisher(Agent a){
        pubs.add(a);
    }

    public void removePublisher(Agent a){
        pubs.remove(a);
    }
}
