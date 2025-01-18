package pl.arkadiuszsas.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
public class GenerateInvoicesFromCsvUseCase {

    private final CustomersCsvReader customersCsvReader;

    public GenerateInvoicesFromCsvUseCase(CustomersCsvReader customersCsvReader) {
        this.customersCsvReader = customersCsvReader;
    }

    public ByteArrayInputStream generateInvoicesFromCsv(MultipartFile customersForInvoice) {
        return customersCsvReader.readCustomersDataFromCsv(customersForInvoice);
    }
}
