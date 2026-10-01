package fr.mathyslefebvre.frenchkitchen;

import java.util.function.Function;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItems {
    public static final String MOD_ID = "french-kitchen";

    // --- Legumes (recoltes des plantes) ---
    public static final Item TOMATO = register("tomato", Item::new, food(3, 0.3f));
    public static final Item LETTUCE = register("lettuce", Item::new, food(2, 0.3f));
    public static final Item ONION = register("onion", Item::new, food(2, 0.2f));

    // --- Ingredients prepares ---
    public static final Item TOMATO_SLICE = register("tomato_slice", Item::new, food(1, 0.2f));

    // --- Graines (plantent les cultures) ---
    public static final Item TOMATO_SEEDS = register("tomato_seeds",
            props -> new BlockItem(ModBlocks.TOMATO_CROP, props), new Item.Properties().useItemDescriptionPrefix());
    public static final Item LETTUCE_SEEDS = register("lettuce_seeds",
            props -> new BlockItem(ModBlocks.LETTUCE_CROP, props), new Item.Properties().useItemDescriptionPrefix());
    public static final Item ONION_SEEDS = register("onion_seeds",
            props -> new BlockItem(ModBlocks.ONION_CROP, props), new Item.Properties().useItemDescriptionPrefix());

    // --- Plats ---
    public static final Item TOMATO_SOUP = register("tomato_soup", Item::new,
            food(7, 0.7f).stacksTo(1).usingConvertsTo(Items.BOWL));
    public static final Item SALAD = register("salad", Item::new,
            food(6, 0.6f).stacksTo(1).usingConvertsTo(Items.BOWL));
    public static final Item SANDWICH = register("sandwich", Item::new, food(8, 0.8f));
    public static final Item BURGER = register("burger", Item::new, food(10, 0.9f));
    public static final Item BAGUETTE = register("baguette", Item::new, food(6, 0.7f));
    public static final Item CROISSANT = register("croissant", Item::new, food(5, 0.5f));
    public static final Item FRIED_EGG = register("fried_egg", Item::new, food(5, 0.6f));

    private static Item.Properties food(int nutrition, float saturation) {
        return new Item.Properties().food(
                new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build());
    }

    private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties props) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(props.setId(key)));
    }

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            entries.accept(TOMATO);
            entries.accept(LETTUCE);
            entries.accept(ONION);
            entries.accept(TOMATO_SLICE);
            entries.accept(TOMATO_SOUP);
            entries.accept(SALAD);
            entries.accept(SANDWICH);
            entries.accept(BURGER);
            entries.accept(BAGUETTE);
            entries.accept(CROISSANT);
            entries.accept(FRIED_EGG);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.accept(TOMATO_SEEDS);
            entries.accept(LETTUCE_SEEDS);
            entries.accept(ONION_SEEDS);
        });
    }
}
