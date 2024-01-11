package com.lcm.example.tunablewhite.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@lombok.Data
@Setter
@Getter
@ToString
public class Data  implements Serializable {
    public Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Data{");
        sb.append("schedule=").append(schedule);
        sb.append('}');
        return sb.toString();
    }
}
