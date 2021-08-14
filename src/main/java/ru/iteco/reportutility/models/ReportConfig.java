package ru.iteco.reportutility.models;

/**
 * ReportConfig.
 *
 * @author Ilya_Sukhachev
 */
//очень большое количество полей, нужно использовать строителя
    //добавлены хотелки, а именно желтый варнинг и если нет никаких параметров бросаем исключение, то есть обязательно хоть один параметр
public class ReportConfig {

    private final boolean withData;

    private final boolean withIndex;
    private final boolean withTotalVolume;
    private final boolean withTotalWeight;

    private final boolean volumeSum;
    private final boolean weightSum;
    private final boolean costSum;
    private final boolean countSum;

    public ReportConfig(ReportConfigBuilder builder) {
        this.withData = builder.withData;
        this.withIndex = builder.withIndex;
        this.withTotalVolume = builder.withTotalVolume;
        this.withTotalWeight = builder.withTotalWeight;
        this.volumeSum = builder.volumeSum;
        this.weightSum = builder.weightSum;
        this.costSum = builder.costSum;
        this.countSum = builder.countSum;
    }

    public static ReportConfigBuilder builder() {
        return new ReportConfigBuilder();
    }

    public boolean isWithData() {
        return withData;
    }

    public boolean isWithIndex() {
        return withIndex;
    }

    public boolean isWithTotalVolume() {
        return withTotalVolume;
    }

    public boolean isWithTotalWeight() {
        return withTotalWeight;
    }

    public boolean isVolumeSum() {
        return volumeSum;
    }

    public boolean isWeightSum() {
        return weightSum;
    }

    public boolean isCostSum() {
        return costSum;
    }

    public boolean isCountSum() {
        return countSum;
    }

    public static class ReportConfigBuilder {
        private boolean isNotEmptyFields;
        private boolean withData;

        private boolean withIndex;
        private boolean withTotalVolume;
        private boolean withTotalWeight;

        private boolean volumeSum;
        private boolean weightSum;
        private boolean costSum;
        private boolean countSum;

        public ReportConfigBuilder setIsWithData(boolean isWithData) {
            this.withData = isWithData;
            isNotEmpty(isWithData);
            return this;
        }

        public ReportConfigBuilder setWithIndex(boolean withIndex) {
            this.withIndex = withIndex;
            isNotEmpty(withIndex);
            return this;
        }

        public ReportConfigBuilder setWithTotalVolume(boolean withTotalVolume) {
            this.withTotalVolume = withTotalVolume;
            isNotEmpty(withTotalVolume);
            return this;
        }

        public ReportConfigBuilder setWithTotalWeight(boolean withTotalWeight) {
            this.withTotalWeight = withTotalWeight;
            isNotEmpty(withTotalWeight);
            return this;
        }

        public ReportConfigBuilder setVolumeSum(boolean volumeSum) {
            this.volumeSum = volumeSum;
            isNotEmpty(volumeSum);
            return this;
        }

        public ReportConfigBuilder setWeightSum(boolean weightSum) {
            this.weightSum = weightSum;
            isNotEmpty(weightSum);
            return this;
        }

        public ReportConfigBuilder setCostSum(boolean costSum) {
            this.costSum = costSum;
            isNotEmpty(costSum);
            return this;
        }

        public ReportConfigBuilder setCountSum(boolean countSum) {
            this.countSum = countSum;
            isNotEmpty(countSum);
            return this;
        }

        public ReportConfig build() {
            if (!isNotEmptyFields) {
                throw new RuntimeException("нет полей");
            }
            if (!this.withData) {
                System.out.println("\n Yellow warning!\n");
            }
            return new ReportConfig(this);
        }
        private void isNotEmpty(boolean value){
            if(value) isNotEmptyFields = true;
        }
    }
}

