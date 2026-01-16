package configs;

import graph.BinOpAgent;
import graph.Message;

public class PlusAgent extends BinOpAgent{

    public PlusAgent(String[] subs, String[]pubs){
        super("PlusAgent: "+subs[0]+"+"+subs[1]+"="+pubs[0], subs[0], subs[1], pubs[0], (x,y)->(x+y));
    }
    
    public String getName(){
        return super.getName();
    }
    public void reset(){
        super.reset();
    }
    public void callback(String topic, Message msg){
        super.callback(topic, msg);
    }
    
    public void close(){
        super.close();
    }
    
}
