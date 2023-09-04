import java.util.Arrays;

public class RowColSorted {
	public static void main(String[] args) {
		
		int[][] arrRowCol = {
				{10,20,30,40},
				{15,25,35,45},
				{28,29,37,49},
				{33,34,38,50}
				};
		int[][] arrRow = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		
		
		System.out.println(Arrays.toString(search(arrRowCol, 37)));
		
		System.out.println(Arrays.toString(sortedSearch(arrRow, 0)));
	}
	
	static int[] search(int[][] arr, int target) {
		
		int len = arr.length;
		int row = 0;
		int col = len-1;
		
		while(row >= 0 && row < len && col >= 0 && col < len) {
			
			int no = arr[row][col];
			
			if(no == target) {
				return new int[] {row,col};
			}
			else if(target < no) { // target cannot reside on that column which has greater elements than the cur no
				col--;
				continue;
			}
			else if(target > no) { // which means the answer cannot reside on that row 
				row++;
				continue;
			}
		}
		return new int[] {-1,-1};
	}
	static int[] binarySearch(int[][] arr, int row ,int cStart, int cEnd, int target) {
		
		while(cStart <= cEnd) {
			
			int cMid = cStart + (cEnd - cStart)/2;
			int no = arr[row][cMid];
			
			if(no  == target) {
				return new int[] {row,cMid};
				
			}else if(target > no ) {
				cStart = cMid+1;
			}else {
				cEnd = cMid -1;
			}
		}
		return new int[] {-1,-1};
	}
	
	static int[] sortedSearch(int[][] arr, int target) {
		
		int len = arr.length;
		int rStart = 0;
		int rEnd = len-1;
		int cStart = 0;
		int cEnd = len-1;
		
		if (cEnd == 0){
            return new int[] {-1,-1};
        }
		if (rEnd == 1) {
            return binarySearch(arr , 0, 0, cEnd, target);
        }
		
		int cMid = (cStart + cEnd)/2;
		
		// run the loop till 2 rows are remaining
		while(rStart < (rEnd-1)) {
			int rMid = (rStart + rEnd)/2;
			
			if( arr[rMid][cMid] == target) {
				return new int[] {rMid,cMid}; 
				
			}else if(target > arr[rMid][cMid]) {
				rStart = rMid;
			}else {
				rEnd = rMid;
			}
		}
		
		// now we have two rows
        // check whether the target is in the col of 2 rows
		if (arr[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (arr[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }
        
        // search in 1st half
        if(target <= arr[rStart][cMid - 1]) {
        	return binarySearch(arr, rStart, cStart, cMid-1, target);
        }
        // search in 2nd half
        if(target >= arr[rStart][cMid + 1] && target <= arr[rStart][cEnd]) {
        	return binarySearch(arr, rStart, cMid+1, cEnd, target);
        }
        // search in 3rd half
        if(target <= arr[rEnd][cMid - 1]) {
        	return binarySearch(arr, rEnd, cStart, cMid-1, target);
        }
        // search in 4th half
        if(target >= arr[rEnd][cMid + 1] && target <= arr[rEnd][cEnd]) {
        	return binarySearch(arr, rEnd, cMid+1, cEnd, target);
        }
		
		return new int[] {-1,-1};
	}
	
}
