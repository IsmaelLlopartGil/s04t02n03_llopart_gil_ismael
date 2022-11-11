package cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.controllers;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.model.services.FruitService;

@RestController
@RequestMapping("/fruita")
public class FruitController {

	@Autowired
	private FruitService fruitService;

	@PostConstruct
	public void init() {
		fruitService.save(new Fruit("Fruita 1", 15));
		fruitService.save(new Fruit("Fruita 2", 20));
		fruitService.save(new Fruit("Fruita 3", 50));
	}

	@PostMapping("/add")
	public ResponseEntity<Fruit> add(@Valid @RequestBody Fruit fruit) {
		fruitService.save(fruit);
		return ResponseEntity.ok(fruit);
	}

	@PutMapping("/update")
	public ResponseEntity<Fruit> update(@Valid @RequestBody Fruit updatedFruit) {
		Optional<Fruit> fruit = fruitService.findById(updatedFruit.getId());

		if (fruit.isPresent()) {
			fruitService.save(updatedFruit);
			return ResponseEntity.ok(updatedFruit);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Fruit> delete(@PathVariable String id) {
		Optional<Fruit> fruit = fruitService.findById(id);

		if (fruit.isPresent()) {
			fruitService.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/get-one/{id}")
	public ResponseEntity<Fruit> getOne(@PathVariable String id) {
		Optional<Fruit> fruit = fruitService.findById(id);

		if (fruit.isPresent()) {
			return ResponseEntity.ok(fruit.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<Fruit>> getAll() {
		return ResponseEntity.ok(fruitService.findAll());
	}
}
