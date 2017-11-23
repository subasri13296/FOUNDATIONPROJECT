package foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import foundation.emp.Employee;

public class Solution {

	public static void main(String[] args) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		session.beginTransaction();

		//System.out.print("enter ID:");
		//int id = Integer.valueOf(bf.readLine());

		System.out.print("enter Nmae:");
		String name = bf.readLine();

		System.out.print("enter email:");
		String email = bf.readLine();

		System.out.print("enter phno:");
		long phone = Long.valueOf(bf.readLine());

		System.out.print("enter Basic salary:");
		double basicSalary = Double.valueOf(bf.readLine());

		System.out.print("enter HRA:");
		float houseRentAllowance = Float.valueOf(bf.readLine());

		System.out.print("enter TA:");
		float travelAllowance = Float.valueOf(bf.readLine());

		System.out.print("enter DA:");
		float dearnessAllowance = Float.valueOf(bf.readLine());

		System.out.print("enter PF:");
		Float providentFund = Float.valueOf(bf.readLine());

		
		Employee employee = new Employee(name, email, phone,basicSalary,houseRentAllowance,travelAllowance,dearnessAllowance,providentFund);
		System.out.println("Id:" + employee.getId());
		System.out.println("name:" + employee.getName());
		System.out.println("Email:" + employee.getEmail());
		System.out.println("Ph:" + employee.getPhone());
		System.out.println("Basic Salary:" + employee.getBasicSalary());
		System.out.println("HRA:" + employee.getHouseRentAllowance());
		System.out.println("TA:" + employee.getTravelAllowance());
		System.out.println("DA:" + employee.getDearnessAllowance());
		System.out.println("PF:" + employee.getProvidentFund());
		System.out.println("Net Salary:" + employee.calculate(basicSalary, houseRentAllowance, travelAllowance, dearnessAllowance, providentFund));
		
		session.save(employee);
		session.getTransaction().commit();

		session.close();

	}

}
