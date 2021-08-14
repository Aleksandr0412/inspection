package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.math.BigDecimal;

/**
 * VolumeSumReportTransformer.
 *
 * @author Ilya_Sukhachev
 */
//конкретный декоратор
public class VolumeSumReportTransformer extends ReportServiceTransformerBase {

    public VolumeSumReportTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report transformData(DataRow[] data) {
        var report = dataTransformer.transformData(data);

        var value = new BigDecimal(0);
        for (var element : data) {
            var result = element.getCount().multiply(element.getVolume());
            value = value.add(result);
        }

        report.getRows().add(new ReportRow("Суммарный объём", value));

        return report;
    }
}
