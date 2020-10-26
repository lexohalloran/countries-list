package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CountryController {

	private final CountryRepository repo;

	public CountryController(CountryRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/countries")
	List<Country> all() {
		return repo.findAll();
	}

	@PostMapping("/countries")
	Country newCountry(@RequestBody Country country) {
		return repo.save(country);
	}

	@DeleteMapping("/countries/{name}")
	void deleteCountry(@PathVariable String name) {
		repo.deleteById(name);
	}
}
