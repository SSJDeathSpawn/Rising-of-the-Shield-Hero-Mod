package mod.deathspawn.shield.lib;

public class Reference {

    public static final String MODID = "shield";
    public static final String MODNAME = "The Rising of the Shield Hero Mod";
    public static final String MODVER = "1.12.2-0.1.0";

    public enum ModdedItems {
        SHIELD("shield");

        private String name;
        ModdedItems(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}
