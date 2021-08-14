package ru.iteco.reportutility.infrastructure;

import ru.iteco.reportutility.infrastructure.transformers.CostSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.CountSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.VolumeSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.WeightSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.WithDataReportTransformer;
import ru.iteco.reportutility.models.ReportConfig;

/**
 * DataTransformerCreator.
 *
 * @author Ilya_Sukhachev
 */
//паттерн декоратор, но много ифов, возможно стоит переделать под цепочку обязанностей и на месте проферять флаги
public class DataTransformerCreator {

    public static DataTransformer createTransformer(ReportConfig config) {
        DataTransformer service = new ConfigDataTransformer(config);

        if (config.isWithData()) {
            service = new WithDataReportTransformer(service);
        }

        if (config.isVolumeSum()) {
            service = new VolumeSumReportTransformer(service);
        }

        if (config.isWeightSum()) {
            service = new WeightSumReportTransformer(service);
        }

        if (config.isCostSum()) {
            service = new CostSumReportTransformer(service);
        }

        if (config.isCountSum()) {
            service = new CountSumReportTransformer(service);
        }

        return service;
    }

}
