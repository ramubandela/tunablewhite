package com.lcm.example.tunablewhite.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@Setter
@Getter
@ToString
public class DataProfile implements Serializable {
    public String state;
    public ArrayList<String> tags;
    public DataDefinition dataDefinition;
    public String dataProfileIdentity;
}
