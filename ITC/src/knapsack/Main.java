package knapsack;

public class Main {

	public static void main(String[] args) {

		Knapsack knapsack = new Knapsack(20);
		BruteForceAlgorithm brute = new BruteForceAlgorithm();
		
        long startTime = System.currentTimeMillis();
		
		brute.execute(knapsack);
		
		long stopTime = System.currentTimeMillis();

		long elapsedTime = stopTime - startTime;
		
		System.out.println("Tempo de execução: " + elapsedTime);
	}

}
