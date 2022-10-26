package com.benyissa.invoiceservice.services;

import com.benyissa.invoiceservice.DTOs.InvoiceRequestDTO;
import com.benyissa.invoiceservice.DTOs.InvoiceResponseDTO;
import com.benyissa.invoiceservice.entities.Invoice;
import com.benyissa.invoiceservice.exceptions.InvoiceNotFoundException;
import com.benyissa.invoiceservice.mappers.InvoiceMapper;
import com.benyissa.invoiceservice.openfeign.CustomerRestClient;
import com.benyissa.invoiceservice.repositories.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepo invoicerepo;
    @Autowired
    InvoiceMapper invoicemapper;

    @Autowired
    CustomerRestClient customerRestClient;

    @Override
    public List<InvoiceResponseDTO> listInvoices() {
        return invoicerepo.findAll()
                .stream()
                .map(invoice -> {
                    InvoiceResponseDTO invoiceResponseDTO = invoicemapper.InvoiceToInvoiceResponseDTO(invoice);
                    invoiceResponseDTO.setCustomer(customerRestClient.getCustomerById(invoice.getCustomerId()));
                    return invoiceResponseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> listInvoicesByCustomerId(String customerId) {
        return invoicerepo.findByCustomerId(customerId)
                .stream()
                .map(invoice -> {
                    InvoiceResponseDTO invoiceResponseDTO = invoicemapper.InvoiceToInvoiceResponseDTO(invoice);
                    invoiceResponseDTO.setCustomer(customerRestClient.getCustomerById(invoice.getCustomerId()));
                    return invoiceResponseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceResponseDTO getInvoiceById(String id) {
        Invoice invoice = invoicerepo.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        InvoiceResponseDTO invoiceResponseDTO = invoicemapper.InvoiceToInvoiceResponseDTO(invoice);
        invoiceResponseDTO.setCustomer(customerRestClient.getCustomerById(invoice.getCustomerId()));
        return invoicemapper.InvoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public InvoiceResponseDTO addInvoice(InvoiceRequestDTO InvoiceRequestDTO) {
        Invoice InvoiceToSave = invoicemapper.InvoiceReuestDTOToInvoice(InvoiceRequestDTO);
        InvoiceToSave.setId(UUID.randomUUID().toString());
        InvoiceToSave.setDate(new Date());
        invoicerepo.save(InvoiceToSave);
        InvoiceResponseDTO invoiceResponseDTO = invoicemapper.InvoiceToInvoiceResponseDTO(InvoiceToSave);
        invoiceResponseDTO.setCustomer(customerRestClient.getCustomerById(InvoiceRequestDTO.getCustomerId()));
        return invoiceResponseDTO;
    }

    @Override
    public InvoiceResponseDTO updateInvoice(String id, InvoiceRequestDTO InvoiceRequestDTO) {
        Invoice InvoiceToSave = invoicerepo.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        InvoiceToSave.setAmount(InvoiceRequestDTO.getAmount());
        InvoiceToSave.setCustomerId(InvoiceRequestDTO.getCustomerId());
        InvoiceResponseDTO invoiceResponseDTO = invoicemapper.InvoiceToInvoiceResponseDTO(InvoiceToSave);
        invoiceResponseDTO.setCustomer(customerRestClient.getCustomerById(InvoiceRequestDTO.getCustomerId()));
        return invoiceResponseDTO;
    }

    @Override
    public void deleteInvoice(String id) {
        Invoice InvoiceToDelete = invoicerepo.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        invoicerepo.delete(InvoiceToDelete);
    }


}
