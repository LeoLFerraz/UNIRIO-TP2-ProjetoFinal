package corepckg;

public enum Skill {
	//Wizard's skills
	FIREBALL(50, 0, 0, 2),
	EARTHQUAKE(100, 0, 0, 2),
	MAGICSLAM(70, 0, 2, 0),
	MAGICWAVE(200, 0, 0, 3), 
	
	//Warrior's skills
	SWORDATTACK(45, 2, 0, 0),
	MORTALASSAULT(120, 2, 0, 0),
	BIGSHIELD(100, 0, 0, 0),
	TWOHANDEDSWORDATTACK(200, 3, 0, 0),
	
	//Thief's skills
	STEALTHASSAULT(60, 0, 2, 0),
	STEALINGMOVE(100, 0, 2, 0),
	MASTEREVASIVE(100, 0, 2, 0),
	MASSIVEQUICKATTACKS(200, 0, 3, 0),
	
	//Ranger's skills
	FIREARROW(70, 1, 1, 1),
	ICEARROW(100, 1, 1, 1),
	RUN(90, 1, 1, 1),
	ALMIGHTYARROW(180, 1, 1, 1);
	
	
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
	
	public void cast(Actor caster, Actor target)
	{
		
	}
}
