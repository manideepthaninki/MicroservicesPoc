package com.mani.eCommerce.productcatlog.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name ="reviews" )
@ToString
public class Reviews {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String comment;
	private String reviewed;
	private int rating;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
}
