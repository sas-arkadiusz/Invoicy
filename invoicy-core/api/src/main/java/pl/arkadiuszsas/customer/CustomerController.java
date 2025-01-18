package pl.arkadiuszsas.customer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final GenerateInvoicesFromCsvUseCase generateInvoicesFromCsvUseCase;

    public CustomerController(GenerateInvoicesFromCsvUseCase generateInvoicesFromCsvUseCase) {
        this.generateInvoicesFromCsvUseCase = generateInvoicesFromCsvUseCase;
    }

    @PostMapping("/generate-invoices-from-csv")
    public ResponseEntity<byte[]> generateInvoicesFromCsv(@RequestParam("customersForInvoice") MultipartFile customersForInvoice) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(generateInvoicesFromCsvUseCase.generateInvoicesFromCsv(customersForInvoice).readAllBytes());
    }
}
