package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.math.BigDecimal;

/**
 * CostSumReportTransformer.
 *
 * @author Ilya_Sukhachev
 */
// конкретный декоратор
public class CostSumReportTransformer extends ReportServiceTransformerBase {

    public CostSumReportTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report transformData(DataRow[] data) {
        var report = dataTransformer.transformData(data);

        var value = new BigDecimal(0);
        for (var element : data) {
            var result = element.getCount().multiply(element.getCost());
            value = value.add(result);
        }
        report.getRows().add(new ReportRow("Суммарная стоимость", value));

        return report;
    }
}
