package fr.mathyslefebvre.frenchkitchen;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final String MOD_ID = "french-kitchen";

    public static final Item TOMATO = register("tomato",
            Item::new, new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()));

    public static final Item TOMATO_SLICE = register("tomato_slice",
            Item::new, new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()));

    public static final Item TOMATO_SEEDS = register("tomato_seeds",
            Item::new, new Item.Properties());

    private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties props) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(props.setId(key)));
    }

    public static void init() {
        // Onglet "Nourriture et boissons" du mode Créatif
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register(entries -> {
                    entries.accept(TOMATO);
                    entries.accept(TOMATO_SLICE);
                });

        // Onglet "Blocs naturels" (les graines)
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(entries -> entries.accept(TOMATO_SEEDS));
    }
}
