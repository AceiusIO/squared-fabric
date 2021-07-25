package us.acei.squared;
import us.acei.squared.*;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;

public class sqgui extends CottonClientScreen {
    public sqgui(GuiDescription description) {
        super(description);
    }
}

/* MinecraftClient.getInstance().setScreen(new sqgui(new sqmenu())); 
public class sqmenu extends LightweightGuiDescription {
    public sqmenu() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        root.setInsets(Insets.ROOT_PANEL);
        
        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone_repeater.png"));
        root.add(icon, 0, 2, 1, 1);
        
        WButton button = new WButton(new TranslatableText("gui.squared.examplebutton"));
        root.add(button, 0, 3, 4, 1);
        
        WLabel label = new WLabel(new LiteralText("Test"), 0xFFFFFF);
        root.add(label, 0, 4, 2, 1);

        root.validate(this);
    }
}*/
