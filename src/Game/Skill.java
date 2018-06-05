package Game;

public enum Skill {
	
	FIREBALL("offensive", 50, 2, 1, 1, 1);
	
	private String skillType;
	private int baseValue;
	private int strenghtModifier;
	private int enduranceModifier;
	private int intelligenceModifier;
	private int luckModifier;
	
	Skill(String skillType, int baseValue, int strenghtModifier, int enduranceModifier, int intelligenceModifier,
			int luckModifier)
	{
		this.skillType = skillType;
		this.baseValue = baseValue;
		this.strenghtModifier = strenghtModifier;
		this.enduranceModifier = enduranceModifier;
		this.intelligenceModifier = intelligenceModifier;
		this.luckModifier = luckModifier;
	}
	
	public int getBaseValue()
	{
		return baseValue;
	}
	
	public int getStrenghtModifier()
	{
		return strenghtModifier;
	}
	
	public int getEnduranceModifier()
	{
		return enduranceModifier;
	}
	
	public int getIntelligenceModifier()
	{
		return intelligenceModifier;
	}
	
	public int getLuckModifier()
	{
		return luckModifier;
	}
	
	public void cast()
	{
		
	}
}
