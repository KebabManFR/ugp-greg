package gregtech.common.blocks;

import gregtech.api.block.IStateHarvestLevel;
import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockSteamCasing extends VariantBlock<BlockSteamCasing.SteamCasingType> {

    public BlockSteamCasing() {
        super(Material.IRON);
        setTranslationKey("steam_casing");
        setHardness(4.0f);
        setResistance(8.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(SteamCasingType.WOOD_WALL));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, @NotNull List<String> tooltip,
                               @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
    }

    public enum SteamCasingType implements IStringSerializable, IStateHarvestLevel {

        PUMP_DECK("pump_deck", 1),
        WOOD_WALL("wood_wall", 0);

        private final String name;
        private final int harvestLevel;

        SteamCasingType(String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
        }

        @Override
        @NotNull
        public String getName() {
            return name;
        }

        @Override
        public int getHarvestLevel(IBlockState state) {
            return harvestLevel;
        }

        @Override
        public String getHarvestTool(IBlockState state) {
            return ToolClasses.WRENCH;
        }
    }
}
