package com.String;

import java.util.ArrayList;

public class SubArray {
	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int start=0;
        int end=0;
        boolean flag=false;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>=s){
                end=i;
                while(sum>s && start<end){
                sum-=arr[start];
                start++;
                }
                
                if(sum==s){
                	result.add(start+1);
                	result.add(end+1);
                	flag=true;
                	break;
                }
            }
        }	
        if(flag==false){
            result.add(-1);
        }
        return result;
}
	public static void main(String[] args) {
		int n = 5;
		int s = 12;
		int arr[] = {1,2,3,7,5};
		ArrayList<Integer> aList=subarraySum(arr, n, s);
		for(Integer l:aList) {
			System.out.print(l+" ");
			
		}
	}

}
