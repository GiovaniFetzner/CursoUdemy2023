package application;

import java.util.List;

import entities.DaoFactory;
import entities.Department;
import entities.DepartmentDao;
import entities.Seller;
import entities.SellerDao;

public class Principal {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departamentDao = DaoFactory.createDepartamentDao();

		System.out.println("Teste 1: findById() ");
		Seller seller = sellerDao.findByID(3);
		System.out.println(seller.toString());
		System.out.println();

		System.out.println("Teste 2: findByDepartment() ");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		list.forEach(System.out::println);
		System.out.println();

		System.out.println("Teste 3: findAll() ");
		List<Seller> list01 = sellerDao.findAll();
		list01.forEach(System.out::println);
		System.out.println();

		// Exercicio de ordenação usando stream e sorted
		System.out.println("Ordenacao dos vendedores pelo id:");
		List<Seller> lista = list01.stream().sorted((x, y) -> x.getId().compareTo(y.getId())).toList();

		lista.forEach(System.out::println);
		System.out.println();
		/*
		 * System.out.println("Teste 4: seller insert() "); Seller newSeller = new
		 * Seller(null, "Greg ", "greg@gmailcom", new Date(), 4000.00, (new
		 * Department(3, null))); sellerDao.insert(newSeller);
		 * System.out.println("Adicionado: " + newSeller.getId() + " departamento: " +
		 * newSeller.getDepartment().getId());
		 */

		System.out.println("Teste 5: seller update() ");
		seller = sellerDao.findByID(11);
		seller.setName("Joao Witz");
		seller.setEmail("joao@gmail.com");
		sellerDao.update(seller);
		System.out.println(sellerDao.findByID(11).toString());
		System.out.println();

		System.out.println("Teste 6: seller deleteById() ");
		sellerDao.deleteById(10);
		
		System.out.print("DEPARTMENT Tests:");
		System.out.println("Teste 1: department findById() ");
		Department department = departamentDao.findByID(3);
		System.out.println(department.toString());
		System.out.println();

	}

}
