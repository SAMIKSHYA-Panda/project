package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.InsuranceCompanyController;
import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCompanyDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;

public class InsuranceCompanyTest {
	
	public static void main(String[] args) {
		
		
		InsuranceCompanyController companyController=new InsuranceCompanyController();
		
		InsuranceCompany company = new InsuranceCompany();
		
		InsuranceCompanyDao dao=new InsuranceCompanyDaoImpl();

		company.setCompanyId("COM0011299");
		company.setName("HDFC Ergo");
		company.setLogoUrl("https://example.com/logo.png");
		company.setHeadOffice("Mumbai");
		company.setContactEmail("support@hdfcergo.com");
		company.setContactPhone("1800-123-4567");

		
//		System.out.println(companyController.addInsuranceCompany(company));
		
//		System.out.println(dao.addCompany(company));
		
//		System.out.println(dao.findById("COM001"));
		
//		System.out.println(companyController.findCompnayById("COM0011299"));
		
//		companyController.findAllCompany().forEach(System.out::println);
//		
//		System.out.println(companyController.deleteCompanyById("COM0011299"));
		
//		System.out.println(dao.deleteCompanyById(company));
//		
		companyController.findAllCompany().forEach(System.out::println);

	}

}
