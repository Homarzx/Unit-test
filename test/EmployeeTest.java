package test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import tallerpruebas.Employee;
import tallerpruebas.EmployeeType;

class EmployeeTest {
	private int month;
	
	@Before
	public void init(){
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant()
		           .atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		
	}

	@Test
	void calculadorRemuneracionDolar() {
		Employee e =  new Employee(500.50f,"USD", 3.5f,EmployeeType.Worker);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 386.0;
		assertEquals(esperado, remuneracion,0);
	}
	
	@Test
	void calculadorRemuneracionEuro() {
		Employee e =  new Employee(1200.0f,"EURO", 3.5f,EmployeeType.Manager);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 1526.0;
		assertEquals(esperado, remuneracion,0) ;
	}
	
	@Test //
	void SupervisorEuro() {
		Employee e =  new Employee(1350.0f,"EURO", 2.5f,EmployeeType.Supervisor);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 1475.5; 
		assertEquals(esperado, remuneracion,0) ;
	}
	
	@Test //
	void SupervisorDolar() {
		Employee e =  new Employee(1550.0f,"USD", 1.5f,EmployeeType.Supervisor);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 1743.0; 
		assertEquals(esperado, remuneracion,0) ;
	}
	
	@Test //
	void ManagerDolar() {
		Employee e =  new Employee(1020.0f,"USD", 0.5f,EmployeeType.Manager);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 1406.0; 
		assertEquals(esperado, remuneracion,0) ;
	}
	
	@Test //
	void workerEuro() {
		Employee e =  new Employee(500.0f,"EURO", 2.4f,EmployeeType.Worker);
		Float remuneracion = e.CalculateYearBonus();
		Float esperado = (float) 386; 
		assertEquals(esperado, remuneracion,0) ;
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
	
	/*
	 * Se comprueba que el currency este correcto con la longitud correcta de la abreviatura
	 * */
	
	@Test
	void comprobarabreviaturacurrency() {
		Employee e =  new Employee(1300.0f,"USA", 3.6f,EmployeeType.Worker);
		String divisa=e.getCurrency();
		if(divisa.length()!=3) {
			fail("Abreviatura de tipo currency incorrecto, debe tener 3 caracteres");
		}
				
		
	}
	/*
	 * Se comprueba que el salario para el trabajador Worker
	 * */
	@Test
	void SalarioValidoWorker() {
		Employee e =  new Employee(1200.0f,"USA", 3.5f,EmployeeType.Worker);
		Float remuneracion = e.cs();
		Float esperado = (float) 1140.0;
		assertEquals(esperado, remuneracion,0) ;
		
	}
	
	@Test
	public void SalarioEuroSupervisor() {	
		Employee e =  new Employee(1550.0f,"USD", 1.5f,EmployeeType.Supervisor);
		Float salario = e.cs();
		if(month%2==0)
			assertEquals(1472.5f, salario,0);
		else
			assertEquals(1614.33f, salario, 0.1);
	}
	
	@Test
	public void SalarioEuroManager() {	
		Employee e =  new Employee(1200.0f,"EURO", 3.1f,EmployeeType.Manager);
		Float salario = e.cs();
		if(month%2==0)
			assertEquals(1140.0f, salario,0);
		else 
			assertEquals(1264.33f, salario, 0.1);
	}	

}
