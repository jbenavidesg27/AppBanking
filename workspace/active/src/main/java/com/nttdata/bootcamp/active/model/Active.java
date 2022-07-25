package com.nttdata.bootcamp.active.model;

<<<<<<< HEAD
=======
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
>>>>>>> parent of fe8af3a (Active)
import lombok.Data;

@Data
<<<<<<< HEAD
public class Active {
	
=======
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "actives")
public class Active {
	
	@Id
<<<<<<< HEAD
	private Integer id;
	private String descripcion;
>>>>>>> parent of fe8af3a (Active)
=======
	private String id;
	
	private Credit credit;
	
	private BigDecimal creditAmount;
	
	private String codePerson;
	
	private Date creditDate;
	
	private String period;
>>>>>>> dev
	

}
