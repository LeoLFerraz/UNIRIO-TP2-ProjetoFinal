package com.leonardo.ferraz.ecslib;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Entity {
	// Attributes:
	private static final AtomicInteger idCounter = new AtomicInteger(); // Using AtmInt for the Entity ID in an attempt to be thread-safe;
	private final String type = "abstractEntity";
	private final int entId;
	ArrayList<Component> components; // All of the entity's "data" is stored here;
	private final int sameComponentTypeLimit = 0;
	private final int sameComponentInstanceLimit = 0;
	
	// Constructors:
	Entity() {
		this.entId = Entity.idCounter.incrementAndGet();
		this.components = new ArrayList<Component>();
	}
	
	// Getters:
	public int getEntId() {
		return this.entId;
	}
	
	public ArrayList<Component> getComps() {
		return this.components;
	}

	public ArrayList<Component> getComps(ArrayList<String> componentsNames) {
		ArrayList<Component> getResult = new ArrayList<Component>();
		for (Component component : this.components) {
			if (componentsNames.contains(component.getName())) {
				getResult.add(component);
			}
		}
		return getResult;
	}
	
	public Component getComp(int arrayIndex) {
		return components.get(arrayIndex);
	}
	
	public Component getComp(String componentName) {
		for (Component component : this.components) {
			if (component.getName().equals(componentName)) {
				return component;
			}
		}
		return null;
		// [Must add exception tries]
	}
	
	public int getSameComponentTypeLimit() {
		return this.sameComponentTypeLimit;
	}
	
	public int getSameComponentInstanceLimit() {
		return this.sameComponentInstanceLimit;
	}
	
	// Setters:
	public boolean sAddComp(Component comp) {
		String compType = comp.getType();
		int compTypeLimit = comp.getSameEntityTypeLimit();
		int compInstancesLimit = comp.getSameEntityInstancesLimit();
		int numberOfSameTypeComps = 0;
		int numberOfCompInstances = 0;
		for (Component component : this.components) {
			if (component.getName().equals(comp.getName())) {
				
			}
			else {
				if (component.getType().equals(comp.getType())) {
					numberOfSameTypeComps++;
				}
			}
		}
	}
	
	public boolean fAddComp(Component comp) {
		this.components.add(comp);
	}
	
	// Methods:
	public boolean hasComp(Component component) {
		for (Component i : this.components) {
			if (i == component) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasComp(String componentName) {
		for (Component i : this.components) {
			if (i.getName().equals(componentName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() { // Returns true if entity has no components;
		if (this.components.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean hasCompType(String typeName) { // Returns true if entity has at least one of that component type;
		for (Component component : this.components) {
			if (component.getType().equals(typeName)) {
				return true;
			}
		}
		return false;
	}
}
