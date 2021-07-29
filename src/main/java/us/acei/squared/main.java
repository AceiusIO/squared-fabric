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
	private static KeyBinding openSafetyGui_Key;

	@Override
	public void onInitialize() {
		System.out.println("Squared has initalised! :D");
		
		print.sqprint("Loading config, please wait...");

		print.sqprint("Binding Keys");

		print.sqprint("Binding GLFW.GLFW_KEY_RIGHT_SHIFT to key.squared.click_gui");
		openClickGui_Key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		    "key.squared.click_gui",
	    	InputUtil.Type.KEYSYM,
    		GLFW.GLFW_KEY_RIGHT_SHIFT,
    		"category.squared.controls"
		));

		print.sqprint("Registering @event key.squared.click_gui.wasPressed to MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openClickGui_Key.wasPressed()) {
				MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));
			}
		});

		print.sqprint("Binding GLFW. GLFW_KEY_GRAVE_ACCENT to key.squared.safety");
		openSafetyGui_Key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		    "key.squared.safety",
	    	InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_GRAVE_ACCENT,
    		"category.squared.controls"
		));

		print.sqprint("Registering @event key.squared.click_gui.wasPressed to MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openSafetyGui_Key.wasPressed()) {
				MinecraftClient.getInstance().setScreen(new sqgui(new sqsafety()));
			}
		});
	}
}