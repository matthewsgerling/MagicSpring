package dmacc.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="card")
public class SpringMagic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private int manacost;
	
	public SpringMagic( ) {
		super();
		
	}

	public SpringMagic(String name, String type, int cost) {
		super();
		this.name = name;
		this.type = type;
		this.manacost = cost;
	}


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getManacost() {
		return manacost;
	}

	public void setManacost(int manacost) {
		this.manacost = manacost;
	}

	@Override
	public String toString() {
		return "Card Info [id ="  + id +" , name=" + name + ", type=" + type + ", manacost=" + manacost + "]";
	}
}


