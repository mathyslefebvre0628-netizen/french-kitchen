package fr.mathyslefebvre.frenchkitchen;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LettuceCropBlock extends CropBlock {
    public static final MapCodec<LettuceCropBlock> CODEC = simpleCodec(LettuceCropBlock::new);

    public LettuceCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<LettuceCropBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LETTUCE_SEEDS;
    }
}
