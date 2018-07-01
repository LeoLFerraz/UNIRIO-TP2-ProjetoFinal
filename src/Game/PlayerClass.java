package corepckg;
import java.util.ArrayList;

public enum PlayerClass {
	// Instances:
	WARRIOR("Warrior", 20, 15, 5, 5, 2, 2, 0, 0, 1, Skill.SWORDATTACK, Skill.MORTALASSAULT, Skill.BIGSHIELD, Skill.TWOHANDEDSWORDATTACK),
	RANGER("Ranger", 10, 15, 10, 10, 2, 1, 1, 1, 2, Skill.FIREARROW, Skill.ICEARROW, Skill.RUN, Skill.ALMIGHTYARROW),
	WIZARD("Wizard", 5, 10, 20, 10, 0, 1, 3, 1, 3, Skill.FIREBALL, Skill.EARTHQUAKE, Skill.MAGICSLAM, Skill.MAGICWAVE),
	THIEF("Thief", 10, 10, 10, 20, 1, 1, 1, 3, 4, Skill.STEALTHASSAULT, Skill.STEALINGMOVE, Skill.MASTEREVASIVE, Skill.MASSIVEQUICKATTACKS);
	
	// Attributes:
	private final String className;
	private final int baseStr;
	private final int baseEnd;
	private final int baseInt;
	private final int baseLuck;
	private final int strOnLevelUp;
	private final int endOnLevelUp;
	private final int intOnLevelUp;
	private final int luckOnLevelUp;
	private final int classCode;
	private final ArrayList<Skill> classSkillSet;
	
	// Constructors:
	PlayerClass(String cName, int bStr, int bEnd, int bInt, int bLuck, int strLU, int endLU, int intLU, int luckLU, int cCode, Skill...skills) {
		this.className = cName;
		this.baseStr = bStr;
		this.baseEnd = bEnd;
		this.baseInt = bInt;
		this.baseLuck = bLuck;
		this.strOnLevelUp = strLU;
		this.endOnLevelUp = endLU;
		this.intOnLevelUp = intLU;
		this.luckOnLevelUp = luckLU;
		this.classCode = cCode;
		classSkillSet = new ArrayList<Skill>();
		for(Skill skill : skills) {
			classSkillSet.add(skill);
		}
	}
	
	// Getters:
	public String getClassName() {
		return this.className;
	}
	
	public int getBaseStr() {
		return this.baseStr;
	}
	public int getBaseEnd() {
		return this.baseEnd;
	}
	public int getBaseInt() {
		return this.baseInt;
	}
	public int getBaseLuck() {
		return this.baseLuck;
	}
	public int getStrOnLevelUp() {
		return this.strOnLevelUp;
	}
	public int getEndOnLevelUp() {
		return this.endOnLevelUp;
	}
	public int getIntOnLevelUp() {
		return this.intOnLevelUp;
	}
	public int getLuckOnLevelUp() {
		return this.luckOnLevelUp;
	}
	
	public int getClassCode() {
		return this.classCode;
	}
	
	public ArrayList<Skill> getClassSkillSet() {
		return this.classSkillSet;
	}
	
	public static PlayerClass getClassByClassCode(int classCode) {
		// [NEED REFACTORING]
		switch(classCode) {
			case 1: return PlayerClass.WARRIOR;
			case 2: return PlayerClass.RANGER;
			case 3: return PlayerClass.WIZARD;
			case 4: return PlayerClass.THIEF;
		}
		// No treatment needed here. This is a composed function only. Treat the caller for null point exception plz.
		return null;
	}
	
	// Testing:
	public static void main(String[] args) {
		System.out.println(PlayerClass.RANGER.classSkillSet);
	}
}
