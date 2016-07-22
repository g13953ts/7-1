package model;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Data {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;
     
    //商品名
    @Persistent
    private String title;
     
    @Persistent
    private String price;
 
    public Data(String id,String title,String price) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getPrice() {
        return price;
    }
 
    public void setprice(String price) {
        this.price = price;
    }
 
}