
// NOTE!!!  HERE WE FOCUS ON GETTING UNIQUE DUPLICATES NOT REMOVE THEM

package duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/*
  	Input:
		N = 4
		a[] = {0,3,1,2}
	Output: 
		-1
		
	Input:
		N = 7
		a[] = {2,3,1,2,3,2,3}
	Output: 
		2 3  (should not be 3,2 or 2,2,3,3)
	Explanation: 
		2 and 3 occur more than once in the given array.
 */

public class GetDuplicates0toN {
	
	public static void main(String[] args) {
		int[] arr ={2,0,3,3,1};
		
		System.out.println(duplicates(arr,arr.length)); // 0 1 2 2 3 3
		
	}
	
	// BRUTEFORCE - sorting them twice here (since output is sorted)
	public static ArrayList<Integer> duplicates(int arr[], int n) {
        
		 
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        // cyclic sort
        int i = 0;
        while(i < n){
            int no = arr[i];
            int pos = no;
            if( arr[i] != arr[pos]){
                swap(arr, i ,pos);
            }
            else if( i != pos){
                li.add(pos); //since pos is the number or arr[i]
                i++;
            }
            else{
                i++;
            }
        }
        
        if(li.isEmpty()){
            li.add(-1);
            return li;
        }
        Collections.sort(li);
        
        // remove duplicates
        for(i=0 ; i < li.size()-1 ; i++ ){
            int num = li.get(i);
            if(num != li.get(i+1)){
                ans.add(num);
            }
        }
        ans.add(li.get(li.size()-1)); // adding last element
        return ans;
    }
	
	// METHOD : 2
    public static ArrayList<Integer> duplicates2(int arr[], int n) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        // sort
        Arrays.sort(arr); // inplace sorting
        
       // Arrays.sort(arr, Collections.reverseOrder()); for reverse sorted array output
        
        
        
        // gets duplicates but they all duplicates available ( we need only unique duplicates ) not 2 2 3 3 4 4 
//        for(int i=0 ; i < arr.length-1 ; i++ ){
//            int num = arr[i];
//            if(num == arr[i+1]){
//                ans.add(num);
//            }
//        }

        // 1 2 2 2 2 3 4 5 5 5 5
        int num = arr[0];
        for(int i=1 ; i < arr.length-1 ; i++ ){
            if(num == arr[i] && arr[i] != arr[i+1]){
                ans.add(num);
            }else {
            	num = arr[i];
            }
        }
        if(arr[n-1] == arr[n-2]) {
        	ans.add(arr[n-1]);
        }
       
        
        if(ans.isEmpty()) ans.add(-1);
        
        return ans;
    }
    
 // METHOD : 3 ( Flagging duplicates method ) (BEST SO FOR)
    public static ArrayList<Integer> duplicates3(int arr[], int n) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        // sort
        Arrays.sort(arr); // inplace sorting
        

        // 1 2 2 2 2 3 4 5 5 5 5
        int c = 0;
        for(int i=1 ; i < arr.length ; i++ ){
        	
            if(c == 0 && arr[i] == arr[i-1]){
                ans.add(arr[i]);
                c = 1; //flagging
                
            }else if ( c == 1 && arr[i] != arr[i-1] ){ //reset flag on non duplicate
            	c = 0; 
            }
        }
       
        if(ans.isEmpty()) ans.add(-1);
        
        return ans;
    }
    
    // METHOD 4
    public static ArrayList<Integer> duplicates4(ArrayList<Integer> list , int n){
        
        Collections.sort(list);
        
        ArrayList<Integer> li = new ArrayList<Integer>();
        
        Set<Integer> s = new LinkedHashSet<Integer>(list); 
        
        li.addAll(s);
        
        return li;
    }
    
    
    // METHOD 5 HASHMAP
    public static ArrayList<Integer> duplicates5(int arr[], int n) {
    	
    	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
        	int num = arr[i];
        	if(map.get(num) == null) {
        		map.put(num, true);
        	}else if(map.get(num) == true){        		
        		ans.add(num);
        		map.put(num, false); // once added / set to false cannot add again
        	}
        }
       
        if(ans.isEmpty()) ans.add(-1);
        
        return ans;
    }
    public static void swap(int[] arr , int f , int s){
        int t = arr[f];
        arr[f] = arr[s];
        arr[s] = t;
    }
    
    
    // TO GET UNIQUE ALONE 
    // get unique inplace
//    int j = 0;
//    for(int i=1 ; i<arr.length ; i++){
//        if(arr[i] != arr[i-1]){
//            arr[j++] = arr[i];
//        }
//    }
    // j is the new length

}
