package ru.iteco.reportutility.models;

import java.math.BigDecimal;

/**
 * DataRow.
 *
 * @author Ilya_Sukhachev
 */
// использован билдер
public class DataRow {

    private BigDecimal cost;
    private BigDecimal count;
    private String name;
    private BigDecimal volume;
    private BigDecimal weight;

    public DataRow(Builder builder) {
        this.cost = builder.cost;
        this.count = builder.count;
        this.name = builder.name;
        this.volume = builder.volume;
        this.weight = builder.weight;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BigDecimal cost;
        private BigDecimal count;
        private String name;
        private BigDecimal volume;
        private BigDecimal weight;

        public Builder setCost( BigDecimal cost ) {
            this.cost = cost;
            return this;
        }

        public Builder setCount( BigDecimal count ) {
            this.count = count;
            return this;
        }

        public Builder setName( String name ) {
            this.name = name;
            return this;
        }

        public Builder setVolume( BigDecimal volume ) {
            this.volume = volume;
            return this;
        }

        public Builder setWeight( BigDecimal weight ) {
            this.weight = weight;
            return this;
        }

        public DataRow build(){
            return new DataRow(this);
        }
    }

}
