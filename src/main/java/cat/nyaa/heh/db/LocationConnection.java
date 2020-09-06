package cat.nyaa.heh.db;

import cat.nyaa.heh.db.model.LocationDbModel;
import cat.nyaa.heh.db.model.LocationType;
import cat.nyaa.heh.utils.UidUtils;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LocationConnection {
    private static LocationConnection INSTANCE;

    private static final String TABLE_NAME = "locations";
    private UidUtils uidManager = UidUtils.create(TABLE_NAME);

    private LocationConnection() {
    }

    public static LocationConnection getInstance() {
        if (INSTANCE == null) {
            synchronized (LocationConnection.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocationConnection();
                }
            }
        }
        return INSTANCE;
    }

    public Block getBlock(long uid){
        return DatabaseManager.getInstance().getBlock(uid);
    }

    public Entity getEntity(long uid){
        return DatabaseManager.getInstance().getEntity(uid);
    }

    public void updateChestLocation(Player player, LocationType type, Chest state) {
        LocationDbModel locationModel = DatabaseManager.getInstance().getLocationModel(player.getUniqueId(), type);
        if (locationModel == null){
            locationModel = newLocationModel(type, player.getUniqueId(), state.getLocation());
        }
        locationModel.setLocation(state.getLocation());
        locationModel.setLocationType(type);
        locationModel.setOwner(player.getUniqueId());
        DatabaseManager.getInstance().updateLocationModel(locationModel);
    }

    public void insertLocationModel(LocationDbModel locationDbModel){
        DatabaseManager.getInstance().insertLocation(locationDbModel);
    }

    public LocationDbModel newLocationModel(LocationType type, UUID owner, Location location) {
        LocationDbModel locationModel = new LocationDbModel();
        locationModel.setLocationType(type);
        locationModel.setOwner(owner);
        locationModel.setUid(uidManager.getNextUid());
        locationModel.setLocation(location);
        return locationModel;
    }

    public LocationDbModel getLottoChestForPlayer(Player player) {
        return DatabaseManager.getInstance().getLocationModel(player.getUniqueId(), LocationType.CHEST_LOTTO);
    }

    public LocationDbModel getReqLocationModel(UUID player) {
        return DatabaseManager.getInstance().getLocationModel(player, LocationType.CHEST_BUY);
    }

    public long getNextUid() {
        return uidManager.getNextUid();
    }
}