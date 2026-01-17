package configs;

import graph.Agent;
import graph.Message;
import graph.TopicManagerSingleton;

public class PlusAgent implements Agent{

    private String AgentName;
    private String firstTopicName;
    private String secondTopicName;
    private String outputTopicName;
    
    private double v1;
    private double v2;
    private boolean v1Exist;
    private boolean v2Exist;

    public PlusAgent(String[] subs, String[]pubs){
        if(subs.length<2||pubs.length<1){
            System.out.println("bad input");
            throw(new IllegalArgumentException());
        }
            this.AgentName="PlusAgent: "+subs[0]+"+"+subs[1]+"="+pubs[0];
        
            this.firstTopicName=subs[0];
            this.secondTopicName=subs[1];
            this.outputTopicName=pubs[0];
            this.reset();
            TopicManagerSingleton.get().getTopic(this.firstTopicName).subscribe(this);
            TopicManagerSingleton.get().getTopic(this.secondTopicName).subscribe(this);
            TopicManagerSingleton.get().getTopic(this.outputTopicName).addPublisher(this);
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
        this.v2=0;
        this.v1Exist=false;
        this.v2Exist=false;
    }
    
    @Override
    public void callback(String topic, Message msg)
    {
        if(topic.equals(this.firstTopicName)){
            if(!Double.isNaN(msg.asDouble)){
                this.v1=msg.asDouble;
                this.v1Exist=true;
            }
            else
                return;
        }
        if(topic.equals(this.secondTopicName))
        {
            if(!Double.isNaN(msg.asDouble)){
                this.v2=msg.asDouble;
                this.v2Exist=true;
            }
            else
                return;
        }
        //if(topic.equals(this.secondTopicName)){}
        if(v1Exist&&v2Exist){
            Double result =v1+v2;
            TopicManagerSingleton.get().getTopic(this.outputTopicName).publish(new Message(result));
        }
    }


    @Override
    public void close()
    {
        TopicManagerSingleton.get().getTopic(this.firstTopicName).unsubscribe(this);
        TopicManagerSingleton.get().getTopic(this.secondTopicName).unsubscribe(this);
        TopicManagerSingleton.get().getTopic(this.outputTopicName).removePublisher(this);
    }
    
}

