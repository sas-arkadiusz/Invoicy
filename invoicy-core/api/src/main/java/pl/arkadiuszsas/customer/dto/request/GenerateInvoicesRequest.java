package pl.arkadiuszsas.customer.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.arkadiuszsas.customer.dto.business.BusinessCustomerDto;
import pl.arkadiuszsas.customer.dto.individual.IndividualCustomerDto;

import java.util.List;

@Schema(description = "Request to generate invoices for individual and business customers")
public record GenerateInvoicesRequest(

        @Schema(description = "List of individual customers for whom invoices will be generated",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        List<IndividualCustomerDto> individualCustomers,

        @Schema(description = "List of business customers for whom invoices will be generated",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        List<BusinessCustomerDto> businessCustomers) {

}
