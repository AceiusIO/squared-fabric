/*
 * Copyright (c) 2021 AceiusIO and contributors.
 *
 * This source code is subject to the terms of the GNU Lesser General Public
 * License, version 3. If a copy of the LGPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/lgpl-3.0.txt
 */

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
        
        WLabel label = new WLabel(new TranslatableText("gui.squared.safety"));
        root.add(label, 1, 0, 8, 1);

        WLabel comingsoon = new WLabel(new TranslatableText("gui.squared.safety.comingsoon"));
        root.add(comingsoon, 0, 1, 8, 1);

        WLabel comingsoon2 = new WLabel(new TranslatableText("gui.squared.safety.comingsoon2"));
        root.add(comingsoon2, 0, 2, 8, 1);

        WLabel comingsoon3 = new WLabel(new TranslatableText("gui.squared.safety.comingsoon3"));
        root.add(comingsoon3, 0, 3, 8, 1);

        WButton comingsoonbtn = new WButton(new LiteralText("Coming Soon!"));
        comingsoonbtn.setOnClick(() -> {
            print.sqprint("Use P to open the vanilla social menu online.");
            System.out.println("IMPORTANT: If you are being mistreated online, talk to a parent or guardian.");
        });
        root.add(comingsoonbtn, 1, 7, 8, 1);

        WButton back = new WButton(new LiteralText("<"));
        back.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));
        });
        root.add(back, 0, 7, 1, 1);

        print.sqprint("Validating Safety GUI");
        root.validate(this);
        print.sqprint("Displaying Safety GUI");
        print.sqdebug("Coming soon");
    }
}
