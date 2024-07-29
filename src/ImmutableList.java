import java.util.ArrayList;
import java.util.List;

import Interface.ClientInterface.IImmutableList;

public class ImmutableList implements IImmutableList{

    private List<Integer> overallList = new ArrayList<>();

    // Creating a list from a set of integers
    public ImmutableList(int[] array){

        List<Integer> list =  new ArrayList<>();
        for (int i: array){
            list.add(i);
        }

        overallList.addAll(list);
    }

    // Creating a list from another ImmutableList

    public ImmutableList(IImmutableList otherList){

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < otherList.size(); i++){
            
            list.add(otherList.get(i));
        }

        overallList.addAll(list);
    }

    @Override
    public int get(int i){return overallList.get(i); }

    @Override
    public IImmutableList concat(IImmutableList list){

        List<Integer> halfList = new ArrayList<>(this.overallList);

        for (int i = 0; i < list.size(); i++){

            halfList.add(list.get(i));

        }
        // I either have to make a new constructory for Lists or turn this list into an array
        // In this case I chose the latter, but i'm required to add extra steps to swap from Integer to int
        // Credit: https://stackoverflow.com/questions/960431/how-can-i-convert-listinteger-to-int-in-java
        return new ImmutableList(halfList.stream().mapToInt(i -> i).toArray());

    }

    @Override
    public int size(){
        return overallList.size();
    }

}