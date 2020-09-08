public class BubbleSort implements Runnable{  
    private int[] arr;  
    private Frame frame;  
      
    public BubbleSort(int[] arr, Frame frame) {  
        this.arr = arr;  
        this.frame = frame;  
    }  
    //this is called in part of the start() method  
    public void run() {  
        int temp = 0;  
        boolean swapped = false;  
        for(int i = 0; i<arr.length-1; i++){  
            swapped = false;  
            for(int j = 1; j<arr.length-i; j++){  
                if (arr[j-1]> arr[j]){  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j]= temp;  
                    swapped = true;  
                }  
                frame.setWorkingBub(j);  
                frame.setComparingBub(j+1);  
                try {  
                    Thread.sleep(SortingAlgorithm.sortSleep);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (!swapped) break;  
        }  
        //sort is finished, sets boolean to true and checks if all are done  
        frame.bubDone = true;  
        frame.finish();  
    }  
}  
