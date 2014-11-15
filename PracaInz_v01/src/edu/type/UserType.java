package edu.type;

public enum UserType {
		
	ADMIN ("Administrator", 1),
	CUSTOMER ("Klient Biznesowy", 2);

	private String name;
	private int id;

	private UserType(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public int getId() {
		return id;
	}
	
}
