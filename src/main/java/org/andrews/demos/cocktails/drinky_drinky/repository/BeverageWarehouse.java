package org.andrews.demos.cocktails.drinky_drinky.repository;

import java.util.List;

import org.andrews.demos.cocktails.drinky_drinky.entities.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageWarehouse extends CrudRepository<Beverage,Long>{
	public List<Beverage> findByName(String name);
}
