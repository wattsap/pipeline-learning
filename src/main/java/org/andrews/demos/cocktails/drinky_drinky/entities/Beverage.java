package org.andrews.demos.cocktails.drinky_drinky.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Beverage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	private double cost;
	private String description;
	private BeverageCategory category;
	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beverage(String name, double cost, String description, BeverageCategory category) {
		super();
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.setCategory(category);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BeverageCategory getCategory() {
		return category;
	}
	public void setCategory(BeverageCategory category) {
		this.category = category;
	}
}
