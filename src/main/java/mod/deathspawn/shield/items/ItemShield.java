package mod.deathspawn.shield.items;


import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemShield extends ItemBase {

    public ItemShield(String unlocalizedName){
        super(unlocalizedName);
    }

    @Override
    public void registerModels() {
        ModelBakery.registerItemVariants(this, new ModelResourceLocation("shield:shield_normal", "inventory"), new ModelResourceLocation("shield:shield_normal_3d", "inventory"));
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, "shield_normal"), "inventory"));
    }
}
