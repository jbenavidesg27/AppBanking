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
	public Mono<ResponseEntity<Flux<Active>>>  findAll(){
		Flux<Active> fx = activeService.findAll();
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fx));
	}
	
	/*List Active for Id*/
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Active>> findById(@PathVariable("id") String id){
		return activeService.findById(id)
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(p));
	}
	
	/*Save Active*/
	@PostMapping
	public Mono<ResponseEntity<Active>> save(@RequestBody Active active, final ServerHttpRequest req){
		return activeService.save(active)
				.map( p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(p));
	}
	
	/*Update active for Id*/
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Active>> update(@PathVariable("id") String id,@RequestBody Active Active){
		Mono<Active> monoBody = Mono.just(Active);
		Mono<Active> monoBD = activeService.findById(id);
		return monoBD.zipWith(monoBody, (bd, ps) -> {
					bd.setId(id);
					bd.setCredit(ps.getCredit());
					bd.setCreditAmount(ps.getCreditAmount());
					bd.setCodePerson(ps.getCodePerson());
					bd.setCreditDate(ps.getCreditDate());
					bd.setPeriod(ps.getPeriod());
					return bd;
				})
				.flatMap(activeService::update)
				.map(y -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON).
						body(y))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

}
