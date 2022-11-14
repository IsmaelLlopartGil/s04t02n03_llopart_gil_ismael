package cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.model.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.model.domain.Fruit;

public interface FruitService {

	public void save(Fruit fruit);

	public Optional<Fruit> findById(String id);

	public void deleteById(String id);

	public List<Fruit> findAll();
}
