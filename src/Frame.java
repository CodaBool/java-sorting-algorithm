import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.Timer;  
import javax.swing.WindowConstants;  
  
public class Frame extends JFrame {  
    static Timer timer;  
    //integers to signify the selected and working rectangle position in the array of the sort  
    //working is the rectangle which is currently being moved  
    //comparing is the rectangle which is being checked currently and compared to working  
    int workingSel = -1;  
    int comparingSel = -1;  
    int workingIns = -1;  
    int comparingIns = -1;  
    int workingBub = -1;  
    int comparingBub = -1;  
    //boolean to keep track of which threads are finished sorting  
    static boolean selDone = false;  
    static boolean insDone = false;  
    static boolean bubDone = false;  
    //arrays to copy Assignment 11's arrays into  
    int[] arr1;  
    int[] arr2;  
    int[] arr3;  
      
    //constructor for the frame  
    public Frame(int[] arr1, int[] arr2, int[] arr3){  
        super("Sorting Algorithm");  
        //arrays to copy Assignment 11's arrays into  
        this.arr1 = arr1;  
        this.arr2 = arr2;  
        this.arr3 = arr3;  
        setSize(1000, 350);    
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setLayout(null);  
        setVisible(true);  
        //labels for each of the arrays  
        JLabel selectionLabel = new JLabel("Selection Sort");     
        selectionLabel.setBounds(140,10,100,50);    
        add(selectionLabel);    
        JLabel insertionLabel = new JLabel("Insertion Sort");     
        insertionLabel.setBounds(460,10,100,50);    
        add(insertionLabel);    
        JLabel bubbleLabel = new JLabel("Bubble Sort");     
        bubbleLabel.setBounds(790,10,100,50);    
        add(bubbleLabel);    
        //button to begin the sort  
        JButton sortButton = new JButton("Sort");    
        sortButton.setBounds(430,240,140,35);     
        add(sortButton);    
        sortButton.addActionListener(new ActionListener() {    
            @Override    
            public void actionPerformed(ActionEvent e) {    
                //button creates a timer this timer will repaint() the rectangles every time (renderSleep) passes  
                timer = new Timer(SortingAlgorithm.renderSleep, new ActionListener() {  
                    public void actionPerformed(ActionEvent ie) {  
                        repaint();  
                    }  
                });  
                //starts the render every renderSleep timer   
                timer.start();  
                //begins the sort  
                //TODO: startSort() will not reset the array, this might be desired if the user wants to start over  
                //      currently the user needs to relaunch to run the simulation again.  
                //      This could be fixed with a resetArray() check if needed on sortButton() click  
                SortingAlgorithm.startSort();  
                //TODO: bug where clicking button multiple times will create new timers and threads with each click  
                //      without timer.stop() and without Thread.interrupt()  
                //      to workaround this I have removed the sortButton after clicking it  
                remove(sortButton);  
            }    
        });  
  
    }  
    public void finish() {  
        //finish is called when each sort finishes. On the third time it is checked it will be true  
        if (selDone && insDone && bubDone) {  
            //timer stops, thus repaint() is stopped  
            timer.stop();  
            //one last repaint() is called to render the finished frame  
            repaint();  
        }  
    }  
    public void paint(Graphics g) {  
        super.paint(g);  
        //horizontal start location for each array  
        int x1 = 60;  
        int x2 = 380;  
        int x3 = 700;  
        //draws each bar out of the 50 in each array  
        //colors the working and comparing rectangles within each array as well  
        //TODO: could be significantly improved if only the changed elements where called to be re-rendered  
        //arr1 = selection sort  
        for (int i = 0; i<50;i++) {  
            g.drawRect(x1,(100+100-(arr1[i]*2)),5,arr1[i]*2);  
            if (i == workingSel){  
                g.setColor(Color.BLACK);  
                g.fillRect(x1,(100+100-(arr1[i]*2)),5,arr1[i]*2); //fill rectangle with color  
            }else if(i == comparingSel){  
                g.setColor(Color.BLUE);   
                g.fillRect(x1,(100+100-(arr1[i]*2)),5,arr1[i]*2); //fill rectangle with color  
            }else{  
                g.setColor(Color.BLACK);      
            }  
            x1 += 5;  
        }  
        //arr2 = insertion sort  
        for (int i = 0; i<50;i++) {  
            g.drawRect(x2,(100+100-(arr2[i]*2)),5,arr2[i]*2);  
            if (i == workingIns){  
                g.setColor(Color.BLACK);      
                g.fillRect(x2,(100+100-(arr2[i]*2)),5,arr2[i]*2); //fill rectangle with color  
            }else if(i == comparingIns){  
                g.setColor(Color.BLUE);   
                g.fillRect(x2,(100+100-(arr2[i]*2)),5,arr2[i]*2); //fill rectangle with color  
            }else{  
                g.setColor(Color.BLACK);      
            }  
            x2 += 5;  
        }  
        //arr3 = bubble sort  
        for (int i = 0; i<50;i++) {  
            g.drawRect(x3,(100+100-(arr3[i]*2)),5,arr3[i]*2);  
            if (i == workingBub){  
                g.setColor(Color.BLACK);      
                g.fillRect(x3,(100+100-(arr3[i]*2)),5,arr3[i]*2); //fill rectangle with color  
            }else if(i == comparingBub){  
                g.setColor(Color.BLUE);   
                g.fillRect(x3,(100+100-(arr3[i]*2)),5,arr3[i]*2); //fill rectangle with color  
            }else{  
                g.setColor(Color.BLACK);      
            }  
            x3 += 5;  
        }  
    }     
    public void setWorkingSel(int working) {  
        this.workingSel = working;  
    }  
    public void setComparingSel(int comparing) {  
        this.comparingSel = comparing;  
    }  
    public void setWorkingIns(int working) {  
        this.workingIns = working;  
    }  
    public void setComparingIns(int comparing) {  
        this.comparingIns = comparing;  
    }  
    public void setWorkingBub(int working) {  
        this.workingBub = working;  
    }  
    public void setComparingBub(int comparing) {  
        this.comparingBub = comparing;  
    }  
} 
