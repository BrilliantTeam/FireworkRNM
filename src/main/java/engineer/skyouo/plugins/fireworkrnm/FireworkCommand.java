package engineer.skyouo.plugins.fireworkrnm;

import com.google.common.collect.Lists;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.world.World;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class FireworkCommand implements TabExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    int number = 10;
    if (args.length == 1)
      number = Integer.parseInt(args[0]);
    Player player = (Player)sender;
    SessionManager manager = WorldEdit.getInstance().getSessionManager();
    LocalSession localSession = manager.get(BukkitAdapter.adapt(player));
    World selectionWorld = localSession.getSelectionWorld();
    try {
      if (selectionWorld == null)
        throw new IncompleteRegionException();
      Region region = localSession.getSelection(selectionWorld);
      for (int i = 0; i < number; i++) {
        Vector3d v3d = getRandomPoint(region.getMinimumPoint(), region.getMaximumPoint());
        FireworkUtil.random(new Location(player.getWorld(), v3d.getX(), v3d.getY(), v3d.getZ()));
      }
    } catch (IncompleteRegionException ex) {
      player.sendMessage("§7您沒有框定範圍，無法放煙火！");
      return true;
    }
    return true;
  }
  
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
    return Lists.newArrayList();
  }
  
  private Vector3d getRandomPoint(BlockVector3 from, BlockVector3 to) {
    long x = ThreadLocalRandom.current().nextInt(from.getBlockX(), to.getBlockX() + 1);
    long y = ThreadLocalRandom.current().nextInt(from.getBlockY(), to.getBlockY() + 1);
    long z = ThreadLocalRandom.current().nextInt(from.getBlockZ(), to.getBlockZ() + 1);
    return new Vector3d(x, y, z);
  }
}
