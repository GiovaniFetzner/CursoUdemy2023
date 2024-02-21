package application;

import java.util.Date;
import java.util.List;

import entities.DaoFactory;
import entities.Department;
import entities.Seller;
import entities.SellerDao;

public class Principal {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("Teste 1: findById() ");
		Seller seller = sellerDao.findByID(3);

		System.out.println(seller.toString());
		System.out.println();
		System.out.println("Teste 2: findByDepartment() ");

		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		list.forEach(System.out::println);
		System.out.println();

	}

}
