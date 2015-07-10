/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author douglasortega
 */
public class Process {
    
    private ArrayList<ArrayList<String>> array;
    private HashMap<String, Integer> vectors;
    
    public Process(ArrayList<ArrayList<String>> a){
        this.array = a;
        this.vectors = new HashMap<>();
    }
    
    public void createVectors(){
        int counter = 1;
        for(ArrayList<String> l: this.array){
            for(String i: l){
                if(!this.vectors.containsKey(i)){
                    this.vectors.put(i, counter++);
                }
            }
        }
        ValueComparator vc = new ValueComparator(vectors);
        TreeMap<String, Integer> tc = new TreeMap<>(vc);
        tc.putAll(vectors);
        System.out.println(tc);
    }
    
    public void createEdge(){
        
    }
    
    class ValueComparator implements Comparator<String> {

        HashMap<String, Integer> base;

        public ValueComparator(HashMap<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return 1;
            } else {
                return -1;
            } // returning 0 would merge keys
        }
    }
    
}
