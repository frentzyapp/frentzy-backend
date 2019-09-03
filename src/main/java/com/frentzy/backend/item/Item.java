package com.frentzy.backend.item;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String name;
    private String description;
    private float rate;
    private boolean availability;
    private int categoryid;
    private String imgurl;

    Item(){};

    Item(Long id, String name, String description, int inventoryid, float rate, boolean availability, int categoryid, String imgurl)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.availability = availability;
        this.categoryid = categoryid;
        this.imgurl = imgurl;
    }


}
