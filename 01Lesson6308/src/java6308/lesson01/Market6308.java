package java6308.lesson01;

import java.util.Arrays;

public class Market6308 {
    private String marketname;
    private Product6308 productlist[];

    public Market6308() {
    }


    public Market6308(String marketname, Product6308[] productlist) {
        this.marketname = marketname;
        this.productlist = productlist;
    }


    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public Product6308[] getProductlist() {
        return productlist;
    }

    public void setProductlist(Product6308[] productlist) {
        this.productlist = productlist;
    }

    //卖一个商品
    Product6308 sell(String uu) {
        for (int i = 0; i < productlist.length; i++) {
            if (productlist[i].getProductname().equals(uu)) {
                return productlist[i];
            }
        }
        return null;
    }

    //卖多件商品
    public String sell(Product6308[] er) {
        String nameList = "";
        for (int j = 0; j < er.length; j++) {
            for (int i = 0; i < productlist.length; i++) {
                if (productlist[i].equals(er[j])) nameList = nameList + er[j].getProductname() + ",";
            }
        }
        return nameList;
    }


    @Override
    public String toString() {
        return Arrays.toString(productlist);
    }
}
