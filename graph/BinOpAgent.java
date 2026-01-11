package graph;

import java.util.function.BinaryOperator;

public class BinOpAgent implements Agent{
    private String AgentName;
    private String firstTopicName;
    private String secondTopicName;
    private String outputTopicName;
    private BinaryOperator<Double> ope;


    private double v1;
    private double v2;
    private boolean v1Exist;
    private boolean v2Exist;
    
    public BinOpAgent( String AgentName,String firstTopicName,
        String secondTopicName,String outputTopicName,BinaryOperator<Double> ope){
            this.AgentName=AgentName;
            this.firstTopicName=firstTopicName;
            this.secondTopicName=secondTopicName;
            this.outputTopicName=outputTopicName;
            this.ope=ope;
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
            if(msg.asDouble!=Double.NaN){
                this.v1=msg.asDouble;
                this.v1Exist=true;
            }
            else
                return;
        }
        if(topic.equals(this.secondTopicName))
        {
            if(msg.asDouble!=Double.NaN){
                this.v2=msg.asDouble;
                this.v2Exist=true;
            }
            else
                return;
        }
        //if(topic.equals(this.secondTopicName)){}
        if(v1Exist&&v2Exist){
            Double result =this.ope.apply(v1,v2);
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
