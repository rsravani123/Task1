package com.epam.de.dsalgo.pss.module2.recursion;

public class SolutionSumOfIntegers{
    /**
     * Given an array of integers, find the sum of all the integers using recursion.
     * if the input is invalid return 0.
     * @param input
     * @return
     */
    public int sumOfIntegers(int[] input) {
        if (input == null) {
            return 0;
        }
        return sumHelp(input, 0);
    }
    private int sumHelp(int [] array,int index){
        if(index >= array.length){
            return 0;
        }
       return array[index]+sumHelp(array,index+1);
    }
}
