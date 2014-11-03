package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class MaxPointOnLine {
	private class Line {
		int a, b, c;
		
		Line(Point p1, Point p2) {
			a = p1.y - p2.y;
			b = p2.x - p1.x;
			c = p1.x * p2.y - p2.x * p1.y;
			int gcd = gcd(a, b, c);
			
			if (gcd != 0) {
				a /= gcd;
				b /= gcd;
				c /= gcd;
			}
			// normalization
			if (a < 0 || a == 0 && b < 0) {
				a = -a;
				b = -b;
				c = -c;
			}
		}
		
		int gcd(int a, int b, int c) {
			return gcd(gcd(a, b), c);
		}
		
		int gcd(int a, int b) {// need to handle negative numbers
			int temp;
			if (a < 0) {
				a = -a;
			}
			if (b < 0) {
				b = -b;
			}
			if (a < b) {
				temp = b;
				b = a;
				a = temp;
			}
			
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof Line) {
				if ((((Line) o).a == this.a) && (((Line) o).b == this.b) && (((Line) o).c == this.c)) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.a ^ this.b * this.c;
		}
		
	}
	
	public boolean eqPoints(Point p1, Point p2) {
	    if (p1.x == p2.x && p1.y == p2.y) {
	        return true;
	    } else {
	        return false;
	    }
	}

	// general equation
	public int maxPoints(Point[] points) {
		if (points.length == 1) {
			return 1;
		}
		
		if (points.length == 0) {
			return 0;
		}
		
		int[] tie = new int[points.length]; //to record the number ties for each point
	    for (int i = 0; i < tie.length; i ++) {
	        tie[i] = 0;
	    }
		
		HashMap<Line, HashSet<Integer>> map = new HashMap<Line, HashSet<Integer>>();
		for (int i = 0; i < points.length; i ++) {
			for (int j = i + 1; j < points.length; j ++) {
				if (eqPoints(points[i], points[j])) { // record all ties
			        tie[i] ++;
			        tie[j] ++;
			    } else {
					Line newLine = new Line(points[i], points[j]);
					HashSet<Integer> newSet;
					//System.out.println(map.);
					if (!map.containsKey(newLine)) {
						newSet = new HashSet<Integer>();
					} else {
						newSet = map.get(newLine);
					}
					newSet.add(i);
					newSet.add(j);
					map.put(newLine, newSet);
			    }
			}
		}
		
		int max = 0;
		
		if (map.size() > 0) {
			Iterator<Entry<Line, HashSet<Integer>>> it = map.entrySet().iterator();
			int size = 0;
			while (it.hasNext()) {
				Entry<Line, HashSet<Integer>> pair = it.next();
				size = pair.getValue().size();
				if (size > max) {
					max = size;
				}
			}
		} else {
			max = tie[0] + 1;
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		//[(40,-23),(9,138),(429,115),(50,-17),(-3,80),(-10,33),(5,-21),(-3,80),(-6,-65),(-18,26),(-6,-65),(5,72),(0,77),(-9,86),(10,-2),(-8,85),(21,130),(18,-6),(-18,26),(-1,-15),(10,-2),(8,69),(-4,63),(0,3),(-4,40),(-7,84),(-8,7),(30,154),(16,-5),(6,90),(18,-6),(5,77),(-4,77),(7,-13),(-1,-45),(16,-5),(-9,86),(-16,11),(-7,84),(1,76),(3,77),(10,67),(1,-37),(-10,-81),(4,-11),(-20,13),(-10,77),(6,-17),(-27,2),(-10,-81),(10,-1),(-9,1),(-8,43),(2,2),(2,-21),(3,82),(8,-1),(10,-1),(-9,1),(-12,42),(16,-5),(-5,-61),(20,-7),(9,-35),(10,6),(12,106),(5,-21),(-5,82),(6,71),(-15,34),(-10,87),(-14,-12),(12,106),(-5,82),(-46,-45),(-4,63),(16,-5),(4,1),(-3,-53),(0,-17),(9,98),(-18,26),(-9,86),(2,77),(-2,-49),(1,76),(-3,-38),(-8,7),(-17,-37),(5,72),(10,-37),(-4,-57),(-3,-53),(3,74),(-3,-11),(-8,7),(1,88),(-12,42),(1,-37),(2,77),(-6,77),(5,72),(-4,-57),(-18,-33),(-12,42),(-9,86),(2,77),(-8,77),(-3,77),(9,-42),(16,41),(-29,-37),(0,-41),(-21,18),(-27,-34),(0,77),(3,74),(-7,-69),(-21,18),(27,146),(-20,13),(21,130),(-6,-65),(14,-4),(0,3),(9,-5),(6,-29),(-2,73),(-1,-15),(1,76),(-4,77),(6,-29)]
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, -1);
		
//		points[0] = new Point(3, 10);
//		points[1] = new Point(0, 2);
//		points[2] = new Point(0, 2);
//		points[3] = new Point(3, 10);
//		points[4] = new Point(-4, -4);
//		points[5] = new Point(-4, -4);
		MaxPointOnLine solution = new MaxPointOnLine();
		System.out.println(solution.maxPoints(points));
		//Line line = new Line(1, 2, 3);
		//System.out.println(line.gcd(0, 25, 15));
	}

	// two-points equation: a better and cleaner implementation
	public int maxPointsAC(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 1;

		for (int i = 0; i < points.length; i++) {
			// shared point changed, map should be cleared and server the new
			// point
			map.clear();

			// maybe all points contained in the list are same points,and same
			// points' k is
			// represented by Integer.MIN_VALUE
			map.put((double) Integer.MIN_VALUE, 1);

			int dup = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					dup++;
					continue;
				}

				// look
				// 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
				// because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0
				// to solve 0.0 !=-0.0
				// problem

				// if the line through two points are parallel to y coordinator,
				// then K(slop) is
				// Integer.MAX_VALUE
				double key = points[j].x - points[i].x == 0 ? Integer.MAX_VALUE
						: 0.0 + (double) (points[j].y - points[i].y)
								/ (double) (points[j].x - points[i].x);

				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 2);
				}
			}

			for (int temp : map.values()) {
				// duplicate may exist
				if (temp + dup > max) {
					max = temp + dup;
				}
			}

		}
		return max;
	}

}

