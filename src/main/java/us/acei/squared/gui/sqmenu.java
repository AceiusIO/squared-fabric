/*
 * Copyright (c) 2021 AceiusIO and contributors.
 *
 * This source code is subject to the terms of the GNU Lesser General Public
 * License, version 3. If a copy of the LGPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/lgpl-3.0.txt
 */

package us.acei.squared;
import us.acei.squared.*;
import us.acei.squared.SimpleConfig;

import java.util.function.Consumer;

import net.minecraft.util.Identifier;
import net.minecraft.client.*;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.*;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.*;

import net.fabricmc.api.ModInitializer;

public class sqmenu extends LightweightGuiDescription {
    // I normally don't use comments, but this source file is one of the longest in the source code. :|

    SimpleConfig CONFIG = SimpleConfig.of("squared-settings").provider(this::provider).request();

    private String provider(String filename) {
		return "# Squared Settings \n sendChatMessages=false \n showFPSCounter=false";
	}

    public Boolean setting_sendChatMessages = CONFIG.getOrDefault("sendChatMessages", false);
    public Boolean setting_showFPSCounter = CONFIG.getOrDefault("showFPSCounter", false);
    
    public sqmenu() {

        // Main Window Area

        print.sqprint("Loading Config...");

        print.sqprint("Preparing to define a GUI");
        print.sqdebug("setting_sendChatMessages " + setting_sendChatMessages);
        print.sqdebug("setting_showFPSCounter " + setting_showFPSCounter);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 150);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/repeater.png"));
        root.add(icon, 0, 0, 1, 1);
        
        WLabel windowTitle = new WLabel(new TranslatableText("gui.squared.settings"));
        root.add(windowTitle, 1, 0, 8, 1);

        WLabel windowSubtitle = new WLabel(new TranslatableText("gui.squared.readonly", "squared-settings.properties"));
        root.add(windowSubtitle, 1, 1, 8, 1);

        WToggleButton sendChatMessages = new WToggleButton(new TranslatableText("gui.squared.sendchatmsgs"));
        sendChatMessages.setToggle(setting_sendChatMessages);
        root.add(sendChatMessages, 0, 2, 8, 1);

        sendChatMessages.setOnToggle(on -> {
            sendChatMessages.setToggle(setting_sendChatMessages);
            print.sqprint("Sorry, " + new TranslatableText("gui.squared.readonly", "squared-settings.properties"));
        });

        WToggleButton showFPSCounter = new WToggleButton(new TranslatableText("gui.squared.showfpscounter"));
        sendChatMessages.setToggle(setting_showFPSCounter);
        root.add(showFPSCounter, 0, 3, 8, 1);

        showFPSCounter.setOnToggle(on -> {
            showFPSCounter.setToggle(setting_showFPSCounter);
            print.sqprint("Sorry, " + new TranslatableText("gui.squared.readonly", "squared-settings.properties"));
        });

        // Bottom buttons

        WButton debug = new WButton(new LiteralText("?"));
        debug.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new sqgui(new sqdebug()));
        });
        root.add(debug, 0, 7, 1, 1);

        WButton safety = new WButton(new LiteralText("!"));
        safety.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new sqgui(new sqsafety()));
        });
        root.add(safety, 1, 7, 1, 1);

        print.sqprint("Validating Click GUI");
        root.validate(this);
        print.sqprint("Displaying Click GUI");

        System.out.println("Applying settings, one moment...");

        /*
         * TODO: Find the subclass for showing the vanilla fps counter
         * client.settings.showFPSCounter();
         */
    }
}