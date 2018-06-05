package Game;

public enum SkillType {

	OFFENSIVE("offensive"), DEFENSIVE("defensive");
	
	private String type;
	
	SkillType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
}
