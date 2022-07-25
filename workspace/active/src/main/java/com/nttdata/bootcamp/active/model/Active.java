package com.nttdata.bootcamp.active.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "actives")
public class Active {
	
	@Id

	private String id;
	
	private Credit credit;
	
	private BigDecimal creditAmount;
	
	private String codePerson;
	
	private Date creditDate;
	
	private String period;

	

}
