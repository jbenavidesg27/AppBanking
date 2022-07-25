package com.nttdata.bootcamp.active.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "actives")
public class Active {
	
	@Id
	private Integer id;
	private String descripcion;
	

}
