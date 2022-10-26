package com.benyissa.invoiceservice.services;

import com.benyissa.invoiceservice.DTOs.InvoiceRequestDTO;
import com.benyissa.invoiceservice.DTOs.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {


    List<InvoiceResponseDTO> listInvoices();

    List<InvoiceResponseDTO> listInvoicesByCustomerId(String customerId);

    InvoiceResponseDTO getInvoiceById(String id);

    InvoiceResponseDTO addInvoice(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO updateInvoice(String id, InvoiceRequestDTO invoiceRequestDTO);

    void deleteInvoice(String id);
}
