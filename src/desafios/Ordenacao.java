package desafios;

import java.util.Scanner;

public class Ordenacao {

	public static void main(String[] args) {

		/*
		 * int[] elementos = criaVetorIntAleatorio();
		 * 
		 * leituraVetorInt(elementos);
		 * 
		 * System.out.println("\nOrdenacao Crescente:"); ordenacaoBubbleSort(elementos);
		 * leituraVetorInt(elementos);
		 * 
		 * System.out.println("\nOrdenacao decrescente:");
		 * ordenacaoBubbleSortDecrescente(elementos); leituraVetorInt(elementos);
		 */

		String[] elementosString = { "banana", "laranja", "abacaxi", "uva", "melancia" };
		leituraVetor(elementosString);

		// System.out.println(elementosString[0].compareTo(elementosString[3]));

		ordenacaoStringUsandoCompareTo(elementosString);

		leituraVetor(elementosString);
		ordenacaoStringPorTamanho(elementosString);

		leituraVetor(elementosString);
	}

	public static void ordenacaoStringPorTamanho(String[] elementosString) {
		for (int i = 0; i < elementosString.length; i++) {
			for (int j = 0; j < elementosString.length; j++) {
				if (((j + 1) < elementosString.length)
						&& (elementosString[j].length() > elementosString[j + 1].length())) {
					String temporario = elementosString[j + 1];
					elementosString[j + 1] = elementosString[j];
					elementosString[j] = temporario;
				}
			}
		}
	}

	public static void ordenacaoStringUsandoCompareTo(String[] elementosString) {
		for (int i = 0; i < elementosString.length; i++) {
			for (int j = 0; j < elementosString.length; j++) {
				if ((j + 1 < elementosString.length) && (elementosString[j].compareTo(elementosString[j + 1]) > 0)) {
					String temporario = elementosString[j + 1];
					elementosString[j + 1] = elementosString[j];
					elementosString[j] = temporario;
				}
			}
		}
	}

	public static int[] criaVetorIntAleatorio() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Informe o tamanho do vetor de int desejado: ");
		int tamanhoVetor = leitura.nextInt();
		int[] elementos = new int[tamanhoVetor];

		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = (int) (Math.random() * 100);
		}
		return elementos;
	}

	public static void leituraVetor(Object[] elementos) {
		System.out.println("Elementos do vetor: ");
		for (Object i : elementos) {
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
