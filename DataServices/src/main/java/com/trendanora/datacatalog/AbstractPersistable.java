package com.trendanora.datacatalog;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class AbstractPersistable<PK extends Serializable> implements Persistable<PK>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private PK primaryKey; 
	
	public PK getId() {
		return primaryKey;
	}

	@JsonIgnore
	public boolean isNew() {
		return primaryKey == null;
	}

}