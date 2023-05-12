package net.dixta.dixtas_armory.item.custom.attributes;

public class AttackAttribute {
    public AttackAttribute(float pKnockback, float pArmorPiercingChance, float pArmorPiercingAmount, float pUnarmoredBonusDamage, int pInvincibilityTime, float pBreachTime, float pBreachChance) {
        knockback = pKnockback;
        armorPiercingChance = pArmorPiercingChance;
        armorPiercingAmount = pArmorPiercingAmount;
        unarmoredBonusDamage = pUnarmoredBonusDamage;
        invincibilityTime = pInvincibilityTime;
        breachTime = pBreachTime;
        breachChance = pBreachChance;
    }


    public float knockback;
    public float armorPiercingChance;
    public float armorPiercingAmount;
    public float unarmoredBonusDamage;
    public int invincibilityTime;
    public float breachTime;
    public float breachChance;

    public static final AttackAttribute none = new AttackAttribute(0,0,0,0,20, 0, 0);
}
