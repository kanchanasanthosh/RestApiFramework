

package employeePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GetDatawithPOJO {
	

@JsonProperty("id")
private Integer id;
@JsonProperty("employee_name")
private String employeeName;
@JsonProperty("employee_salary")
private Integer employeeSalary;
@JsonProperty("employee_age")
private Integer employeeAge;
@JsonProperty("profile_image")
private String profileImage;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public Integer getEmployeeSalary() {
	return employeeSalary;
}
public void setEmployeeSalary(Integer employeeSalary) {
	this.employeeSalary = employeeSalary;
}
public Integer getEmployeeAge() {
	return employeeAge;
}
public void setEmployeeAge(Integer employeeAge) {
	this.employeeAge = employeeAge;
}
public String getProfileImage() {
	return profileImage;
}
public void setProfileImage(String profileImage) {
	this.profileImage = profileImage;
}


}
