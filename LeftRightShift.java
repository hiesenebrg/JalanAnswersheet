import java.util.Collections;

public class LeftRightShift {
    public static int[] reverse(int[] arr  , int start  , int end  ){
        
        for (int i = start; i <=(start  + end)/2; ++i) {
            int temp  = arr[i];
            arr[i] = arr[end+start-i];
            arr[end+start-i]  = temp;
            
            
            
        }
        return arr;
    }
public static int[] asnwer(int[] arr , int p , int d) {
    if(d==0){ 
        //for left shift
        reverse(arr, 0 , arr.length-1);
        reverse(arr,0 ,  p-1);
        reverse(arr, p , arr.length-1);
    }else{ 
        //for right shift
        for(int i = 0; i < p; i++){    
            int j, last;    
            last = arr[arr.length-1];    
            
            for(j = arr.length-1; j > 0; j--){    
                arr[j] = arr[j-1];    
            }    
            arr[0] = last; 
    }
}    
    return arr;
   
}
   public static void main(String[] args) {
    int[] arr = {1,3,2,7,4,6};
    int[] ans = asnwer(arr , 1,0 );
    System.out.println();
    for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i] + " ");
    }
   } 
}