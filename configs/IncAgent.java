package configs;

import graph.Agent;
import graph.Message;
import graph.TopicManagerSingleton;

public class IncAgent implements Agent{

    private String AgentName;
    private String xTopic;
    private String output;
    private double v1;
    
    public IncAgent( String[]subs,String[] pubs){
            this.AgentName="IncAgent: "+subs[0]+"++ ="+pubs[0];
            this.v1=0;
            this.xTopic=subs[0];
            this.output=pubs[0];
            TopicManagerSingleton.get().getTopic(this.xTopic).subscribe(this);
            TopicManagerSingleton.get().getTopic(this.output).addPublisher(this);
        }
    
    
    @Override
    public String getName()
    {
        return this.AgentName;
    }
    
    @Override
    public void reset()
    {
        this.v1=0;
    }
    
    @Override
    public void callback(String topic, Message msg)
    {
        if(topic.equals(this.xTopic)){
            if(msg.asDouble!=Double.NaN){
                this.v1=msg.asDouble;
                TopicManagerSingleton.get().getTopic(this.output).publish(new Message(v1+1));
            }
        }
    }

    @Override
    public void close()
    {
        TopicManagerSingleton.get().getTopic(this.xTopic).unsubscribe(this);
        TopicManagerSingleton.get().getTopic(this.output).removePublisher(this);
    }

}
