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

public class sqsafety extends LightweightGuiDescription {
    //(type, startx, starty, endx, endy)
    public sqsafety() {
        print.sqprint("Preparing to define a GUI");
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 150);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/barrier.png"));
        root.add(icon, 0, 0, 1, 1);
        
        WLabel label = new WLabel(new LiteralText("Player Safety"));
        root.add(label, 1, 0, 8, 1);

        WLabel comingsoon = new WLabel(new LiteralText("IMPORTANT: If you are being mistreated"));
        root.add(comingsoon, 0, 1, 8, 1);

        WLabel comingsoon2 = new WLabel(new LiteralText("online, talk to a parent or guardian."));
        //Coming soon, use p to open the vannilla social interactions menu.
        root.add(comingsoon2, 0, 2, 8, 1);

        WLabel comingsoon3 = new WLabel(new LiteralText("Use P to open the vanilla social menu."));
        root.add(comingsoon3, 0, 3, 8, 1);

        WButton comingsoonbtn = new WButton(new LiteralText("Coming Soon!"));
        comingsoonbtn.setOnClick(() -> {
            print.sqprint("Use P to open the vanilla social menu online.");
            System.out.println("IMPORTANT: If you are being mistreated online, talk to a parent or guardian.");
        });
        root.add(comingsoonbtn, 0, 5, 8, 1);

        print.sqprint("Validating Safety GUI");
        root.validate(this);
        print.sqprint("Displaying Safety GUI");
        print.sqdebug("Coming soon");
    }
}
