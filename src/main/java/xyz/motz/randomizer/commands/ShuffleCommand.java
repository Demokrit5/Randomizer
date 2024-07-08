package xyz.motz.randomizer.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.motz.randomizer.main.Randomizer;

import java.util.Random;

public class ShuffleCommand implements CommandExecutor {

    /*
        TODO
        check version and only shuffle available items
        -> avoid disabled items
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
            TODO
            check if individualRandomizer is set
            if not then old code
            if yes than new code -> remaining als key-value pairs mit uuid für spieler & List<Material> wie remaining
         */

        Randomizer.getPlugin().remaining.clear();

        //TODO only fill with materials from this version
        for (Material mat : Material.values()) {
            if (mat.isItem()) {
                Randomizer.getPlugin().remaining.add(mat);
            }
        }

        for (Material mat : Material.values()) {
            if (!Randomizer.getPlugin().remaining.isEmpty()) {
                if (mat.isBlock()) {
                    Random r = new Random();
                    int rand;
                    if (Randomizer.getPlugin().remaining.size() != 1) {
                        rand = r.nextInt(Randomizer.getPlugin().remaining.size() - 1);
                    } else {
                        rand = 0;
                    }
                    //TODO partners. + uuid of player + mat
                    Randomizer.getPlugin().getConfig().set("partners." + mat, Randomizer.getPlugin().remaining.get(rand).toString());
                    Randomizer.getPlugin().remaining.remove(rand);
                }

            }

        }
        Randomizer.getPlugin().saveConfig();

        sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                + "The Random Pairs were successfully regenerated!");
        return true;
    }
}
