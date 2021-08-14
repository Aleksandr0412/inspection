package ru.iteco.reportutility.services;

import ru.iteco.reportutility.infrastructure.DataTransformerCreator;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * ReportServiceBase.
 *
 * @author Ilya_Sukhachev
 */
public abstract class ReportServiceBase implements ReportService {

    private final String[] args;

    protected ReportServiceBase(String[] args) {
        this.args = args;
    }

    //todo паттерн шаблонный метод, createReport() - и есть шаблонный метод, getDataRows(String text) - реализуется по
    // разному в наследниках FileFormatReportService
    @Override
    public Report createReport() {
        var config = parseConfig();
        var dataTransformer = DataTransformerCreator.createTransformer(config);

        var fileName = args[0];
        String text = null;
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e);
        }

        var data = getDataRows(text);
        return dataTransformer.transformData(data);
    }

    protected abstract DataRow[] getDataRows(String text);

    // по идее можно команду использовать
    private ReportConfig parseConfig() {
        return new ReportConfig(Arrays.asList(args).contains("-withData"), Arrays.asList(args).contains("-withIndex"),
                Arrays.asList(args).contains("-withTotalVolume"), Arrays.asList(args).contains("-withTotalWeight"),
                Arrays.asList(args).contains("-volumeSum"), Arrays.asList(args).contains("-weightSum"),
                Arrays.asList(args).contains("-costSum"), Arrays.asList(args).contains("-countSum"));
    }

}
