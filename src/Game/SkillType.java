package Game;

public enum SkillType {

	OFFENSIVE(0), DEFENSIVE(1);
	
	private int type;
	
	SkillType(int type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
}
