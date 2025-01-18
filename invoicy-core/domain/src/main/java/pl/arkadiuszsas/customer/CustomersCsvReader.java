package pl.arkadiuszsas.customer;

import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class CustomersCsvReader {

    public ByteArrayInputStream readCustomersDataFromCsv(MultipartFile customersForInvoice) {
        try (InputStreamReader reader = new InputStreamReader(customersForInvoice.getInputStream(), StandardCharsets.UTF_8);
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), CSVFormat.DEFAULT.builder().setHeader("NUMER", "IMIE-NAZWISKO").get());
             CSVParser csvParser = CSVParser.builder()
                     .setReader(reader)
                     .setFormat(CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).get())
                     .get()) {

            for (CSVRecord record : csvParser) {
                String numer = record.get("NUMER");
                String imieNazwisko = record.get("IMIE-NAZWISKO");

                String zmodyfikowaneImieNazwisko = "Pan/Pani " + imieNazwisko;

                csvPrinter.printRecord(numer, zmodyfikowaneImieNazwisko);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas przetwarzania pliku CSV", e);
        }
    }
}
