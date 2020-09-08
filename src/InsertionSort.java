public class InsertionSort implements Runnable{  
    private int[] arr;  
    private Frame frame;  
      
    public InsertionSort(int[] arr, Frame frame) {  
        this.arr = arr;  
        this.frame = frame;  
    }  
    //this is called in part of the start() method  
    public void run() {  
        int temp = 0;  
        int insert = 0;  
        for(int i = 1; i<arr.length; i++){  
            insert = i;  
            for(int j = i-1; j>=0; j--){  
                if (arr[i] < arr[j]){  
                    insert = j;  
                    if (j == 0){  
                        break;  
                    }  
                }else{  
                    break;  
                }  
                frame.setWorkingIns(i);  
                frame.setComparingIns(insert);  
                try {  
                    Thread.sleep(SortingAlgorithm.sortSleep);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
            temp = arr[i];  
            for (int j = i; j>insert; j--){  
                arr[j] = arr[j-1];  
            }  
            arr[insert] = temp;  
        }  
        //sort is finished, sets boolean to true and checks if all are done  
        frame.insDone = true;  
        frame.finish();  
    }  
} 
