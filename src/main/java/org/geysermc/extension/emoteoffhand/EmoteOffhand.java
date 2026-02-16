package org.geysermc.extension.emoteoffhand;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.ClientEmoteEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;

public class EmoteOffhand implements Extension {
    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent ignored) {
        this.logger().info("Loaded EmoteOffhand!");
    }

    @Subscribe
    public void onEmote(ClientEmoteEvent event) {
        event.connection().requestOffhandSwap();
    }
}
