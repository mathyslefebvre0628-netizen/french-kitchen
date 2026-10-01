package fr.mathyslefebvre.frenchkitchen;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LettuceCropBlock extends CropBlock {
    public LettuceCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LETTUCE_SEEDS;
    }
}
