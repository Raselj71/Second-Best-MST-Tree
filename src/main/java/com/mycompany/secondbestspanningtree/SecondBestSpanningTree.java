

package com.mycompany.secondbestspanningtree;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SecondBestSpanningTree {
    
    
    public static void main(String[] args) {
        int size =Integer.MAX_VALUE;
        List<SecondGraph> minTree=new ArrayList<>();
        
         try {
            File file=new File("C:\\Users\\User\\Desktop\\rasel\\kruskal.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String[] firstLine = reader.readLine().split(" ");
            int node = Integer.parseInt(firstLine[0]);
            int edge = Integer.parseInt(firstLine[1]);
            
            ArrayList<SecondGraph> list=new ArrayList<>();
               
     
            
              for (int i = 0; i < edge; i++) {
                String[] line = reader.readLine().split(" ");
                int source = Integer.parseInt(line[0]);
                int destination = Integer.parseInt(line[1]);
                int weight=Integer.parseInt(line[2]);
                
                list.add(new SecondGraph(source, destination,weight));
                
                
                
            }
               ArrayList<SecondGraph> Mstlist=list;
              
              System.out.println("Minimum Spanning Tree is: ");
               SecondMstGraph MstGraph=new SecondMstGraph(node, edge);
                  List<SecondGraph>  mstnewList  =MstGraph.SecondMst(Mstlist);
                  
                         int mstcount=0;
                 for (int i = 0; i < mstnewList.size(); i++) {
                
                            System.out.println("Source :" +mstnewList.get(i).getSrc() + "    Destination : "+mstnewList.get(i).getDest()  + "    weight: "+ mstnewList.get(i).getWeight());
                               mstcount=mstcount+mstnewList.get(i).getWeight();
                     
                      }
                 System.out.println("Cost of Minimum Spanning Tree is: "+mstcount);
              
               System.out.println("\n \nSecond Minimum Spanning Tree is: ");
                     for(int i=0; i<list.size(); i++){
                         
                                  SecondGraph deleteValue=list.get(0);
                                  list.remove(0);
                                  SecondMstGraph secondMstGraph=new SecondMstGraph(node, edge-1);
                                  List<SecondGraph>  reList  =secondMstGraph.SecondMst(list);
                       
                           int cost=0;
                           for(SecondGraph obj: reList){
                               cost=cost+ obj.getWeight();
                               
                               
                           }
                           
                           if(size>cost){
                               size=cost;
                               
                               minTree.clear();
                               minTree=reList;
                           
                               
                           }
                           
                         
                         list.add(deleteValue);
                     }
                     
                     
                    
                     
                     
                 for (int i = 0; i < minTree.size(); i++) {
                
                            System.out.println("Source :" +minTree.get(i).getSrc() + "    Destination : "+minTree.get(i).getDest()  + "    weight: "+ minTree.get(i).getWeight());
               
                     
                      }
              
                       System.out.println("Cost of the second Min Tree is:"+size);
          
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
}
