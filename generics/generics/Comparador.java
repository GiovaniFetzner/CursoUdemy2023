package generics;

import java.util.List;

public class Comparador {

	public static <T extends Comparable<T>> T maxElement(List<T> lista) {
		if (lista.isEmpty()) {
			 throw new IllegalStateException("Lista vazia");
			 }
		T higher = lista.get(0);
		
		for (T item : lista) {
			if (higher.compareTo(item)< 0){
				higher = item;
			}
		}
		return higher;
	}
}
