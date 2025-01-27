package pl.arkadiuszsas.customer.dto.individual;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.arkadiuszsas.customer.dto.details.AddressDto;
import pl.arkadiuszsas.customer.dto.details.InvoiceItemDto;

import java.util.List;

@Schema(description = "Details of an individual customer for invoice generation")
public record IndividualCustomerDto(

        @Schema(description = "Full name of the individual customer",
                example = "Jan Kowalski",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String customerName,

        @Schema(description = "Email address of the individual customer",
                example = "jan.kowalski@example.com",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String customerEmail,

        @Schema(description = "Address details of the individual customer",
                requiredMode = Schema.RequiredMode.REQUIRED)
        AddressDto customerAddress,

        @Schema(description = "Date of invoice generation in ISO format (yyyy-MM-dd)",
                example = "2025-01-27",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String invoiceDate,

        @Schema(description = "List of items included in the invoice",
                requiredMode = Schema.RequiredMode.REQUIRED)
        List<InvoiceItemDto> items) {

}
