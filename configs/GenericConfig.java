package configs;

import graph.Agent;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class GenericConfig {
    private String name;
    private ArrayList<Agent> agents;
    private ArrayList<String> dataList;

    public GenericConfig(){
        this.name=null;
        this.agents=new ArrayList<>();
        this.dataList=null;
    }

    public void create(){
        //create the agents from dataList
        Constructor cons;
        for(int i=0;i<=this.dataList.size()-3;i=i+3){
            try{
                cons=(Class.forName(this.dataList.get(i)).getConstructor(String[].class,String[].class));
                Agent a= ((Agent)cons.newInstance(this.dataList.get(i+1).split(","), this.dataList.get(i+2).split(",")));                
                this.agents.add(new ParallelAgent(a));
            }catch(Exception e){
                e.printStackTrace();
            }
            
    }






    }



    public String getName(){
        return this.name;
    }
    public int getVersion(){
        return 1;
    }

    public void close(){
        for (Agent a: this.agents){
            a.close();
        }
    }

    public void setConfFile(String confFile){
        this.name=confFile;
        ArrayList<String> data=new ArrayList<>();

        try(BufferedReader b=new BufferedReader(new InputStreamReader(new FileInputStream(confFile)))){
            String line;
            while((line=b.readLine())!=null){
                data.add(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        if(data.size()%3!=0){
            System.out.println("something went wrong");
            (new EOFException()).printStackTrace();
            return;
        }
        this.dataList=data; 
    }

}
