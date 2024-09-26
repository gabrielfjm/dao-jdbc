package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = departmentDao.findById(1);		
		System.out.println(dep);
		
		
		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> departments = departmentDao.findAll();			
		for(Department obj : departments) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department newDep = new Department(null, "Vendas");		
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());

		System.out.println("\n=== TEST 4: department update ====");
		dep = departmentDao.findById(2);
		dep.setName("T.I.");
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("delete completed!");	
		
		sc.close();
	}

}
