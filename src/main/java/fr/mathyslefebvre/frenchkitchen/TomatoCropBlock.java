package fr.mathyslefebvre.frenchkitchen;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TomatoCropBlock extends CropBlock {
    public static final MapCodec<TomatoCropBlock> CODEC = simpleCodec(TomatoCropBlock::new);

    public TomatoCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<TomatoCropBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TOMATO_SEEDS;
    }
}
