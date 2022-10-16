package net.saddlercoms.radiodensity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.saddlercoms.radiodensity.db.dao.RStationDAO;
import net.saddlercoms.radiodensity.db.model.RStation;

@SpringBootApplication
public class RadiodensityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RadiodensityApplication.class, args);
	}

	
	@Autowired RStationDAO rsDAO;
	
	@Override
	public void run(String... args) throws Exception {
		List<RStation> allStation = rsDAO.findAll();
		System.out.println("** FIRST 10 STATIONS **");
		allStation.stream().limit(10).forEach(System.out::println);
	}

	
}
