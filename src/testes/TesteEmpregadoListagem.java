package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import desafios.Empregado;

public class TesteEmpregadoListagem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitura = new Scanner(System.in);
		System.out.print("Informe quantos empregados serao cadastrados: ");
		int quantidadeDeCadastros = leitura.nextInt();
		
		//Empregado[] empregados = new Empregado[quantidadeDeCadastros];
		List <Empregado> listaEmpregados = new ArrayList<Empregado>();
		
		// Cadastro de funcionários
		for (int i = 0; i < quantidadeDeCadastros; i++) {
			System.out.println();
			System.out.print("Qual o id do funcionario #" + (i+1) + ": ");
			int id = leitura.nextInt();
			leitura.nextLine();
			
			//Teste para verificar se já existe o id
			for (int j = 0; j < listaEmpregados.size(); j++) { 
				if (listaEmpregados.get(j).getId() == id) { 
					System.out.println("Coloque um id nao existente para cadastrar o funcionario ");
					id = leitura.nextInt();
					leitura.nextLine();
					j = -1;
				}
			}
			
			System.out.print("Qual o nome do funcionario #" + (i+1) + ": ");
			String nome = leitura.nextLine();
			System.out.print("Qual o salario do funcionario #" + (i+1) + ": ");
			double salario = leitura.nextDouble();
			
			Empregado empregadoCadastrado = new Empregado(id, nome,salario);
			listaEmpregados.add(empregadoCadastrado);
			//empregados[i] = empregadoCadastrado;
			
		}
		
		/**
		 * Procedimento de criação de uma lista de empregados para buscar um id e
		 * efetuar o aumento de salario
		 */
		
		System.out.println();
		System.out.print("Informe o id do funcionario que recebera aumento: ");
		int id = leitura.nextInt();
		System.out.print("Informe a porcentagem do aumento: ");
		double porcentagem = leitura.nextDouble();
		
		Empregado empregadoEncontrado = listaEmpregados.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
		int indexOfEmpregadoAntigo = listaEmpregados.indexOf(empregadoEncontrado);
		
		//Calcula porcentagem de aumento
		empregadoEncontrado.calculaNovoSalario(porcentagem);
		
		
		//Substitui o empregado com informações desatualizadas pelas novas
		listaEmpregados.set(indexOfEmpregadoAntigo, empregadoEncontrado);
		
		System.out.println();
		
		//Listagem utilizando ArrayList
		listaEmpregados.stream().forEach(empregado -> System.out.println(empregado.toString()));
		
	}

}
