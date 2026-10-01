package fr.mathyslefebvre.frenchkitchen;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OnionCropBlock extends CropBlock {
    public static final MapCodec<OnionCropBlock> CODEC = simpleCodec(OnionCropBlock::new);

    public OnionCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<OnionCropBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.ONION_SEEDS;
    }
}
