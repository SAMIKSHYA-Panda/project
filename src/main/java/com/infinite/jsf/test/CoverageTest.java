package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.InsuranceCoverageOptionController;

public class CoverageTest {
	
	public static void main(String[] args) {
		
		InsuranceCoverageOptionController controller= new InsuranceCoverageOptionController();
		
		controller.findAllcoverageOption().forEach(System.out::println);
		
		
	}

}
