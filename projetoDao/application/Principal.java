package application;

import java.util.Date;

import entities.Department;
import entities.Seller;

public class Principal {

	public static void main(String[] args) {


		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21,"bob", "bob@gmail.com", new Date(), 3000.00, obj);
		System.out.println(obj.toString());
		System.out.println(seller.toString());

	}

}
