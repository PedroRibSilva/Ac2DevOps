package com.example.ac2.ac2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ac2Controller{

	@GetMapping("/compararnotas")
	public boolean CompararNota(@RequestParam int nota) {
		if (nota > 7) {
			System.out.println("Você ganhou assinatura premium");
			return true;
		}
		else
			System.out.println("Você não ganhou assinatura premium");
			return false;
	}

	@GetMapping("/compararacessos")
	public boolean CompararAcessos(@RequestParam int acessos, @RequestParam int maisacessado) {
		if (acessos > maisacessado) {
			System.out.println("Você ganhou assinatura premium");
			return true;
		}
		else
			System.out.println("Você não ganhou assinatura premium");
			return false;
	}
}