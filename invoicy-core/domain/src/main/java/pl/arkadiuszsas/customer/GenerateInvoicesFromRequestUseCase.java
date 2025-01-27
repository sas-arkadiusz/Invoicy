package pl.arkadiuszsas.customer;

import org.springframework.stereotype.Service;
import pl.arkadiuszsas.customer.dto.request.GenerateInvoicesCommand;

import java.io.ByteArrayInputStream;

@Service
public class GenerateInvoicesFromRequestUseCase {

    public ByteArrayInputStream generateInvoices(GenerateInvoicesCommand command) {
        throw new UnsupportedOperationException();
    }
}
