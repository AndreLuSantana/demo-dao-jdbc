package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== First test 1: seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);

		System.out.println("\n==== Second test : seller findByDepartmant ====");
		
		Department dep = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for(Seller obj : list) {
			
			System.out.println(obj);
		}
		
		System.out.println("\n==== Third test : seller findAll ====");
				
		list = sellerDao.findAll();
				
		for(Seller obj : list) {
					
			System.out.println(obj);
		}
		
		System.out.println("\n==== Fourth test : seller findAll ====");
		
		Seller newSeller = new Seller(null, "Gerg", "greggmail.com", new Date(), 4000.0, dep);

		sellerDao.insert(newSeller);
		
		System.out.println("Inserted new Id  = " + newSeller.getId());
		
		
		System.out.println("\n==== Fifth test : seller update ====");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		
		System.out.println("Updated completed.");
		
		System.out.println("\n=== Sixth test: seller delete");
		sellerDao.deleteById(8);
		System.out.println("Id deleted!!");
	}

}
