package com.example.projektaplikacjeinternetowe.hotel.commons.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements Persistable<T>, Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected T id;

	@Override
	public T getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}
}
