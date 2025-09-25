package coding.rizaton.application;

import coding.rizaton.data.Company;

public class CompanyApp {
    public static void main(String[] args) {

        Company company = new Company();
        company.setName("Gubuk Santai");

        Company.Employee employee = company.new Employee();
        employee.setName("Iza");
        System.out.println(employee.getName());
        System.out.println(employee.getCompany());

        Company company2 = new Company();
        company2.setName("Not yet defined");

        Company.Employee employee2 = company2.new Employee();
        employee2.setName("Riza");
        System.out.println(employee2.getName());
        System.out.println(employee2.getCompany());
    }
}
