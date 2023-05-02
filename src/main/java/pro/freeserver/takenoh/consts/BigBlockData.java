package pro.freeserver.takenoh.consts;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;

public class BigBlockData {
    Location location;
    BlockData blockData;
    float size;

    Entity entity;

    Entity interact;

    public BigBlockData(Location location, BlockData blockData, float size, Entity entity, Entity interact) {
        this.location = location;
        this.blockData = blockData;
        this.size = size;
        this.entity = entity;
        this.interact = interact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BlockData getBlockData() {
        return blockData;
    }

    public void setBlockData(BlockData blockData) {
        this.blockData = blockData;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getInteract() {
        return interact;
    }

    public void setInteract(Entity interact) {
        this.interact = interact;
    }
}

