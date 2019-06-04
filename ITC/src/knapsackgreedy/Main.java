package knapsackgreedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
	
	private static int[] wt;
	private static int[] val;
	private static int capacity;

	public static void main(String[] args) {
		
		int size = 20;

		wt = new int[size];
		val = new int[size];
		
		Random random = new Random();
		
		for(int i = 0; i < size; i ++) {
			wt[i] = random.nextInt(100);
			val[i] = random.nextInt(100);
			capacity += wt[i];
		}
		
		capacity = capacity / 2;
		
        long startTime = System.currentTimeMillis();

        double maxValue = getMaxValue(wt, val, capacity); 
        
		long stopTime = System.currentTimeMillis();
        
        System.out.println("Maximum value we can obtain = " + maxValue); 
        
        long elapsedTime = stopTime - startTime;
		
		System.out.println("Tempo de execução: " + elapsedTime);
		
	}
	
	// function to get maximum value 
    private static double getMaxValue(int[] wt, int[] val, int capacity) 
    { 
        ItemValue[] iVal = new ItemValue[wt.length]; 
  
        for(int i = 0; i < wt.length; i++) 
        { 
            iVal[i] = new ItemValue(wt[i], val[i], i); 
        } 
  
        //sorting items by value; 
        Arrays.sort(iVal, new Comparator<ItemValue>()  
        { 
            @Override
            public int compare(ItemValue o1, ItemValue o2)  
            { 
                return o2.cost.compareTo(o1.cost) ; 
            } 
        }); 
  
  
        double totalValue = 0d; 
  
        for(ItemValue i: iVal) 
        { 
  
            int curWt = (int) i.wt; 
            int curVal = (int) i.val; 
  
            if (capacity - curWt >= 0) 
            { 
                // this weight can be picked while 
                capacity = capacity-curWt; 
                totalValue += curVal; 
  
            } 
            else
            { 
                // item cant be picked whole 
                double fraction = ((double)capacity/(double)curWt); 
                totalValue += (curVal*fraction); 
                capacity = (int)(capacity - (curWt*fraction)); 
                break; 
            } 
  
  
        } 
  
        return totalValue; 
    } 
    
    // item value class 
    static class ItemValue  
    { 
        Double cost; 
        double wt, val, ind; 
          
        // item value function 
        public ItemValue(int wt, int val, int ind) 
        { 
            this.wt = wt; 
            this.val = val; 
            this.ind = ind; 
            cost = new Double(val/wt ); 
        } 
    } 

}
