package foundation.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Emp_Details")
public class Employee {

	public Employee(String name, String email, long phone, double basicSalary, float houseRentAllowance,
			float travelAllowance, float dearnessAllowance, float providentFund) {
		super();

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.basicSalary = basicSalary;
		this.houseRentAllowance = houseRentAllowance;
		this.travelAllowance = travelAllowance;
		this.dearnessAllowance = dearnessAllowance;
		this.providentFund = providentFund;
		//this.netSalary = netSalary;
	}

	@Id
	@GeneratedValue
	@Column(name = "Emp_Id")
	private int id;
	@Column(name = "Emp_Name", length = 150, nullable = false)
	private String name;
	@Column(name = "Email_Id", nullable = false, unique = true)
	private String email;
	@Column(name = "Ph_No", unique = true, nullable = false)
	private long phone;
	// private boolean gender;
	@Column(name = "Basic_Salary", nullable = false)
	private double basicSalary;
	@Column(name = "HRA", nullable = false)
	private float houseRentAllowance;
	@Column(name = "TA", nullable = false)
	private float travelAllowance;
	@Column(name = "DA", nullable = false)
	private float dearnessAllowance;
	@Column(name = "PF", nullable = false)
	private float providentFund;
	@Transient
	private double netSalary;

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	
	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public float getHouseRentAllowance() {
		return houseRentAllowance;
	}

	public void setHouseRentAllowance(float houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}

	public float getTravelAllowance() {
		return travelAllowance;
	}

	public void setTravelAllowance(float travelAllowance) {
		this.travelAllowance = travelAllowance;
	}

	public float getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(float dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public float getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(float providentFund) {
		this.providentFund = providentFund;
	}

	public double calculate(double basicSalary, float houseRentAllowance, float travelAllowance, float dearnessAllowance,
			float providentFund) {
		netSalary = this.basicSalary+(
				((this.houseRentAllowance + this.travelAllowance + this.dearnessAllowance - this.providentFund) / 100)
						* this.basicSalary);
		return netSalary;
	}

};
