package pl.arkadiuszsas.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
public class GenerateInvoicesFromCsvUseCase {

    public ByteArrayInputStream generateInvoicesFromCsv(MultipartFile customersForInvoice) {
        return null;
    }
}
