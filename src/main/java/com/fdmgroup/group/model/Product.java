package com.fdmgroup.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "ProductTable")
public class Product {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGen")
	@SequenceGenerator(name = "productGen", sequenceName = "productSeq", allocationSize = 1)
	private int id;

	@NotBlank(message = "Product name cannot be empty")
	@Size(min = 2, max = 15, message = "Product name must be between 2 - 15 characters long")
	@Column(length = 15, nullable = false)
	private String name;

	private double price;

	// Constructors
	public Product() {
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
