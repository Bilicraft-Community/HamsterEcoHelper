package cat.nyaa.heh.ui.component.impl;

import cat.nyaa.heh.item.ShopItem;
import cat.nyaa.heh.market.Market;
import cat.nyaa.heh.transaction.TransactionController;
import cat.nyaa.heh.ui.component.BaseComponent;
import cat.nyaa.heh.ui.component.BasePagedComponent;
import cat.nyaa.heh.ui.component.ShopComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MarketComponent extends ShopComponent {
    public MarketComponent(Inventory inventory) {
        super(inventory);
    }

    private List<ShopItem> loadItems() {
        List<ShopItem> marketItems;
        Market.getInstance().loadItem();
        if (ownerFilter == null){
            marketItems = Market.getInstance().getMarketItems();
        }else {
            marketItems = Market.getInstance().getMarketItems(ownerFilter);
        }
        return marketItems;
    }

    @Override
    public void loadData() {
        items = loadItems();
    }

    @Override
    public void loadData(List<ShopItem> data) {
        this.items = data;
    }

    @Override
    public Map<String, String> getInfo() {
        Map<String, String> info = super.getInfo();
        return info;
    }

    private UUID ownerFilter = null;

    public void setOwnerFilter(UUID whoClicked) {
        ownerFilter = whoClicked;
    }

    public void removeOwnerFilter(){
        ownerFilter = null;
    }

    public boolean isFiltered() {
        return ownerFilter != null;
    }
}
