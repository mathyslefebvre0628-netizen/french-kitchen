package fr.mathyslefebvre.frenchkitchen;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OnionCropBlock extends CropBlock {
    public OnionCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.ONION_SEEDS;
    }
}
