package pro.freeserver.takenoh.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import pro.freeserver.takenoh.SizeChange.SizeChange;
import pro.freeserver.takenoh.handler.BigBlockChunk;

import static pro.freeserver.takenoh.SizeChange.SizeChange.bigBlockData1;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Material material = e.getItem().getType();
        Location interactedBlock = e.getClickedBlock().getLocation();
        Player p = e.getPlayer();
        //remove
        if (material.equals(Material.ECHO_SHARD)) {
            if (e.getClickedBlock().getBlockData().getMaterial().equals(Material.BARRIER)) {
                if (SizeChange.bigBlockData1.get(interactedBlock) != null){
                    Location blockChunkOrigin = new BigBlockChunk(interactedBlock,  BlockDamage.size).getBigBlockOrigin();
                    bigBlockData1.get(blockChunkOrigin).getEntity().remove();
                    bigBlockData1.get(blockChunkOrigin).getInteract().remove();
                    for (int i = 0; i < BlockDamage.size; i++){
                        for (int j = 0; j < BlockDamage.size; j++){
                            for (int k = 0; k < BlockDamage.size; k++){
                                Location setBlock = new Location(
                                        p.getWorld(),
                                        blockChunkOrigin.getBlockX()-i,
                                        blockChunkOrigin.getBlockY()+j,
                                        blockChunkOrigin.getBlockZ()-k
                                );
                                setBlock.getBlock().setType(Material.AIR);
                            }
                        }
                    }
                    blockChunkOrigin.getBlock().setType(bigBlockData1.get(blockChunkOrigin).getBlockData().getMaterial());
                }
            }
        }
    }
}

