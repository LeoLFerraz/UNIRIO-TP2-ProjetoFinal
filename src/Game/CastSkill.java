package Game;

public interface CastSkill {
	
	/*public static void castSkill(int skillNumber, Actor caster, Actor target) 
	{
		Skill.values()[skillNumber - 1].cast(caster, target);
	}*/
	public static void castSkill(Skill skillNumber, Actor caster, Actor target) 
	{
		skillNumber.cast(caster, target);
	}
}
