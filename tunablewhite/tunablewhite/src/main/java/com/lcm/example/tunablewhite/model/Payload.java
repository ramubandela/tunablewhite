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
public class Payload implements Serializable {
    public int dim_level;
    public int lights_ct;
    public int transition_time;
}
