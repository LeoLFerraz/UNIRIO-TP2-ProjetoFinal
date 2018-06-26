package com.leonardo.ferraz.ecslib;

public abstract class Component {
	// Attributes:
	private final String type = "abstractComponent"; // Must be defined @ child declaration;
	private final int sameEntityTypeLimit = 0; // Must be defined @ child declaration;
	private final int sameEntityInstancesLimit = 1; // Must be defined @ child declaration
	private final String name;
	
	// Constructors:
	Component(String newName) {
		this.name = newName;
	}
	
	// Getters:
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getSameEntityTypeLimit() {
		return this.sameEntityTypeLimit;
	}
	
	public int getSameEntityInstancesLimit() {
		return this.sameEntityInstancesLimit;
	}
	
	// Setters:
	
	// Methods:

}
