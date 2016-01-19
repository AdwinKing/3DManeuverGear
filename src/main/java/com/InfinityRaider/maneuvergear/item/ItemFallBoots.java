package com.InfinityRaider.maneuvergear.item;

import com.InfinityRaider.maneuvergear.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.List;

public class ItemFallBoots extends ItemArmor implements IItemWithRecipe {
    public ItemFallBoots() {
        super(ArmorMaterial.CLOTH, 0, 3); //(material: cloth, index: cloth, type: boots)
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        LogHelper.debug("registering icon for: " + this.getUnlocalizedName());
        this.itemIcon = reg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag) {
        if(stack != null && stack.getItem() != null) {
            list.add(StatCollector.translateToLocal("3DManeuverGear.ToolTip.boots1"));
            list.add(StatCollector.translateToLocal("3DManeuverGear.ToolTip.boots2"));
        }
    }

    @Override
    public List<IRecipe> getRecipes() {
        List<IRecipe> list = new ArrayList<IRecipe>();
        list.add(new ShapedOreRecipe(new ItemStack(this), "lll", "pbp", "www",
                'l', new ItemStack(Items.leather),
                'p', new ItemStack(Blocks.sticky_piston),
                'b', new ItemStack(Items.leather_boots),
                'w', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE)));
        return list;
    }
}
