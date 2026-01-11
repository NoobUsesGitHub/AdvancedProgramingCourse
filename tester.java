

import graph.*;
import test.*;

public class tester {
    public static void main(String[] args) {
        BinOpAgent A1=new BinOpAgent("A", "in1","in2" ,"out2",(x,y)->x+y);
        Topic in1=   TopicManagerSingleton.get().getTopic("in1");
        Topic in2=   TopicManagerSingleton.get().getTopic("in2");
        
        BinOpAgent A2=new BinOpAgent("B", "in2","out2" ,"out1",(x,y)->x*y);

        Graph g=new Graph();
        // printAgent p=new printAgent("out1");
        g.createFromTopics();
        in1.publish(new Message(1));        
        in2.publish(new Message(99));

    }
}
