package knapsack;

import java.util.Random;

public class Knapsack {
	
	private int[] weight;
	private int[] value;
	private int weightCapacity;
	
	public Knapsack(int size) {
		weight = new int[size];
		value = new int[size];
		Random random = new Random();
		for(int i = 0; i < size; i ++) {
			weight[i] = random.nextInt(100);
			value[i] = random.nextInt(100);
			weightCapacity += weight[i];
		}
		weightCapacity = weightCapacity / 2;
	}
	
	public int size() {
		return value.length;
	}
	
	
	public int[] calcule(int[] solution) {
		int v = 0;
		int w = 0;
		for(int i = 0; i < solution.length; i++) {
			v = v + solution[i] * value[i];
			w = w + solution[i] * weight[i];
		}
		if(w > weightCapacity) {
			v = 0;
		}
		return new int[]{v,w};
	}

}
