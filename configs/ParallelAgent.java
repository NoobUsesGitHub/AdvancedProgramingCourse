package configs;

import graph.Agent;
import graph.Message;

public class ParallelAgent implements Agent{
    private Agent compAgent;

    public ParallelAgent(Agent compAgen){
        this.compAgent=compAgen;
    }

    @Override
    public String getName(){
        return this.compAgent.getName();
    }
    
    @Override
    public void reset(){
        this.compAgent.reset();
    }
    
    
    @Override
    public void callback(String topic, Message msg){
        this.compAgent.callback(topic, msg);
    }
    
    @Override  
    public void close(){
        this.compAgent.close();
    }
}
