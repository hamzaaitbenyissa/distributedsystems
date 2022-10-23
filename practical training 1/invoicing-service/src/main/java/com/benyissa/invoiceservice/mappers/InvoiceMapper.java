package com.benyissa.invoiceservice.mappers;


import com.benyissa.invoiceservice.DTOs.InvoiceRequestDTO;
import com.benyissa.invoiceservice.DTOs.InvoiceResponseDTO;
import com.benyissa.invoiceservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceResponseDTO InvoiceToInvoiceResponseDTO(Invoice Invoice);

    Invoice InvoiceReuestDTOToInvoice(InvoiceRequestDTO InvoiceRequestDTO);


}
