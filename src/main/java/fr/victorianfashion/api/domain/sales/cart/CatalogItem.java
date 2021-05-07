package fr.victorianfashion.api.domain.sales.cart;

import java.util.UUID;

public class CatalogItem {
  private UUID skuId;
  private int maxAllowedPurchaseQty = 2;
  private String skuName;
  private String brand;
  private String delimiter = " ";

  public CatalogItem(UUID id, int maxAllowedPurchaseQty, String skuName, String brand) {
    this.skuId = id;
    this.maxAllowedPurchaseQty = maxAllowedPurchaseQty;
    setMaxAllowedPurchaseQty(maxAllowedPurchaseQty);
    this.skuName = skuName;
    this.brand = brand;
  }

  public int getMaxAllowedPurchaseQty() {
    return maxAllowedPurchaseQty;
  }

  private void setMaxAllowedPurchaseQty(int maxAllowedPurchaseQty) {
    // Les validations peuvent être effectuées dans ce setter. La valeur ne peut pas être <0.
    this.maxAllowedPurchaseQty = maxAllowedPurchaseQty;
  }

  public String cartItemDisplayName() {
    return skuName.concat(delimiter).concat(brand);
  }
}
