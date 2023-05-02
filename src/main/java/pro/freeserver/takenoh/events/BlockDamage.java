package pro.freeserver.takenoh.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.joml.Vector3f;
import pro.freeserver.takenoh.consts.BigBlockData;
import pro.freeserver.takenoh.handler.BigBlockChunk;

import static pro.freeserver.takenoh.SizeChange.SizeChange.bigBlockData1;

public class BlockDamage implements Listener {
    public  static  float size = 2f;
    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        Player p = e.getPlayer();
        BlockData damagedBlock = e.getBlock().getBlockData();
        Location damagedLocate = e.getBlock().getLocation();
        Material material = e.getItemInHand().getType();
        Location blockChunkOrigin = new BigBlockChunk(damagedLocate,size).getBigBlockOrigin();

        if (material.equals(Material.AMETHYST_SHARD)) {
            if (damagedBlock.getMaterial().equals(Material.BARRIER) || damagedBlock.getMaterial().equals(Material.BEDROCK)) return;
            Entity entity = p.getWorld().spawnEntity(blockChunkOrigin, EntityType.BLOCK_DISPLAY);
            if (entity instanceof BlockDisplay) {
                BlockDisplay blockDisplay = ((BlockDisplay) entity);
                blockDisplay.setBlock(damagedBlock);
                Transformation trans = blockDisplay.getTransformation();
                blockDisplay.setTransformation(new Transformation(
                        new Vector3f((-size/2)-0.01f,0,(-size/2)-0.01f),
                        trans.getLeftRotation(),
                        new Vector3f(size+0.02f, size+0.02f, size+0.02f),
                        trans.getRightRotation()
                ));

                //SaveBlocks

                Entity  interact = p.getWorld().spawnEntity(blockChunkOrigin,EntityType.INTERACTION);
                BigBlockData bigBlockData = new BigBlockData(damagedLocate,damagedBlock,size,entity,interact);

                ((Interaction)interact).setInteractionWidth(size);
                ((Interaction)interact).setInteractionHeight(size);
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < size; j++){
                        for (int k = 0; k < size; k++){
                            Location setBlock = new Location(
                                    p.getWorld(),
                                    blockChunkOrigin.getBlockX()-i,
                                    blockChunkOrigin.getBlockY()+j,
                                    blockChunkOrigin.getBlockZ()-k
                                    );
                            if (!(i == 0 && j == 0 && k == 0)) p.getWorld().dropItem(setBlock, new ItemStack(setBlock.getBlock().getType()));
                            bigBlockData1.put(setBlock,bigBlockData);
                            setBlock.getBlock().setType(Material.BARRIER);
                        }
                    }
                }

            }
        }
    }
}