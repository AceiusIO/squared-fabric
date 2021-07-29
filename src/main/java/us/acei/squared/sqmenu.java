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
    //SimpleConfig CONFIG = SimpleConfig.of( "config" ).provider( this::provider ).request();
    SimpleConfig CONFIG = SimpleConfig.of("squared-settings").provider(this::provider).request();

    private String provider(String filename) {
		return "# Squared Settings \n sendChatMessages=false \n showFPSCounter=false";
	}

    public Boolean setting_sendChatMessages = CONFIG.getOrDefault("sendChatMessages", false);
    public Boolean setting_showFPSCounter = CONFIG.getOrDefault("showFPSCounter", false);
    
    //(type, startx, starty, endx, endy)
    public sqmenu() {
        print.sqprint("Preparing to define a GUI");
        print.sqdebug("setting_sendChatMessages "+setting_sendChatMessages);
        print.sqdebug("setting_showFPSCounter "+setting_showFPSCounter);
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 150);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/repeater.png"));
        root.add(icon, 0, 0, 1, 1);
        
        WLabel windowTitle = new WLabel(new LiteralText("Settings"));
        root.add(windowTitle, 1, 0, 8, 1);

        WLabel windowSubtitle = new WLabel(new LiteralText("Read-Only (squared-settings.properties)"));
        root.add(windowSubtitle, 1, 1, 8, 1);

        WToggleButton sendChatMessages = new WToggleButton(new LiteralText("Send Chat Messages"));
        sendChatMessages.setToggle(setting_sendChatMessages);
        root.add(sendChatMessages, 0, 2, 8, 1);

        sendChatMessages.setOnToggle(on -> {
            sendChatMessages.setToggle(setting_showFPSCounter);
            print.sqprint("Read-Only for now, Sorry :(");
        });

        WToggleButton showFPSCounter = new WToggleButton(new LiteralText("Show FPS Counter"));
        sendChatMessages.setToggle(setting_showFPSCounter);
        root.add(showFPSCounter, 0, 3, 8, 1);

        showFPSCounter.setOnToggle(on -> {
            sendChatMessages.setToggle(setting_showFPSCounter);
            print.sqprint("Read-Only for now, Sorry :(");
        });

        print.sqprint("Validating Click GUI");
        root.validate(this);
        print.sqprint("Displaying Click GUI");

        /* print.sqdebug("Current FPS is " + ((FPSMixin) client).getCurrentFPS()); */
    }
}