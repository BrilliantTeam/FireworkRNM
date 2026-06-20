package engineer.skyouo.plugins.fireworkrnm;

import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkUtil {
    public static void random(Location loc) {
        loc.getWorld().spawn(loc, Firework.class, firework -> {
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            FireworkEffect effect = FireworkEffect.builder().flicker(ThreadLocalRandom.current().nextBoolean()).withColor(getColor(ThreadLocalRandom.current().nextInt(17) + 1)).withFade(getColor(ThreadLocalRandom.current().nextInt(17) + 1)).with(FireworkEffect.Type.values()[ThreadLocalRandom.current().nextInt((FireworkEffect.Type.values()).length)]).trail(ThreadLocalRandom.current().nextBoolean()).build();
            fireworkMeta.addEffect(effect);
            fireworkMeta.setPower(ThreadLocalRandom.current().nextInt(2) + 1);
            firework.setFireworkMeta(fireworkMeta);
        });
    }
    
    private static Color getColor(int i) {
        switch (i) {
        case 1:
            return Color.AQUA;
        case 2:
            return Color.BLACK;
        case 3:
            return Color.BLUE;
        case 4:
            return Color.FUCHSIA;
        case 5:
            return Color.GRAY;
        case 6:
            return Color.GREEN;
        case 7:
            return Color.LIME;
        case 8:
            return Color.MAROON;
        case 9:
            return Color.NAVY;
        case 10:
            return Color.OLIVE;
        case 11:
            return Color.ORANGE;
        case 12:
            return Color.PURPLE;
        case 13:
            return Color.RED;
        case 14:
            return Color.SILVER;
        case 15:
            return Color.TEAL;
        case 16:
            return Color.WHITE;
        case 17:
            return Color.YELLOW;
        } 
        return null;
    }
}
