package cat.nyaa.heh.transaction;

import cat.nyaa.heh.item.ShopItem;
import cat.nyaa.heh.item.ShopItemManager;
import cat.nyaa.nyaacore.orm.annotations.Column;
import cat.nyaa.nyaacore.orm.annotations.Table;

@Table("transaction")
public class Transaction {
    @Column(name = "uid", primary = true)
    long uid;
    @Column(name = "shop_item")
    long shopItem;
    @Column(name = "amount")
    int amount;
    @Column(name = "price")
    double price;
    @Column(name = "buyer")
    String buyer;
    @Column(name = "seller")
    String seller;
    @Column(name = "tax_id")
    long taxId;
    @Column(name = "time")
    long time;

    public Transaction() {
    }

    public Transaction(long uid, long shopItem, int amount, double price, String buyer, String seller, long taxId, long time) {
        this.uid = uid;
        this.shopItem = shopItem;
        this.amount = amount;
        this.price = price;
        this.buyer = buyer;
        this.seller = seller;
        this.taxId = taxId;
        this.time = time;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public ShopItem getShopItem() {
        return ShopItemManager.getInstance().getShopItem(shopItem);
    }

    public void setShopItem(long shopItem) {
        this.shopItem = shopItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
