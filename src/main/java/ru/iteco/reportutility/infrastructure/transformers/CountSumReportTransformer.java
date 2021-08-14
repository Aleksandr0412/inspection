package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.math.BigDecimal;

/**
 * CountSumReportTransformer.
 *
 * @author Ilya_Sukhachev
 */
//конкретный декоратор
public class CountSumReportTransformer extends ReportServiceTransformerBase {

    public CountSumReportTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report transformData(DataRow[] data) {
        var report = dataTransformer.transformData(data);

        var value = new BigDecimal(0);
        for (var element : data) {
            var result = element.getCount();
            value = value.add(result);
        }
        report.getRows().add(new ReportRow("Суммарное количество", value));

        return report;
    }
}
