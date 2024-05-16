import java.util.*;
public class RotatePrimeLeft {

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){ 
                return false;
            }
        }
        return true;
    }

    static int[] fillArrayWithPrime(int size,int start){
        int arr[] =new int[size];
        int count=0;
        while (count<size) {
            if(isPrime(start)){
                arr[count]=start;
                count++;
            }
            start++;
        }
        return arr;
    }

    static void leftShiftArray(int[] arr,int shift){
       
        for(int i=0;i<shift;i++){
            int temp=arr[0];
            for(int j=0;j<arr.length-1;j++){
               arr[j]=arr[j+1]; 
            }
            arr[arr.length-1]=temp;
        }
        System.out.println("Array after"+shift+"left shifts"+Arrays.toString(arr));
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arrSize=sc.nextInt();
    int startingPoint=sc.nextInt();
    int shiftLeft=sc.nextInt();
   
    int [] array=fillArrayWithPrime(arrSize,startingPoint);
    System.out.println("Array before shift"+Arrays.toString(array));
    leftShiftArray(array,shiftLeft);
}
    
}
