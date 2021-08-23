package tallerpruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {

	
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


}
