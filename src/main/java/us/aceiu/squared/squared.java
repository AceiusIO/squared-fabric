package us.acei.squared;

import java.util.Arrays;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;

public class squared implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("[SQ] INITALISED! :D");
	}
}
