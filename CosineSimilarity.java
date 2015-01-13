/**
 * 
 */
package gvl.cosinesimilarity;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This class calculates the cosine similarity of two vectors represented as HashMaps.
 * Explicitly, given two HashMaps (vectors), A and B, we calculate the cosine similarity using:
 * A dot B / (sqrt(A dot A) * sqrt(B dot B))
 * Where 'dot' indicates the dot product operation.
 * 
 * The running time is linear in the size of the smallest HashMap.
 * 
 * @author Gene
 *
 */
public class CosineSimilarity {
	
	/**
	 * Calculates the cosine similarity of the given vectors represented as HashMaps. 
	 * 
	 * @param vec1 The first vector.
	 * @param vec2 The second vector.
	 * @return The cosine similarity of the given vectors represented as HashMaps.
	 */
	public static <K> double cosineSimilarity(HashMap<K, ? extends Number> vec1, HashMap<K, ? extends Number> vec2) {
		double dotProduct = dotProduct(vec1, vec2);
		double normVec1 = Math.sqrt(dotProduct(vec1, vec1));
		double normVec2 = Math.sqrt(dotProduct(vec2, vec2));
		return dotProduct / (normVec1 * normVec2);
	}
	
	/**
	 * Calculates the dot product of the given vectors represented as HashMaps.
	 * 
	 * @param vec1 The first vector.
	 * @param vec2 The second vector.
	 * @return The dot product of the given vectors represented as HashMaps.
	 */
	private static <K> double dotProduct(HashMap<K, ? extends Number> vec1, HashMap<K, ? extends Number> vec2) {
		double dotProduct = 0.0;
		HashMap<K, ? extends Number> shorter, longer;
		if (vec1.size() <= vec2.size()) {
			shorter = vec1;
			longer = vec2;
		}
		else {
			shorter = vec2;
			longer = vec1;
		}
		Iterator<K> keys = shorter.keySet().iterator();
		while (keys.hasNext()) {
			K key = keys.next();
			Number val1 = shorter.containsKey(key) ? shorter.get(key) : new Double(0.0);
			Number val2 = longer.containsKey(key) ? longer.get(key) : new Double(0.0);
			dotProduct += val1.doubleValue() * val2.doubleValue();
		}
		return dotProduct;
	}
	
	public static void main(String[] args) {
		HashMap<String, Double> A = new HashMap<String, Double>();
		HashMap<String, Double> B = new HashMap<String, Double>();
		
		A.put("hi", 0.0);
		B.put("hi", 0.0);
		
		System.out.println(cosineSimilarity(A, B));
	}
}
