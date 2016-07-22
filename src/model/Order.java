/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author g13953ts
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Order {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
    private String clothes;



    public Order(String clothes) {
    	super();
        this.clothes = clothes;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id){
    	this.id=id;
    }
    

    public String getClothes() {
        return clothes;
    }
    public void setClothes(String clothes){
    	this.clothes=clothes;
    }

    
}
