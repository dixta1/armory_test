package net.dixta.dixtas_armory.item.custom.attributes;

public class TwoHandedAttribute {
    public TwoHandedAttribute(int pLevel, int pMinDamage, int pMajDamage, float pMinSpeed, float pMajSpeed) {
        level = pLevel;
        minDamage = pMinDamage;
        majDamage = pMajDamage;
        minSpeed = pMinSpeed;
        majSpeed = pMajSpeed;
    }
    public int level;
    public int minDamage;
    public int majDamage;
    public float minSpeed;
    public float majSpeed;

    public static final TwoHandedAttribute none = new TwoHandedAttribute(0,0,0,0,0);
}
