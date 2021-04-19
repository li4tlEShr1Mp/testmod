package com.lobscraft.matrix_technology.util.loaders;

import com.lobscraft.matrix_technology.util.handlers.BlockHandler;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingLoader {
    public static void load() {
        addSmelting(Item.getItemFromBlock(BlockHandler.IRON_METEORITE), Items.IRON_INGOT, 1, 3, 1.5f);
        addSmelting(Item.getItemFromBlock(BlockHandler.MATRIX_CRYSTAL_METEORITE), ItemHandler.MATRIX_CRYSTAL, 1, 1, 1f);

    }

    private static void addSmelting(Item in, Item output, int inNum, int outNum, float experiences) {
        GameRegistry.addSmelting(new ItemStack(in, inNum), new ItemStack(output, outNum), experiences);
    }

    private static void addSmelting(Item in, Item output, float experiences) {
        GameRegistry.addSmelting(new ItemStack(in), new ItemStack(output), experiences);
    }
}
