package pl.arkadiuszsas.customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesRequest;
import pl.arkadiuszsas.customer.dto.response.GenerateInvoicesResponse;
import pl.arkadiuszsas.customer.mapper.GenerateInvoicesMapper;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Invoices", description = "Operations related to generating invoices for customers")
public class GenerateInvoicesController {

    private final GenerateInvoicesFromRequestUseCase generateInvoicesFromRequestUseCase;
    private final GenerateInvoicesMapper generateInvoicesMapper;

    public GenerateInvoicesController(GenerateInvoicesFromRequestUseCase generateInvoicesFromRequestUseCase,
                                      GenerateInvoicesMapper generateInvoicesMapper) {
        this.generateInvoicesFromRequestUseCase = generateInvoicesFromRequestUseCase;
        this.generateInvoicesMapper = generateInvoicesMapper;
    }

    @Operation(
            summary = "Generate invoices from Request",
            description = "Generates a PDF file with customer invoices based on the provided Request data.",
            tags = {"Customer Invoices"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "PDF file with invoices generated successfully", content = @Content(mediaType = "application/pdf")),
            @ApiResponse(responseCode = "400", description = "Invalid invoice data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error while generating invoices", content = @Content)
    })
    @PostMapping("/generate-invoices")
    public ResponseEntity<GenerateInvoicesResponse> generateInvoicesFromRequest(@RequestBody GenerateInvoicesRequest request) {
        var generatedInvoices = generateInvoicesFromRequestUseCase.generateInvoices(generateInvoicesMapper.toCommand(request));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(generateInvoicesMapper.toResponse(generatedInvoices));
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
        throw new UnsupportedOperationException();
    }
}
