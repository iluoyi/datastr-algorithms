package practice;

import java.util.ArrayList;
import java.util.Random;

public class KMeans {

	final int _coordCount;
	final double[][] _coordinates; // original data
	final int _k; // the number of cluster
	private Cluster[] _clusters; // clusters
	final int[] _clusterAssignments; // "_clusterAssignments[j]=i" means j belongs to cluster i
	private final int[] _nearestCluster; // record the nearest cluster
    private final double[][] _distanceCache; // "_distanceCache[i][j]" is the dist between i and j
    private static final Random _rnd = new Random(1); // initialization of seeds

    public Cluster[] getClusters(){
		return _clusters; 
	} 
    
	public KMeans(double[][] data, int K){
		_coordinates = data;
		_coordCount = data.length;
		_k = K;
		_clusters = new Cluster[K];
		
		_clusterAssignments = new int[_coordCount];
		_nearestCluster = new int[_coordCount];
		_distanceCache = new double[_coordCount][data.length];
		
		InitRandom();
	}
	
	public KMeans(double[][] data, Cluster[] preClusters, int K){
		_coordinates = data;
		_coordCount = data.length;
		_k = K;
		_clusters = preClusters;
		
		_clusterAssignments = new int[_coordCount];
		_nearestCluster = new int[_coordCount];
		_distanceCache = new double[_coordCount][data.length];
	}

	public void start(int limit){
		int iter = 0;
		
		while (iter < limit){
			System.out.println("Iteration " + (iter++) + "...");
			System.out.println(_clusters.length);
            // 1. re-compute clustering centers
			for (int i = 0; i < _k; i++){
				_clusters[i].UpdateMean(_coordinates);
			}

			// 2. calculate the distance between each data sample to each clustering center
			for (int i = 0; i < _coordCount; i++){
				for (int j = 0; j < _k; j++){
					double dist = getEuclidDistance(_coordinates[i], _clusters[j].Mean);
					_distanceCache[i][j] = dist;
				}
			}

			// 3. find the nearest distance for each data sample
			for (int i = 0; i < _coordCount; i++){
				_nearestCluster[i] = nearestCluster(i);
			}

			// 4. check if the classification changes, no change will trigger ending the condition 
			int k = 0;
			for (int i = 0; i < _coordCount; i++){
				if (_nearestCluster[i] == _clusterAssignments[i])
					k++;
			}
			if (k == _coordCount)
				break;

			// 5. if classification changes, adjust the label
			for (int j = 0; j < _k; j++){
				_clusters[j].CurrentMembership.clear();
			}
			for (int i = 0; i < _coordCount; i++){
				_clusters[_nearestCluster[i]].CurrentMembership.add(i);
				_clusterAssignments[i] = _nearestCluster[i];
			}
		}
	}

	/**
	 * To compute distances between samples to clustering centers
	 * and detect the nearest cluster center
	 * @param ndx
	 * @return
	 */
	int nearestCluster(int ndx){
		int nearest = -1;
		double min = Double.MAX_VALUE;
		for (int c = 0; c < _k; c++){
			double d = _distanceCache[ndx][c];
			if (d < min){
				min = d;
				nearest = c;
			}
          }
		return nearest;
	}

	
	static double getCosinDistance(double[] coord, double[] center){
		return 1- TermVector.ComputeCosineSimilarity(coord, center);
	} 
	
	
	static double getEuclidDistance(double[] coord, double[] center){
		return TermVector.ComputeEuclidDist(coord, center);
	} 

	/**
	 * Initialization via the random function
	 */
	private void InitRandom(){
		for (int i = 0; i < _k; i++){
			int temp = _rnd.nextInt(_coordCount);
			_clusterAssignments[temp] = i;
			_clusters[i] = new Cluster(temp,_coordinates[temp]);
		}
	}
	
}

class Cluster{
	ArrayList<Integer> CurrentMembership; // members of a cluster
	double[] Mean; // the clustering center

	public Cluster(int dataindex, double[] data){
		CurrentMembership = new ArrayList<Integer>();
        CurrentMembership.add(dataindex);
        Mean = data;
	}
	
	/**
	 * If no representative center sample
	 */
	public Cluster(double[] data){
		CurrentMembership = new ArrayList<Integer>();
        Mean = data;
	}

	/**
	 * To calculate the mean value of given dataset
	 * @param coordinates
	 */
	public void UpdateMean(double[][] coordinates){
		for (int i = 0; i < CurrentMembership.size(); i++){
			double[] coord = coordinates[CurrentMembership.get(i)];
			for (int j = 0; j < coord.length; j++){
				Mean[j] += coord[j]; // sum in the column direction
			}
			for (int k = 0; k < Mean.length; k++){
				Mean[k] /= coord.length; // mean in the row direction
			}
		}
	}
}