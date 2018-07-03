package corepckg;

public enum Skill { // [NEED TO ADD "skillName" VARIABLE FOR INTERFACE-OUTPUT MATTERS]
	//Wizard's skills
	FIREBALL(50, 0, 0, 2),
	EARTHQUAKE(100, 0, 0, 2),
	MAGICSLAM(70, 0, 2, 0),
	MAGICWAVE(200, 0, 0, 3), 
	
	//Warrior's skills
	SWORDSLASH(45, 2, 0, 0),
	ASSAULT(120, 2, 0, 0),
	SHIELDSLAM(100, 0, 0, 0),
	PUMMELING(200, 3, 0, 0),
	
	//Thief's skills
	STEALTHASSAULT(60, 0, 2, 0),
	STEALINGMOVE(100, 0, 2, 0),
	BURGLARY(100, 0, 2, 0),
	RIPOSTE(200, 0, 3, 0),
	
	//Ranger's skills
	FIREARROW(70, 1, 1, 1),
	ICEARROW(100, 1, 1, 1),
	MYSTICPOWDER(90, 1, 1, 1),
	ANIMALCOMPANION(180, 1, 1, 1);
	
	
	private int baseValue;
	private int strengthModifier;
	private int enduranceModifier;
	private int intelligenceModifier;
	
	Skill(int baseValue, int strengthModifier, int enduranceModifier, int intelligenceModifier)
	{
		this.baseValue = baseValue;
		this.strengthModifier = strengthModifier;
		this.enduranceModifier = enduranceModifier;
		this.intelligenceModifier = intelligenceModifier;
	}
	
	public int getBaseValue()
	{
		return baseValue;
	}
	
	public String getName() { // [ONCE REFACTORED, USE VARIABLE skillName INSTEAD OF ENUM NATIVE ATTR]
		return this.name();
	}
	
	public int getStrengthModifier()
	{
		return strengthModifier;
	}
	
	public int getEnduranceModifier()
	{
		return enduranceModifier;
	}
	
	public int getIntelligenceModifier()
	{
		return intelligenceModifier;
	}
	
	public int cast(Actor caster, Actor target) { // [Needs refactoring to allow multiple entities as target.]
		// [Add scale to allow healing casts, rather than only damaging ones. 
		// This will require the addition of a targeting interface @ GameDirector's ExecuteBattle()]
		int casterStr = caster.getStr();
		int casterEnd = caster.getEnd();
		int casterInt = caster.getInt();
		int baseValue = this.baseValue;
		int casterStrBonus = (baseValue/100)*casterStr;
		int casterEndBonus = (baseValue/100)*casterEnd;
		int casterIntBonus = (baseValue/100)*casterInt;
		int finalValue = baseValue + casterStrBonus + casterEndBonus + casterIntBonus;
		// [A scalable form of finalValue would receive an arrayList of bonuses, as they could come from different 'messages' or 'events' 
		// other than 'player.castSkill';
		target.modifyHp(finalValue*-1); // -1 because it's a damaging skill. This equation will be reworked to a "cleaner" version
										// once the multiple-entity target system is implemented.
		return finalValue;
	}
}
