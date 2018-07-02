package corepckg;

import java.util.ArrayList;

public abstract class Actor {
	// Attributes:
	private final String name;
	private int maxHp;
	private int currentHp;
	private int strength;
	private int endurance;
	private int intelligence;
	private int level;
	private ArrayList<Skill> skillSet;
	
	// Constructors:
	Actor(String newName) {
		this.name = newName;
		skillSet = new ArrayList<Skill>();
	}
	
	// Getters:
	public String getName() {
		return this.name;
	}
	
	public int getCurHp() {
		return this.currentHp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getStr() {
		return this.strength;
	}
	
	public int getEnd() {
		return this.endurance;
	}
	
	public int getInt() {
		return this.intelligence;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public ArrayList<Skill> getSkillSet() {
		return this.skillSet;
	}
	
	// Setters:
	public void updateMaxHp() {
		// [need validations]
		this.maxHp = this.endurance*10;
	}
	
	public void modifyHp(int modifier) { // [Should probably return finalHp rather than void...]
		int finalHp = this.currentHp + modifier;
		if (finalHp > this.maxHp) {
			finalHp = this.maxHp;
		}
		else if (finalHp < 0) {
			finalHp = 0;
		}
		this.currentHp = finalHp;
	}
	
	public void setHp(int newHp) {
		// [need validations]
		this.currentHp = newHp;
	}

	// Attribute Setters. Ideally, these would get [baseAttr + (attrOnLevelUp * level) + treasureBonusList], but we haven't enough time to re-model the system to
	// validate treasure bonuses. Instead, they use traditional setters.
	public void setStr(int newStr) {
		// [need validations]
		this.strength = newStr;
	}
	
	public void setEnd(int newEnd) {
		// [need validations]
		this.endurance = newEnd;
	}
	
	public void setInt(int newInt) {
		// [need validations]
		this.intelligence = newInt;
	}
	
	public void levelUp() {
		// [need validations]
		this.level++;
		
	}
	
	public void addSkill(Skill skill) {
		this.skillSet.add(skill);
	}
	
	// Methods:
}
