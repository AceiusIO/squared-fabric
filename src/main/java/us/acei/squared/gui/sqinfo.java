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

public class sqdebug extends LightweightGuiDescription {
    public sqdebug() {
        print.sqprint("Loading Meta Info");

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 150);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/paper.png"));
        root.add(icon, 0, 0, 1, 1);
        
        WLabel windowTitle = new WLabel(new TranslatableText("meta.squared.title"));
        root.add(windowTitle, 1, 0, 8, 1);

        WLabel sep = new WLabel(new LiteralText("========================="));
        root.add(sep, 0, 1, 8, 1);

        WLabel lang = new WLabel(new TranslatableText("meta.squared.lang"));
        root.add(lang, 0, 2, 8, 1);

        WLabel author = new WLabel(new TranslatableText("gui.squared.info.author"));
        root.add(autho, 0, 2, 8, 1);

        WButton back = new WButton(new LiteralText("<"));
        back.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu()));
        });
        root.add(back, 0, 7, 1, 1);

        print.sqprint("Validating Click GUI");
        root.validate(this);
        print.sqprint("Displaying Click GUI");

        System.out.println("Applying settings, one moment...");
    }
}