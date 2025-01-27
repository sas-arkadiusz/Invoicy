package pl.arkadiuszsas.customer;

import org.springframework.stereotype.Service;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesCommand;
import pl.arkadiuszsas.customer.dto.response.GeneratedInvoices;

@Service
public class GenerateInvoicesFromRequestUseCase {

    public GeneratedInvoices generateInvoices(GenerateInvoicesCommand command) {
        throw new UnsupportedOperationException();
    }
}
