package automotives;

public abstract class Vehicle {
	
	private int ID;
	private String type;
	
	private String maker;
	private String colour;
	
	public Vehicle(int ID, String type, String maker, String colour) {
		super();
		this.ID = ID;
		this.type = type;
		this.maker = maker;
		this.colour = colour;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	

	@Override
	public String toString() {
		return "ID=" + ID + ", type=" + type + ", maker=" + maker + ", colour=" + colour;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (ID != other.ID)
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (maker == null) {
			if (other.maker != null)
				return false;
		} else if (!maker.equals(other.maker))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public abstract double calculateCost();
	
}
