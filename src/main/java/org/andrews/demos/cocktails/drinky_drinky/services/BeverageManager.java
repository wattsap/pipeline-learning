package org.andrews.demos.cocktails.drinky_drinky.services;

import java.util.List;

import org.andrews.demos.cocktails.drinky_drinky.entities.Beverage;
import org.andrews.demos.cocktails.drinky_drinky.repository.BeverageWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeverageManager {
	private BeverageWarehouse bevMart;
	
	@Autowired
	public BeverageManager(BeverageWarehouse storeRef) {
		this.setBevMart(storeRef);
	}

	public BeverageWarehouse getBevMart() {
		return bevMart;
	}

	public void setBevMart(BeverageWarehouse bevMart) {
		this.bevMart = bevMart;
	}
	
	public List<Beverage> findByBeverageName(String name) {
		return this.bevMart.findByName(name);
	}
	
	public Beverage addNewMenuItem(Beverage newBev) {
		this.bevMart.save(newBev);
		return newBev;
	}
}
