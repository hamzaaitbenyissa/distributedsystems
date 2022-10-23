package com.benyissa.invoiceservice.web;

import com.benyissa.invoiceservice.DTOs.InvoiceRequestDTO;
import com.benyissa.invoiceservice.DTOs.InvoiceResponseDTO;
import com.benyissa.invoiceservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class InvoiceRestController {

    final InvoiceService InvoiceService;

    public InvoiceRestController(InvoiceService InvoiceService) {
        this.InvoiceService = InvoiceService;
    }

    //    return all invoices
    @GetMapping("/invoices")
    public List<InvoiceResponseDTO> Invoices() {
        return InvoiceService.listInvoices();
    }

    //    get an Invoice by id
    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable String id) {
        return InvoiceService.getInvoiceById(id);
    }

    //    create a new Invoice
    @PostMapping("/invoices")
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO InvoiceRequestDTO) {
        return this.InvoiceService.addInvoice(InvoiceRequestDTO);
    }

    //update an Invoice
    @PutMapping("/invoices/{id}")
    public InvoiceResponseDTO updateInvoice(@PathVariable String id, @RequestBody InvoiceRequestDTO InvoiceRequestDTO) {
        return InvoiceService.updateInvoice(id, InvoiceRequestDTO);
    }

    //delete an Invoice
    @DeleteMapping("/invoices/{id}")
    public void deleteInvoice(@PathVariable String id) {
        this.InvoiceService.deleteInvoice(id);
    }

    //    return all invoices for a customer
    @GetMapping("/invoicesbycustomer/{id}")
    public List<InvoiceResponseDTO> invoicesByCustomerId(@PathVariable String id) {
        return InvoiceService.listInvoicesByCustomerId(id);
    }


}
