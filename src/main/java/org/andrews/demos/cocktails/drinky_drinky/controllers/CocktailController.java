package org.andrews.demos.cocktails.drinky_drinky.controllers;

import java.util.Arrays;

import org.andrews.demos.cocktails.drinky_drinky.entities.Beverage;
import org.andrews.demos.cocktails.drinky_drinky.entities.BeverageCategory;
import org.andrews.demos.cocktails.drinky_drinky.services.BeverageManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocktailController {
	
	private final BeverageManager barBack;
	
	Logger logger = Logger.getLogger(CocktailController.class.getName());
	
	public CocktailController(BeverageManager barPerson) {
		this.barBack = barPerson;
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Object index() {
		return new ResponseEntity(Arrays.asList(BeverageCategory.values()), HttpStatus.OK);
	}
	
	@RequestMapping(path="/findall", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.TEXT_PLAIN_VALUE)
	public Object findAllByNameInWarehouse(@RequestBody String name) {
		logger.info("Beverages found: " + barBack.findByBeverageName(name));
		return new ResponseEntity(barBack.findByBeverageName(name), HttpStatus.OK);
	}
	
	@RequestMapping(path="/addmenuitem", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object addMenuItemToWarehouse(@RequestBody Beverage beverage) {
		logger.info("beverage added: " + beverage);
		this.barBack.addNewMenuItem(beverage);
		return new ResponseEntity<Beverage>(beverage, HttpStatus.CREATED);
	}
}
