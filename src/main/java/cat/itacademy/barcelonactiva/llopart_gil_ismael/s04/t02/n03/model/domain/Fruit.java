package cat.itacademy.barcelonactiva.llopart_gil_ismael.s04.t02.n03.model.domain;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (value = "fruit")
public class Fruit implements Serializable {

	private static final long serialVersionUID = -5547302257752530658L;

	@Id
	@Indexed(unique=true)
	private String id;
	
	@NotBlank (message = "El nom és obligatori.")
	private String name;
	
	@NotNull (message = "La quantitat és obligatòria.")
	private int numberOfKilograms;
	
	
	public Fruit() {}
	
	public Fruit(String name, int numberOfKilograms) {
		this.name = name;
		this.numberOfKilograms = numberOfKilograms;
	}
	
	public String getId() {
		return id;
	}

	public String getName () {
		return name;
	}
	
	public int getNumberOfKilograms () {
		return numberOfKilograms;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfKilograms(int numberOfKilograms) {
		this.numberOfKilograms = numberOfKilograms;
	}
}
