package application;

import java.util.Date;

import entities.DaoFactory;
import entities.Department;
import entities.Seller;
import entities.SellerDao;

public class Principal {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findByID(3);
		
		System.out.println(seller.toString());

	}

}
