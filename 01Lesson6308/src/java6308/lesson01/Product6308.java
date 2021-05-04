package java6308.lesson01;

public class Product6308 extends Market6308 {
    private String productname;

    public Product6308() {
    }

    public Product6308(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Override
    public String toString() {
        return  productname;
    }

    @Override
    public boolean equals(Object obj) {
        Product6308 shopname1=(Product6308) obj;
        boolean b=this.productname.equals(shopname1.productname);
        return super.equals(obj);
    }
}
