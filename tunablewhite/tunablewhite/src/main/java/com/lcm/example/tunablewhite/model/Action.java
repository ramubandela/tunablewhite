package com.lcm.example.tunablewhite.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Setter
@Getter
@ToString
public class Action  implements Serializable {

    public String type;
    public Payload payload;


}
