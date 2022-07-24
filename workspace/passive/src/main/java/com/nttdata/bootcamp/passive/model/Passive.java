package com.nttdata.bootcamp.passive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "passive")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passive {
	@Id
	private String id;

}
