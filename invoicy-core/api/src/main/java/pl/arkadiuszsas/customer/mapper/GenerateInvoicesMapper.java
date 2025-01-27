package pl.arkadiuszsas.customer.mapper;

import org.mapstruct.Mapper;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesCommand;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesRequest;

@Mapper
public interface GenerateInvoicesMapper {

    public GenerateInvoicesCommand toCommand(GenerateInvoicesRequest request);
}
