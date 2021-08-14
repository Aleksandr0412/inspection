package ru.iteco.reportutility.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.iteco.reportutility.models.DataRow;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CsvReportService.
 *
 * @author Ilya_Sukhachev
 */
public class CsvReportService extends ReportServiceBase {

    public CsvReportService(String[] args) {
        super(args);
    }

    @Override
    protected DataRow[] getDataRows(String text) {
        var dataRows = new ArrayList<>();
        text = text.substring(text.indexOf("\n") + 1);
        var in = new StringReader(text);
        CSVParser parser;
        List<CSVRecord> list = null;
        try {
            parser = new CSVParser(in, CSVFormat.EXCEL);
            list = parser.getRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CSVRecord csvRecord : list) {
            var items = csvRecord.get(0).split(";");
            dataRows.add( //todo использовать билдер
                    new DataRow(new BigDecimal(items[3]), new BigDecimal(items[4]), items[0],
                    new BigDecimal(items[1]), new BigDecimal(items[2])));
        }

        var result = new DataRow[dataRows.size()];
        result = dataRows.toArray(result);
        return result;
    }
}
