package pl.arkadiuszsas.customer.dto.details;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Details of an item included in the invoice")
public record InvoiceItemDto(

        @Schema(description = "Description of the item or service",
                example = "Consultation Service", requiredMode = Schema.RequiredMode.REQUIRED)
        String description,

        @Schema(description = "Quantity of the item",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED)
        int quantity,

        @Schema(description = "Price per unit of the item, in the applicable currency",
                example = "150.00",
                requiredMode = Schema.RequiredMode.REQUIRED)
        BigDecimal price) {

}
