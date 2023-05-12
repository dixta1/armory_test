package net.dixta.dixtas_armory.item.custom.attributes;

public class SweepAttribute {
    public SweepAttribute(boolean pCanSweep, float pSweepDamage, float pSweepRadiusX) {
        canSweep = pCanSweep;
        sweepDamage = pSweepDamage;
        sweepRadiusX = pSweepRadiusX;
    }
    public boolean canSweep;
    public float sweepDamage;
    public float sweepRadiusX;


    public static final SweepAttribute none = new SweepAttribute(false, 0,0);
    public static final SweepAttribute normal = new SweepAttribute(true,1,1);
}
