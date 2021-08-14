package ru.iteco.reportutility.models;

/**
 * ReportConfig.
 *
 * @author Ilya_Sukhachev
 */
//очень большое количество полей, нужно использовать строителя
public class ReportConfig {

    private boolean withData;

    private boolean withIndex;
    private boolean withTotalVolume;
    private boolean withTotalWeight;

    private boolean volumeSum;
    private boolean weightSum;
    private boolean costSum;
    private boolean countSum;

    public ReportConfig(boolean withData, boolean withIndex, boolean withTotalVolume, boolean withTotalWeight, boolean volumeSum,
                        boolean weightSum, boolean costSum, boolean countSum) {
        this.withData = withData;
        this.withIndex = withIndex;
        this.withTotalVolume = withTotalVolume;
        this.withTotalWeight = withTotalWeight;
        this.volumeSum = volumeSum;
        this.weightSum = weightSum;
        this.costSum = costSum;
        this.countSum = countSum;
    }

    public boolean isWithData() {
        return withData;
    }

    public void setWithData(boolean withData) {
        this.withData = withData;
    }

    public boolean isWithIndex() {
        return withIndex;
    }

    public void setWithIndex(boolean withIndex) {
        this.withIndex = withIndex;
    }

    public boolean isWithTotalVolume() {
        return withTotalVolume;
    }

    public void setWithTotalVolume(boolean withTotalVolume) {
        this.withTotalVolume = withTotalVolume;
    }

    public boolean isWithTotalWeight() {
        return withTotalWeight;
    }

    public void setWithTotalWeight(boolean withTotalWeight) {
        this.withTotalWeight = withTotalWeight;
    }

    public boolean isVolumeSum() {
        return volumeSum;
    }

    public void setVolumeSum(boolean volumeSum) {
        this.volumeSum = volumeSum;
    }

    public boolean isWeightSum() {
        return weightSum;
    }

    public void setWeightSum(boolean weightSum) {
        this.weightSum = weightSum;
    }

    public boolean isCostSum() {
        return costSum;
    }

    public void setCostSum(boolean costSum) {
        this.costSum = costSum;
    }

    public boolean isCountSum() {
        return countSum;
    }

    public void setCountSum(boolean countSum) {
        this.countSum = countSum;
    }
}
