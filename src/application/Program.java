package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Empregado;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Empregado> list = new ArrayList<>();
		
		System.out.print("Quantos empregados serão registrados? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Empregado #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (temId(list, id)) {
				System.out.println("Este id já existe. Tente outro.");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			Double salario = sc.nextDouble();
			
			Empregado emp = new Empregado(id, nome, salario);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Digite o id do empregado que terá aumento no salário: ");
		int idsalario = sc.nextInt();
		Empregado emp = list.stream().filter(x -> x.getId() == idsalario).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Esse id não existe.");
		} 
		else {
			System.out.println("Entre com a porcentagem: ");
			double percentagem = sc.nextDouble();
			emp.aumentarSalario(percentagem);
		}
		
		System.out.println();
		System.out.println("Lista de empregados: ");
		for (Empregado e : list) {
			System.out.println(e);
		}
		
		sc.close();
	}
	
	public static Integer posicao(List<Empregado> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean temId(List<Empregado> list, int id) {
		Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}