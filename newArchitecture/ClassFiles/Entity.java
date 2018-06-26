package com.leonardo.ferraz.ecslib;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Entity {
	// Attributes:
	private static final AtomicInteger idCounter = new AtomicInteger(); // Using AtmInt for the Entity ID in an attempt to be thread-safe;
	private final int entId;
	ArrayList<Component> components; // All of the entity's "data" is stored here;
	
	// Constructors:
	Entity() {
		this.entId = Entity.idCounter.incrementAndGet();
		this.components = new ArrayList<Component>();
	}
	
	// Getters:
	public int getEntId() {
		return this.entId;
	}
	
	public ArrayList<Component> getComponents() {
		return this.components;
	}

	public ArrayList<Component> getComponents(ArrayList<String> componentsNames) {
		ArrayList<Component> getResult = new ArrayList<Component>();
		for (Component component : this.components) {
			if (componentsNames.contains(component.getName())) {
				getResult.add(component);
			}
		}
		return getResult;
	}
	
	public Component getComponent(int arrayIndex) {
		return components.get(arrayIndex);
	}
	
	public Component getComponent(String componentName) {
		for (Component component : this.components) {
			if (component.getName().equals(componentName)) {
				return component;
			}
		}
		return null;
		// [Must add exception tries]
	}
	
	public boolean isEmpty() { // Return true if it has no components;
		if (this.components.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Setters:
	
	// Methods:
	public boolean hasComponent(Component component) {
		for (Component i : this.components) {
			if (i == component) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasComponent(String componentName) {
		for (Component i : this.components) {
			if (i.getName().equals(componentName)) {
				return true;
			}
		}
		return false;
	}
}
