package models;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SummerClustering {
	
	public static void main(String args[]) {
		int length = 504;
		int k = 5;
		int dimension = 1;
		
		int[] zipCod = new int[length];
		double[][] data = new double[length][dimension];

		String line;
		String parts[];
		int index = 0;
		
		try {
			BufferedReader buff = new BufferedReader(new FileReader("data/toMapPoint2.csv"));
			
			while ((line = buff.readLine()) != null) {
				parts = line.split(",");
				zipCod[index] = Integer.parseInt(parts[1]);
				data[index][0] = Double.parseDouble(parts[2]);
				index ++;
			}
			
			buff.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		
		// K-means with selected seeds
		Cluster[] preClusters = new Cluster[k];
		double[][] seeds = new double[k][dimension];
		
		seeds[0][0] = 1.52;
		seeds[1][0] = 1.79;
		seeds[2][0] = 1.99;
		seeds[3][0] = 2.18;
		seeds[4][0] = 2.38;
		
		for (int i = 0; i < k; i++){
			preClusters[i] = new Cluster(seeds[i]);
		}
		
		KMeans kmeans = new KMeans(data, preClusters, k);
        // start iteration
        kmeans.start(1);

        // To get the result of clustering
        Cluster[] clusters = kmeans.getClusters();
		for (int c = 0; c < clusters.length; c ++) {
			List<Integer> members = clusters[c].CurrentMembership;
			System.out.println("-----------------");
			for (int i : members) {
				System.out.println(zipCod[i] + ", " + c);
			}
		}
	}
	
}
