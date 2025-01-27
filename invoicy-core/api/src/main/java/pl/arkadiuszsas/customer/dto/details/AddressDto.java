package pl.arkadiuszsas.customer.dto.details;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Address details")
public record AddressDto(

        @Schema(description = "Street name and building number",
                example = "Warszawska 1/2",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String streetAndNumber,

        @Schema(description = "Postal code",
                example = "12-345",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String postalCode,

        @Schema(description = "City name",
                example = "Warszawa",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String city,

        @Schema(description = "State or province",
                example = "mazowieckie",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String state,

        @Schema(description = "Country name",
                example = "Polska",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String country,

        @Schema(description = "Phone number in international format",
                example = "+48 123 456 789",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String phoneNumber) {

}
