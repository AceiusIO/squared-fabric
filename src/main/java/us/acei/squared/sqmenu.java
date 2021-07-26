package us.acei.squared;
import us.acei.squared.*;

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
    public Boolean setting_sendChatMessages = false;
    public Boolean setting_showFPSCounter = false;
    
    //(type, startx, starty, endx, endy)
    public sqmenu() {
        print.sqprint("Preparing to define a GUI");
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 150);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/repeater.png"));
        root.add(icon, 0, 0, 1, 1);
        
        WLabel label = new WLabel(new LiteralText("Settings"));
        root.add(label, 1, 0, 8, 1);

        WToggleButton sendChatMessages = new WToggleButton(new LiteralText("Send Chat Messages"));
        sendChatMessages.setToggle(setting_sendChatMessages);
        root.add(sendChatMessages, 0, 2, 8, 1);

        sendChatMessages.setOnToggle(on -> {
            print.sqprint("showFPSCounter set to " + on);
            setting_sendChatMessages = on;
        });

        WToggleButton showFPSCounter = new WToggleButton(new LiteralText("Show FPS Counter"));
        sendChatMessages.setToggle(setting_showFPSCounter);
        root.add(showFPSCounter, 0, 3, 8, 1);

        showFPSCounter.setOnToggle(on -> {
            print.sqprint("showFPSCounter set to " + on);
            setting_showFPSCounter = on;
        });

        root.validate(this);
        print.sqprint("Validating Click GUI");
        print.sqprint("Displaying Click GUI ");
    }
}
