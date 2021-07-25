package us.acei.squared;
import us.acei.squared.*;

import org.lwjgl.glfw.*;

import net.minecraft.client.*;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.*;
import io.github.cottonmc.cotton.gui.*;

/*@FunctionalInterface
interface ClientModInitializer {
	void onInitializeClient();
}*/

public class main implements ModInitializer {
	private static KeyBinding openClickGui_Key;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Squared has initalised! :D");
		
		print.sqprint("Preparing to define a GUI");

		openClickGui_Key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		    "key.squared.click_gui", // The translation key of the keybinding's name
	    	InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
    		GLFW.GLFW_KEY_RIGHT_SHIFT, // The keycode of the key
    		"category.squared.gui" // The translation key of the keybinding's category.
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openClickGui_Key.wasPressed()) {
				openClickGui();
			}
		});
	}

	public void openClickGui() {
		//client.player.sendMessage(new LiteralText("[SQUARED] Opening click GUI..."), false);
		MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));
	}
}