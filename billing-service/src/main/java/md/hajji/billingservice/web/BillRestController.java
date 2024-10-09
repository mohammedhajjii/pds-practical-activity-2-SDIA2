package md.hajji.billingservice.web;

import lombok.RequiredArgsConstructor;
import md.hajji.billingservice.dtos.BillDTO;
import md.hajji.billingservice.mappers.BillMapper;
import md.hajji.billingservice.repositories.BillRepository;
import md.hajji.billingservice.web.errors.UnresolvedResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bill-details")
@RequiredArgsConstructor
public class BillRestController {

    private final BillRepository billRepository;
    private final BillMapper billMapper;


    @GetMapping(path = "{id}")
    public ResponseEntity<?> getBillById(@PathVariable Long id) {

       try {
           BillDTO billDTO = billRepository.findById(id)
                   .map(billMapper::mapBill)
                   .orElseThrow(() -> new UnresolvedResourceException("bill"));

           return ResponseEntity.ok(billDTO);
       }catch (Exception exception){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(exception.getMessage());
       }

    }

}
