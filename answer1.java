import java.util.Collections;

public class answer1 {
    public static int[] reverse(int[] arr  , int start  , int end  ){
        
        for (int i = start; i <=(start  + end)/2; ++i) {
            int temp  = arr[i];
            arr[i] = arr[end+start-i];
            arr[end+start-i]  = temp;
            
            
            
        }
        return arr;
    }
public static int[] asnwer(int[] arr , int p , int d) {
    
         reverse(arr, 0 , arr.length-1);
        
         reverse(arr,0 ,  p-1);
       


        reverse(arr, p , arr.length-1);
        

      
    
    return arr;
   
}
   public static void main(String[] args) {
    int[] arr = {1,3,2,7,4,6};
    int[] ans = asnwer(arr , 3,0 );
    System.out.println();
    for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i] + " ");
    }
   } 
}