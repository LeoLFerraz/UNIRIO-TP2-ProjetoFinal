package Game;

public enum Skill {
	
	//Wizard's skills
	FIREBALL(0, 50, 0, 0, 2),
	EARTHQUAKE(0, 100, 0, 0, 2),
	MAGICSHIELD(1, 70, 0, 2, 0),
	MAGICWAVE(0, 200, 0, 0, 3), 
	
	//Warrior's skills
	SWORDATTACK(0, 45, 2, 0, 0),
	MORTALASSAULT(0, 120, 2, 0, 0),
	BIGSHIELD(1, 100, 0, 0, 0),
	TWOHANDEDSWORDATTACK(0, 200, 3, 0, 0),
	
	//Thief's skills
	STEALTHASSAULT(0, 60, 0, 2, 0),
	STEALINGMOVE(0, 100, 0, 2, 0),
	MASTEREVASIVE(1, 100, 0, 2, 0),
	MASSIVEQUICKATTACKS(0, 200, 0, 3, 0),
	
	//Archer's skills
	FIREARROW(0, 70, 1, 1, 1),
	ICEARROW(0, 100, 1, 1, 1),
	RUN(1, 90, 1, 1, 1),
	ALMIGHTYARROW(0, 180, 1, 1, 1);
	
	
	
	private int skillType;
	private int baseValue;
	private int strengthModifier;
	private int enduranceModifier;
	private int intelligenceModifier;
	
	Skill(int skillType, int baseValue, int strengthModifier, int enduranceModifier, int intelligenceModifier)
	{
		this.skillType = skillType;
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
	
	/*public void cast(int actorStrength, int actorEndurance, int actorIntelligence, Actor targetIfOffensive)
	{
		int finalDamage = 0;
		
		finalDamage = this.baseValue + (actorStrength * this.strengthModifier) + (actorEndurance * this.enduranceModifier) + (actorIntelligence * this.intelligenceModifier);
		
		if(this.skillType == SkillType.OFFENSIVE.getType())
		{
			targetIfOffensive.setHp(targetIfOffensive.getHp() - Math.max(finalDamage - targetIfOffensive.getEndurance(), 0));
		}
		else if(this.skillType == SkillType.DEFENSIVE.getType())
		{
			
		}
	}*/
	public void cast(Actor caster, Actor target)
	{
		int finalDamage = 0;
		
		finalDamage = this.baseValue + (caster.getStrength() * this.strengthModifier) + (caster.getEndurance() 
					* this.enduranceModifier) + (caster.getIntelligence() * this.intelligenceModifier);
		
		if(this.skillType == SkillType.OFFENSIVE.getType())
		{
			target.setHp(target.getHp() - Math.max(finalDamage - target.getEndurance(), 0));
		}
		/*else if(this.skillType == SkillType.DEFENSIVE.getType())
		{
			
		}*/
	}
}
