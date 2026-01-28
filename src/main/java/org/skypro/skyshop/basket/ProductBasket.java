package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] store;

    public ProductBasket() {
        this.store = new  Product[5];
    }

    public void addProduct(Product product){
        if(product == null) return;

        for (int i = 0; i < this.store.length; i++) {
            if(this.store[i] == null){
                this.store[i] = product;
                return;
            }
        }

        System.out.println("В корзине недостаточно места для добавления нового продукта");
    }

    public int getBasketAmountTotal(){
        return 0;
    }

    public void printBasketItems(){

    }

    public boolean isProductExist(String title){
        return false;
    }

    public void cleanBasket(){

    }

}
