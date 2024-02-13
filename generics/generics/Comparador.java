package generics;

public class Comparador {

	public int maxElement(int[] integers) {
		int higher = 0;
		
		for (int i = 0; i < integers.length; i++) {
			if(higher < integers[i]) {
				higher = integers[i];
			}
		}
		return higher;
	}
}
