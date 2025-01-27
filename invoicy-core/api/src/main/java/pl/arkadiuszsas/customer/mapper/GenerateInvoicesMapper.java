package pl.arkadiuszsas.customer.mapper;

import org.mapstruct.Mapper;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesCommand;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesRequest;
import pl.arkadiuszsas.customer.dto.response.GenerateInvoicesResponse;
import pl.arkadiuszsas.customer.dto.response.GeneratedInvoices;

@Mapper
public interface GenerateInvoicesMapper {

    GenerateInvoicesCommand toCommand(GenerateInvoicesRequest generateInvoicesRequest);
    GenerateInvoicesResponse toResponse(GeneratedInvoices generatedInvoices);
}
