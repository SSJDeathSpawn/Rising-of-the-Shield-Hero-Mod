package mod.deathspawn.shield.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

    public enum SHIELDS implements IStringSerializable {
        NORMAL(0, "normal"),
        CAMOUFLAGE(1, "camo");

        int id;
        String name;
        SHIELDS(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }

}
