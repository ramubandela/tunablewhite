package com.lcm.example.tunablewhite.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
@ToString
public class DataDefinition implements Serializable {

    private List<DataItem> dataItems;

    public List<DataItem> getDataItems() {
        return dataItems;
    }

    public void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataDefinition{");
        sb.append("dataItems=").append(dataItems);
        sb.append('}');
        return sb.toString();
    }
}
