package com.github.platymemo.example.config;

import com.github.platymemo.example.ExampleMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = ExampleMod.MOD_ID)
public class ExampleConfig implements ConfigData {

    // Config Options go here

    @ConfigEntry.Gui.Excluded
    private transient static boolean registered = false;

    public static synchronized ExampleConfig getConfig() {
        if (!registered) {
            AutoConfig.register(ExampleConfig.class, GsonConfigSerializer::new);
            registered = true;
        }

        return AutoConfig.getConfigHolder(ExampleConfig.class).getConfig();
    }
}