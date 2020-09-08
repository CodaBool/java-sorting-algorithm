public class SelectionSort implements Runnable{  
    private int[] arr;  
    private Frame frame;  
      
    public SelectionSort(int[] arr, Frame frame) {  
        this.arr = arr;  
        this.frame = frame;  
    }  
    //this is called in part of the start() method  
    public void run() {  
        int temp = 0;  
        int selected = 0;  
        for(int i = 0; i<arr.length; i++){  
            selected = i;  
            for(int j = arr.length-1; j>i; j--){  
                if (arr[j] <= arr[selected])  
                    selected = j;  
                frame.setWorkingSel(selected);  
                frame.setComparingSel(j-1);  
                try {  
                    Thread.sleep(SortingAlgorithm.sortSleep);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }                 
            }  
            temp = arr[i];  
            arr[i] = arr[selected];  
            arr[selected] = temp;  
        }  
        //sort is finished, sets boolean to true and checks if all are done  
        frame.selDone = true;  
        frame.finish();  
    }  
} 
