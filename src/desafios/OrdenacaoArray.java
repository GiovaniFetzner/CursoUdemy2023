package desafios;

public class OrdenacaoArray {

	public static void main(String[] args) {
		int[] inteiros = {7, 4, 8, 6, 2, 4, 1, 6, 9, 5, 3};
		int[] inteirosComRepeticao = {7, 4, 9, 2, 1, 6, 0, 5, 3};
		int[] arrayRandom = new int[10];
		
		for(int i = 0; i < arrayRandom.length; i++) {
			arrayRandom[i] = (int) (Math.random()*100);
		}
		

		ApresentaArray(arrayRandom);
		  
		System.out.println();
		
		OrdenacaoArray(arrayRandom); 
		ApresentaArray(arrayRandom);

	}

	private static void ApresentaArray(int[] inteirosComRepeticao) {
		for (int i : inteirosComRepeticao) {
			  System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void OrdenacaoArray(int[] array) {
		int index = 0;
		for (int i = 0; i <array.length; i++) {
			for(int j = 0; j<array.length; j++) {
				 if((array[j] == i)){
					int temporario = array[index];
					array[index] = array[j];
					array[j] = temporario;
					index++;
				}
			}

		}
	}

}
