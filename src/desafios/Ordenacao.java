package desafios;

import java.util.Scanner;

public class Ordenacao {

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);
		System.out.println("Informe o tamanho do vetor de int desejado: ");
		int tamanhoVetor = leitura.nextInt();
		int[] elementos = new int[tamanhoVetor];

		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = (int) (Math.random() * 100);
		}

		leituraVetorInt(elementos);

		ordenacaoBubbleSort(elementos);
		leituraVetorInt(elementos);

		ordenacaoBubbleSortDecrescente(elementos);
		leituraVetorInt(elementos);

	}

	public static void leituraVetorInt(int[] elementos) {
		System.out.println("Elementos do vetor: ");
		for (int i : elementos) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void ordenacaoBubbleSort(int[] vetorInt) {

		for (int i = 0; i < vetorInt.length; i++) {
			for (int j = 0; j < vetorInt.length; j++) {
				if (j + 1 < vetorInt.length) {
					if ((vetorInt[j] > vetorInt[j + 1])) {
						int temporario = vetorInt[j + 1];
						vetorInt[j + 1] = vetorInt[j];
						vetorInt[j] = temporario;
					}
				}

			}
		}

	}

	public static void ordenacaoBubbleSortDecrescente(int[] vetorInt) {

		for (int i = 0; i < vetorInt.length; i++) {
			for (int j = 0; j < vetorInt.length; j++) {
				if (((j + 1) < vetorInt.length) && (vetorInt[j] < vetorInt[j + 1])) {
					int temporario = vetorInt[j + 1];
					vetorInt[j + 1] = vetorInt[j];
					vetorInt[j] = temporario;

				}
			}
		}

	}

}
