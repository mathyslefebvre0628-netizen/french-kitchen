package fr.mathyslefebvre.frenchkitchen;

import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block TOMATO_CROP = register("tomato_crop", TomatoCropBlock::new, cropProperties());
    public static final Block LETTUCE_CROP = register("lettuce_crop", LettuceCropBlock::new, cropProperties());
    public static final Block ONION_CROP = register("onion_crop", OnionCropBlock::new, cropProperties());

    private static BlockBehaviour.Properties cropProperties() {
        return BlockBehaviour.Properties.of().noCollision().randomTicks().instabreak()
                .sound(SoundType.CROP).pushReaction(PushReaction.DESTROY);
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory,
                                  BlockBehaviour.Properties props) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
                Identifier.fromNamespaceAndPath(ModItems.MOD_ID, name));
        return Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(props.setId(key)));
    }

    public static void init() {}
}
