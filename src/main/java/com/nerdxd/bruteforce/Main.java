package com.nerdxd.bruteforce;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("guess").setExecutor(new BruteForce(this));

    }

}
