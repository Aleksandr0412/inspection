package ru.iteco.reportutility.services;

import ru.iteco.reportutility.infrastructure.DataTransformerCreator;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    //паттерн шаблонный метод, createReport() - и есть шаблонный метод, getDataRows(String text) - реализуется по
    // разному в наследниках FileFormatReportService, легко с стратегией перепутать
    @Override
    public Report createReport() {
        var config = parseConfig();
        var dataTransformer = DataTransformerCreator.createTransformer(config);

        var fileName = args[0];
        String text = null;
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {

            e.printStackTrace();
        }

        var data = getDataRows(text);
        return dataTransformer.transformData(data);
    }

    protected abstract DataRow[] getDataRows(String text);

    // по идее можно команду использовать, я реализовал строителя
    private ReportConfig parseConfig() {
        var argsSet = new HashSet<>(List.of(args));

        return ReportConfig.builder()
                .setIsWithData(argsSet.contains("-withData"))
                .setCostSum(argsSet.contains("-costSum"))
                .setWithIndex(argsSet.contains("-withIndex"))
                .setWithTotalVolume(argsSet.contains("-withTotalVolume"))
                .setWithTotalWeight(argsSet.contains("-withTotalWeight"))
                .setCountSum(argsSet.contains("-countSum"))
                .setWeightSum(argsSet.contains("-weightSum"))
                .setVolumeSum(argsSet.contains("-volumeSum"))
                .build();
    }

}
