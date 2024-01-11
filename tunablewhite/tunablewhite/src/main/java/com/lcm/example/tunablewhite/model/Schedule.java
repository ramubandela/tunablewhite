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
public class Schedule implements Serializable {
    public int id;
    public Action action;
    public Recurrence recurrence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Schedule{");
        sb.append("id=").append(id);
        sb.append(", action=").append(action);
        sb.append(", recurrence=").append(recurrence);
        sb.append('}');
        return sb.toString();
    }
}
