package com.nttdata.bootcamp.active.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.active.model.Active;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/active")
public class ActiveController {
	
	/*Peticiones Rest */
	
	@GetMapping
	public Flux<Active> findAll(){
		List<Active> list = Arrays.asList(new Active(1, "Credito Personal"),new Active(2, "Trajeta de Credito"));
		Flux<Active> fxActive = Flux.fromIterable(list);
		return fxActive;
	}

}
