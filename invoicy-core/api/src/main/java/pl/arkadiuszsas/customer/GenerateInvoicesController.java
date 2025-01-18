package pl.arkadiuszsas.customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Customer Invoices", description = "Operations related to generating invoices for customers")
public class GenerateInvoicesController {

    private final GenerateInvoicesFromCsvUseCase generateInvoicesFromCsvUseCase;

    public GenerateInvoicesController(GenerateInvoicesFromCsvUseCase generateInvoicesFromCsvUseCase) {
        this.generateInvoicesFromCsvUseCase = generateInvoicesFromCsvUseCase;
    }

    @Operation(
            summary = "Generate invoices from CSV file",
            description = "Generates a PDF file with customer invoices based on the provided CSV file.",
            tags = {"Customer Invoices"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "PDF file with invoices generated successfully", content = @Content(mediaType = "application/pdf")),
            @ApiResponse(responseCode = "400", description = "Invalid CSV file provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error while generating invoices", content = @Content)
    })
    @PostMapping("/generate-invoices-from-csv")
    public ResponseEntity<byte[]> generateInvoicesFromCsv(@RequestParam("customersForInvoice") MultipartFile customersForInvoice) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(generateInvoicesFromCsvUseCase.generateInvoicesFromCsv(customersForInvoice).readAllBytes());
    }
}
