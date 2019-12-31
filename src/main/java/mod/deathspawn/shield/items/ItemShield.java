package mod.deathspawn.shield.items;

import com.google.common.collect.ImmutableList;
import mod.deathspawn.shield.handlers.EnumHandler;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

// TODO Fix the Biome Change Event

public class ItemShield extends ItemMetadataBase {

    public ItemShield(String unlocalizedName){
        super(unlocalizedName);
        this.maxStackSize = 1;
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.addPropertyOverride(new ResourceLocation("shield:blocking"), new IItemPropertyGetter() {
            @Override
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        //BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(EnumHandler.SHIELDS s: EnumHandler.SHIELDS.values()) {
            items.add(new ItemStack(this, 1, s.getId()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        for(EnumHandler.SHIELDS s: EnumHandler.SHIELDS.values()) {
            if(stack.getItemDamage() == s.getId()) {
                return this.getUnlocalizedName() + "." + s.getName();
            }
        }
        return this.getUnlocalizedName() + "." + EnumHandler.SHIELDS.NORMAL.getName();
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(stack.getItemDamage() == EnumHandler.SHIELDS.CAMOUFLAGE.getId()) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
                stack.setTagCompound(nbt);
            }
            if(nbt.hasKey("modValues")) {
                NBTTagCompound nbtMod = nbt.getCompoundTag("modValues");
                nbtMod.setBoolean("colorReset", true);
                nbt.setTag("modValues", nbtMod);
            } else {
                NBTTagCompound nbtMod = new NBTTagCompound();
                nbtMod.setBoolean("colorReset", true);
                nbt.setTag("modValues", nbtMod);
            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public boolean hasColor(ItemStack stack)
    {
        if (stack.getItemDamage() != EnumHandler.SHIELDS.CAMOUFLAGE.getId())
        {
            return false;
        }
        else
        {
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
        }
    }

    public void setColor(ItemStack stack, int color)
    {
        if (stack.getItemDamage() == EnumHandler.SHIELDS.CAMOUFLAGE.getId())
        {
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            if (nbttagcompound == null) {
                nbttagcompound = new NBTTagCompound();
                stack.setTagCompound(nbttagcompound);
            }
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
            if (!nbttagcompound.hasKey("display", 10)) {
                nbttagcompound.setTag("display", nbttagcompound1);
            }
            nbttagcompound1.setInteger("color", color);
        }
    }

    public int getColor(ItemStack stack) {
        if (stack.getItemDamage() != EnumHandler.SHIELDS.CAMOUFLAGE.getId()) {
            return 16777215;
        } else {
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            if (nbttagcompound != null) {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3)) {
                    return nbttagcompound1.getInteger("color");
                }
            }
            return 10511680;
        }
    }

    public void removeColor(ItemStack stack) {
        if (stack.getItemDamage() == EnumHandler.SHIELDS.CAMOUFLAGE.getId()) {
            NBTTagCompound nbttagcompound = stack.getTagCompound();
            if (nbttagcompound != null) {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                if (nbttagcompound1.hasKey("color")) {
                    nbttagcompound1.removeTag("color");
                }
            }
        }
    }

    /*public boolean hasOverlay(ItemStack stack) {
        return stack.getItemDamage() == EnumHandler.SHIELDS.CAMOUFLAGE.getId() || getColor(stack) != 0x00FFFFFF;
    }*/

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BLOCK;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagCompound nbt = stack.getTagCompound();
        if(stack.getItemDamage() == EnumHandler.SHIELDS.CAMOUFLAGE.getId()) {
            if (nbt != null && nbt.hasKey("display")) {
                NBTTagCompound nbtMod = nbt.getCompoundTag("display");
                if (nbtMod.hasKey("color")) {
                    tooltip.add("Biome: " + worldIn.getBiome(Minecraft.getMinecraft().player.getPosition()));
                    tooltip.add("Color: " + nbtMod.getInteger("color"));
                }
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void registerModels() {
        List<ModelResourceLocation> mrls = new ArrayList<ModelResourceLocation>();
        for (EnumHandler.SHIELDS s: EnumHandler.SHIELDS.values()) {
            ImmutableList<ModelResourceLocation> MList = ImmutableList.of(new ModelResourceLocation("shield:shield_" + s.getName(), "inventory"),
                    new ModelResourceLocation("shield:shield_" + s.getName() + "_3d", "inventory"));
            mrls.addAll(MList);
        }
        ModelBakery.registerItemVariants(this, mrls.toArray(new ModelResourceLocation[0]));
        for (EnumHandler.SHIELDS s: EnumHandler.SHIELDS.values()) {
            ModelLoader.setCustomModelResourceLocation(this, s.getId(), new ModelResourceLocation(new ResourceLocation(Reference.MODID, "shield_p" + s.getName()), "inventory"));
        }
    }
}
