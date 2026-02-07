package net.astro142.testmod4finale.sound;

import net.astro142.testmod4finale.TestMod4Finale;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TestMod4Finale.MOD_ID);

    public static final Supplier<SoundEvent> WAND_SOUND = registerSoundEvent("wand_sound");

//    public static final Supplier<SoundEvent> MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
//    public static final Supplier<SoundEvent> MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
//    public static final Supplier<SoundEvent> MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
//    public static final Supplier<SoundEvent> MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
//    public static final Supplier<SoundEvent> MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");
//
//    public static final DeferredSoundType MAGIC_BLOCK_SOUNDS = new DeferredSoundType(1f, 1f,
//            ModSounds.MAGIC_BLOCK_BREAK, ModSounds.MAGIC_BLOCK_STEP, ModSounds.MAGIC_BLOCK_PLACE,
//            ModSounds.MAGIC_BLOCK_HIT, ModSounds.MAGIC_BLOCK_FALL);

    public static final Supplier<SoundEvent> GNB_MUSIC_1 = registerSoundEvent("gnb_music_1");
    public static final Supplier<SoundEvent> GNB_MUSIC_2 = registerSoundEvent("gnb_music_2");
    public static final Supplier<SoundEvent> GNB_MUSIC_3 = registerSoundEvent("gnb_music_3");
    public static final Supplier<SoundEvent> GNB_MUSIC_4 = registerSoundEvent("gnb_music_4");
    public static final Supplier<SoundEvent> GNB_MUSIC_5 = registerSoundEvent("gnb_music_5");

    public static final ResourceKey<JukeboxSong> GNB_MUSIC_1_KEY = createSong("gnb_music_1");
    public static final ResourceKey<JukeboxSong> GNB_MUSIC_2_KEY = createSong("gnb_music_2");
    public static final ResourceKey<JukeboxSong> GNB_MUSIC_3_KEY = createSong("gnb_music_3");
    public static final ResourceKey<JukeboxSong> GNB_MUSIC_4_KEY = createSong("gnb_music_4");
    public static final ResourceKey<JukeboxSong> GNB_MUSIC_5_KEY = createSong("gnb_music_5");


    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
