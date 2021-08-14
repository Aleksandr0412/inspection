package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;

/**
 * WithDataReportTransformer.
 *
 * @author Ilya_Sukhachev
 */
//конкретный декоратор
public class WithDataReportTransformer extends ReportServiceTransformerBase {

    public WithDataReportTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report transformData(DataRow[] data) {
        var report = dataTransformer.transformData(data);
        report.setData(data);
        return report;
    }
}
