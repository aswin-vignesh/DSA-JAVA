
public class BSMountainArrayFind {
	public static void main(String[] args) {
		int arr[] = {1,5,2};
		
		int target = 2;
		
//		System.out.println(findPeak(arr));
		int len = arr.length;
        //peak
        int peak = findPeak( arr);
        //search
        int ans = findOABS( target,  arr , 0 , peak);
        if(ans == -1){
            ans = findOABS( target,  arr , peak , len-1);
        }
        System.out.println(ans);
	}
	
	public static int findPeak(int[] arr){
        int len = arr.length-1;
        int s = 0;
        int e = len-1;

        while(s < e){
            int m = s+(e-s)/2; 

            if( arr[m]  > arr[m+1]){
                e = m;
            }
            if( arr[m] < arr[m+1]){
                s = m+1;
            }
        }
        return s;
    }
    public  static int findOABS(int target, int[] arr,int s , int e){

        boolean asc = arr[s] < arr[e];

        while(s <= e){
            int m = s+(e-s)/2; 
            if( arr[m] == target ){
                return m;
            }
            if( asc ){
                if(target > arr[m]){
                    s = m+1;
                }
                else{
                    e = m-1;
                }
            }
            else{
                if(target > arr[m]){
                    e = m-1;
                }
                else{
                    s = m+1;
                }
            }
        }
        return -1;
    }
}
