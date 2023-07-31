package com.example.demo.uce.edu.funcional;

public class PersonaSupplierImpl  implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		
		String cedula = "1827049583";
		cedula = cedula + "1234567890";
		return cedula;
	}
}
