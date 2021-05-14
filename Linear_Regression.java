import java.util.ArrayList;
import java.util.Arrays;

public class Linear_Regression {
	public static void main (String []args) {
		Double[] Coor1 = {1.0,1.0};
		Double[] Coor2 = {2.0,2.0};
		Double[] Coor3 = {3.0,3.0};
		ArrayList<Double[]> Acoordinates = new ArrayList<Double[]>();
		Acoordinates.add(Coor1);
		Acoordinates.add(Coor2);
		Acoordinates.add(Coor3);
		
		//ArrayList<Double[]> slope = slope(0, 0);
		//System.out.println(Squared_Error(slope, Coordinates));
		printArraylist(Gradient_Descent(0, 0, Acoordinates, 1500));
		
	}
	
	public static double Squared_Error(ArrayList<Double[]> slope, ArrayList<Double[]> coors) {
		ArrayList<Double> sums = new ArrayList<Double>();
		for (int i = 0; i < coors.size(); i++) {
			double calc = (slope.get(i)[1] - coors.get(i)[1]) * (slope.get(i)[1] - coors.get(i)[1]);
			System.out.println(calc);
			sums.add(calc);
		}
		double len = 2 * coors.size();
		double newsum = (sumOfAll(sums) / len);
		
		return newsum;
	}
	
	public static double Squared_Error_1(ArrayList<Double[]> slope, ArrayList<Double[]> coors) {
		ArrayList<Double> sums = new ArrayList<Double>();
		for (int i = 0; i < coors.size(); i++) {
			double calc = (slope.get(i)[1] - coors.get(i)[1]);
			sums.add(calc);
		}
		double len = coors.size();
		double newsum = (sumOfAll(sums) / len);
		
		return newsum;
	}
	
	public static double Squared_Error_2(ArrayList<Double[]> slope, ArrayList<Double[]> coors) {
		ArrayList<Double> sums = new ArrayList<Double>();
		for (int i = 0; i < coors.size(); i++) {
			double calc = (slope.get(i)[1] - coors.get(i)[1]) * coors.get(i)[0];
			sums.add(calc);
		}
		double len = coors.size();
		double newsum = (sumOfAll(sums) / len);
		
		return newsum;
	}
	
	public static ArrayList<Double[]> Gradient_Descent (double theta, double theta_1, ArrayList<Double[]> coors, int n) {
		ArrayList<Double[]> slope = slope(theta_1, theta);
		for (int i = 0; i < n; i++) {
			double temp_0 = theta - 0.2 * (Squared_Error_1(slope, coors));
			double temp_1 = theta_1 - 0.2 * (Squared_Error_2(slope, coors));
			theta = temp_0;
			theta_1 = temp_1;
			slope = slope(theta_1, theta);
			System.out.println(printArraylist(slope));
		}
		Double[] in = {theta_1, theta};
		ArrayList<Double[]> values = new ArrayList<Double[]>();
		values.add(in);
		return values;
	}
	
	
	public static ArrayList<Double[]> slope (double d, double theta) {
		ArrayList<Double[]> ret = new ArrayList<Double[]>();
		for (int i = 1; i < 4; i++) {
			Double[] ad = {(double) i, (i*d)+theta};
			ret.add(ad);
		}
		return ret;
	}
	
	public static double sumOfAll (ArrayList<Double> ind) {
		double sum = 0;
		
		for (int i = 0; i < ind.size(); i++) {
			sum = sum + ind.get(i);
		}
		
		return sum;
	}
	
	public static String printArraylist (ArrayList<Double[]> n) {
		for (int i = 0; i < n.size(); i++) {
			System.out.println(Arrays.toString(n.get(i)));
		}
		return null;
	}
	
	
}
