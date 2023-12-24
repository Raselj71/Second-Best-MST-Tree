/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secondbestspanningtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SecondMstGraph {
    
        int V,E;
         int leader[];
         
         public  SecondMstGraph(int v, int e){
             V=v;
             E=e;
             
             leader=new int[V];
         }
         
         
    int find(int n){
        return leader[n];
    }
     
     void union(int rootU,int rootV){
        int newLeader;
        if(rootU<rootV){
            newLeader=rootU;
            for(int i=0; i<V; i++){
                if(leader[i]==rootV){
                    leader[i]=newLeader;
                }
            
        }
        }else{
            newLeader=rootV;
            for(int i=0; i<V; i++){
                if(leader[i]==rootU){
                    leader[i]=newLeader;
                }
            }
        }
        
        
        
    }
    
     
     
  List<SecondGraph> SecondMst(List<SecondGraph> list){
         
         Collections.sort(list);
         ArrayList<SecondGraph> Result=new ArrayList<>();
         
         for(int i=0; i<V ; i++){
             leader[i]=i;
         }
         
         for(int i=0; i<list.size(); i++){
             SecondGraph graph= list.get(i);
             
             int x= find( graph.getSrc());
             int y= find(graph.getDest());
             
           
             
            if(x!=y){
                Result.add(graph);
                union(x,y);
            }
         }
         
         
          return Result;
         
     }
        
    
}
