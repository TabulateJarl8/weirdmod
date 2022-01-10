package tech.tabulate.weirdmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.tabulate.weirdmod.block.FunnyBlock;
import tech.tabulate.weirdmod.block.FunnyBlockEntity;

public class WeirdMod implements ModInitializer {
	public static final String MOD_ID = "weirdmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

//	sounds
	public static final Identifier BEEP_SOUND_ID = new Identifier(MOD_ID, "beep");
	public static SoundEvent BEEP_SOUND_EVENT = new SoundEvent(BEEP_SOUND_ID);

//	blocks
	public static final FunnyBlock FUNNY_BLOCK = new FunnyBlock(FabricBlockSettings.of(Material.STONE).strength(-1.0F, 3600000.0F).dropsNothing());
	public static BlockEntityType<FunnyBlockEntity> FUNNY_BLOCK_ENTITY;

//	creative tab
	public static final ItemGroup MAIN_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(FUNNY_BLOCK));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "funny_block"), FUNNY_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "funny_block"), new BlockItem(FUNNY_BLOCK, new Item.Settings().group(WeirdMod.MAIN_ITEM_GROUP)));
		FUNNY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "weirdmod:funny_block_entity", FabricBlockEntityTypeBuilder.create(FunnyBlockEntity::new, FUNNY_BLOCK).build(null));

		Registry.register(Registry.SOUND_EVENT, WeirdMod.BEEP_SOUND_ID, BEEP_SOUND_EVENT);
	}
}
