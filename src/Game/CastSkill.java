package corepckg;

public interface CastSkill {
	// Ideally, we'd have the entire casting system: 
	// CastSkill determines which entities can cast;
	// Targetable (ou SkillTargetable) determines which entities can be targeted by skills;
	// Time only allowed us to implement this share of the system.
	public int castSkill(int skillIndex, Actor target);
	// [REFACTORING to the event-based architecture will require this interface to communicate with GameDirector to acquire caster and target.]
}
