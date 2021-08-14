package ru.iteco.reportutility.models;

import java.math.BigDecimal;

/**
 * DataRow.
 *
 * @author Ilya_Sukhachev
 */
//todo использовать билдер
public class DataRow {

    private BigDecimal cost;
    private BigDecimal count;
    private String name;
    private BigDecimal volume;
    private BigDecimal weight;

    public DataRow(BigDecimal cost, BigDecimal count, String name, BigDecimal volume, BigDecimal weight) {
        this.cost = cost;
        this.count = count;
        this.name = name;
        this.volume = volume;
        this.weight = weight;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
