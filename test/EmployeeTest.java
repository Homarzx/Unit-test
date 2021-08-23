package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tallerpruebas.Employee;
import tallerpruebas.EmployeeType;

class EmployeeTest {

	
	@Test
	void calculadorRemuneracionDolar() {
		Employee e =  new Employee(500.50f,"USD", 3.5f,EmployeeType.Worker);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 386.0;
		assertEquals(esperado, remuneracion,0) ;

	}
	
	@Test
	void calculadorRemuneracionEuro() {
		Employee e =  new Employee(1200.0f,"EURO", 3.5f,EmployeeType.Manager);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 1526.0;
		assertEquals(esperado, remuneracion,0) ;
	}
	
	@Test
	void SupervisorDolar() {
		
	}
	
	@Test
	void SupervisorEuro() {
		
	}
	
	@Test
	void ManagerEuro() {
		
	}
	
	@Test
	void comprobarcurrency() {
		Employee e =  new Employee(1200.0f,"USA", 3.5f,EmployeeType.Manager);
		String divisa=e.getCurrency();
		 for (int i = 0; i < divisa.length(); i++) {
	            if (Character.isDigit(divisa.charAt(i))) {
	                fail("Tipo de dato incorrecto");
	            }
	        }
		
	}
	
	@Test
	void SalarioValido() {
		Employee e1 =  new Employee(1200.0f,"USA", 3.5f,EmployeeType.Manager);
		if(e1.getSalary()<0) {
			fail("El salario no puede ser negativo");
			
		}	
		
	}
	
	


}
