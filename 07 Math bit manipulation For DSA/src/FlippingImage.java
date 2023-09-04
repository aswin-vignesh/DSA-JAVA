// LEET : 832

public class FlippingImage {
	
	public static void main(String[] args) {
		
	}
	
	public  static int[][] flipAndInvertImage(int[][] image) {
        
        for(int i=0 ; i < image.length ; i++){

            // flip and swap
            int n = image[i].length;
            for(int j=0 ; j <= n/2 ; j++){

                if( j == n/2 ){
                    if((n&1) == 1){
                        invert(image,n,i,j);
                    }
                    continue;
                }
                int temp = image[i][j];
                image[i][j] = image[i][n-j-1];
                image[i][n-j-1] = temp;
                invert(image,n,i,j);
                invert(image,n,i,n-j-1);

            }
        }

        return image;
    }
    static void invert(int[][] a , int n, int i,int j){
    //     if(a[i][j] == 1){
    //         a[i][j] = 0;
    //         return;
    //     }
    //     a[i][j] = 1;
        a[i][j] = a[i][j] ^ 1;
    }
}
