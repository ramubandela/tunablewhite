package com.lcm.example.tunablewhite.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@lombok.Data
@Setter
@Getter
@ToString
public class DataItem implements Serializable {
    public Data data;
    public String schemaIdentity;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSchemaIdentity() {
        return schemaIdentity;
    }

    public void setSchemaIdentity(String schemaIdentity) {
        this.schemaIdentity = schemaIdentity;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataItem{");
        sb.append("data=").append(data);
        sb.append(", schemaIdentity='").append(schemaIdentity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
