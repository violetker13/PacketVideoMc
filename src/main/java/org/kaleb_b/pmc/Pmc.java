package org.kaleb_b.pmc;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FilenameFilter;

public final class Pmc extends JavaPlugin {

    @Override
    public void onEnable() {
        // Определяем путь к папке
        File videoDir = new File(getDataFolder(), "packetvideo/video");


        if (!videoDir.exists()) {

            boolean created = videoDir.mkdirs();
            if (created) {
                getLogger().info("Папка packetvideo/video была успешно создана.");
            } else {
                getLogger().warning("Не удалось создать папку packetvideo/video.");
            }
        } else {

            File[] mp4Files = videoDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".mp4");
                }
            });

            if (mp4Files != null && mp4Files.length > 0) {
                for (File file : mp4Files) {
                    getLogger().info("Найден видеофайл: " + file.getName());
                }
            } else {
                getLogger().info("В папке нет .mp4 файлов.");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
