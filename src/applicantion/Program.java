package applicantion;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		/*Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
conforme exemplos.
Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
aumento por porcentagem dada.*/
		
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		List<Employee> list=new ArrayList<Employee>();
		
		System.out.print("How many employees will be registered? ");
		int n=sc.nextInt();	
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Emplyoee #%d:%n",i+1);
			System.out.print("id: ");
			int id=sc.nextInt();
			while (hasID(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			String nome=sc.next();
			System.out.print("Salary: ");
			double salarío=sc.nextDouble();
			System.out.println("");
			list.add(new Employee(id, nome, salarío));
			
		}
		
			System.out.print("Enter the employee id that will have salary increase: ");
			int seuID=sc.nextInt();
			
			// Employee position = list.stream().filter(e -> e.getId() == seuID).findFirst().orElse(null);
			Integer pos=position(list, seuID);
			if (pos!=null) {
				System.out.print("Enter the percentage: ");
				double porct=sc.nextDouble();
				list.get(pos).increaseSalary(porct);
				System.out.println("");

			}else {
				System.out.println("This id does not exist!");

			}
			System.out.printf("%nList of employees:%n");
		for (Employee func : list) {
			System.out.print(func);
		}
					
		sc.close();
	}

	public static Integer position(List<Employee>list,int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId()==id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasID(List<Employee>list, int id) {
		Employee emp=list.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
		return emp!=null;
	}
}
