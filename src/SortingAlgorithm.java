import java.util.Random;
  
/* 
 * selection sort - finds the min and puts it at the end, +1
 * insertion sort - puts in correct known elements position, +1
 * bubble sort - swaps adjacent elements, +1
 */ 

public class SortingAlgorithm {  
    public static Frame frame;  
    //thread sleep time, for all the sorting algorithms  
    public static int sortSleep = 80;  
    //integer for the timer which renders the array's rectangles on the frame.  
    public static int renderSleep = 80;  
    static Thread selection;  
    static Thread insertion;  
    static Thread bubble;  
    //arr1 = selection sort  
    static int [] arr1 = new int[50];  
    //arr2 = insertion sort  
    static int [] arr2 = new int[50];  
    //arr3 = bubble sort  
    static int [] arr3 = new int[50];  
      
    public static void main(String[] args) {  
        //setups arrays  
        resetArray();  
        //starts frame  
        frame = new Frame(arr1, arr2, arr3);  
    }  
    public static void resetArray(){  
        //makes arrays of 1-50  
        for (int i = 0; i<50;i++)   
            arr1[i] = i+1;  
        for (int i = 0; i<50;i++)   
            arr2[i] = i+1;  
        for (int i = 0; i<50;i++)   
            arr3[i] = i+1;  
        //shuffles arrays  
        shuffle(arr1);  
        shuffle(arr2);  
        shuffle(arr3);  
    }  
    public static void shuffle(int[] arr) {  
        //picks a random position in the array places index from position i there  
        Random rand = new Random();  
        for (int i=0; i<arr.length; i++) {  
            int randPos = rand.nextInt(arr.length);  
            int temp = arr[i];  
            arr[i] = arr[randPos];  
            arr[randPos] = temp;  
        }  
    }  
    public static void startSort(){  
        //resets array.   
        //TODO: This creates a bug where a the initial array shown is cleared for a new array  
        //      this could be fixed by removing resetArray() and having previous threads interrupted on click of the "sort" button  
        selection = new Thread(new SelectionSort(arr1, frame));  
        selection.start();  
        insertion = new Thread(new InsertionSort(arr2, frame));  
        insertion.start();  
        bubble = new Thread(new BubbleSort(arr3, frame));  
        bubble.start();  
    }  
} 
