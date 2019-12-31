package mod.deathspawn.shield.handlers;

import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventHandler {

    // TODO Fix the Biome Change Event

    @SubscribeEvent
    public static void onEveryLivingTick(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.getEntityLiving();
            if(player.inventory.hasItemStack(new ItemStack(ModItems.shield, 1, EnumHandler.SHIELDS.CAMOUFLAGE.getId())))  {
                int slot = player.inventory.getSlotFor(new ItemStack(ModItems.shield, 1, EnumHandler.SHIELDS.CAMOUFLAGE.getId()));
                ItemStack stack = player.inventory.getStackInSlot(slot);
                NBTTagCompound nbt = stack.getTagCompound();
                if(nbt != null && nbt.hasKey("modValues")) {
                    NBTTagCompound nbtMod = nbt.getCompoundTag("modValues");
                    if(nbtMod.hasKey("colorReset") && nbtMod.getBoolean("colorReset")) {
                        int grassColor = player.getEntityWorld().getBiome(player.getPosition()).getGrassColorAtPos(player.getPosition());
                        ShieldHeroMod.logger.info("Biome Changed!");
                        ModItems.shield.setColor(stack, grassColor);
                        nbtMod.setBoolean("colorReset", false);
                        //ModItems.shield.currentBiome = player.getEntityWorld().getBiome(player.getPosition());
                        nbt.setTag("modValues", nbtMod);
                    }
                }
            }
        }
    }

}
