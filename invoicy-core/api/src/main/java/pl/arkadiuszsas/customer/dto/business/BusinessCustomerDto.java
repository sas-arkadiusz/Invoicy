package pl.arkadiuszsas.customer.dto.business;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.arkadiuszsas.customer.dto.details.AddressDto;
import pl.arkadiuszsas.customer.dto.details.InvoiceItemDto;

import java.util.List;

@Schema(description = "Details of a business customer for invoice generation")
public record BusinessCustomerDto(

        @Schema(description = "Name of the company",
                example = "XYZ Sp. z o.o.",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String companyName,

        @Schema(description = "Email address of the business customer",
                example = "contact@xyz.com",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String customerEmail,

        @Schema(description = "Company address details",
                requiredMode = Schema.RequiredMode.REQUIRED)
        AddressDto companyAddress,

        @Schema(description = "VAT number (tax ID) of the business customer",
                example = "123-456-78-90",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String vatNumber,

        @Schema(description = "Date of invoice generation in ISO format (yyyy-MM-dd)",
                example = "2025-01-27",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String invoiceDate,

        @Schema(description = "List of items included in the invoice",
                requiredMode = Schema.RequiredMode.REQUIRED)
        List<InvoiceItemDto> items) {

}
