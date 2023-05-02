package pro.freeserver.takenoh.handler;

import org.bukkit.Location;

public class BigBlockChunk {
    Location location;
    float size;
    public BigBlockChunk(Location location,float size){
        this.location = location;
        this.size = size;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public  Location  getBigBlockOrigin() {
        Location bigBlockOrigin = new Location(
                location.getWorld(),
                (location.getBlockX())+(location.getBlockX() % size),
                location.getBlockY()-(location.getBlockY() % size),
                location.getBlockZ()+(location.getBlockZ() % size)
        );
        return  bigBlockOrigin;
    }
}
