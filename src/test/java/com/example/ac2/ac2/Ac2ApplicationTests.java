package com.example.ac2.ac2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ac2.ac2.controller.Ac2Controller;

@SpringBootTest
class CursoApplicationTests {

    @Autowired
    private Ac2Controller Ac2Controller;
    
	@Test
	public void testeNotaMaior() {
		boolean resultado = Ac2Controller.CompararNota(8);
		assertEquals(true, resultado);
	}
	
	@Test
	public void testeTopicoAcessado() {
		boolean resultado = Ac2Controller.CompararAcessos(50, 25);
		assertEquals(true, resultado);
	}
}