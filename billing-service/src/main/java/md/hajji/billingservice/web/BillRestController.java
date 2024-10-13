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
import java.util.List;

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

    @GetMapping(path = "of-customer/{id}")
    public ResponseEntity<?> getBillByCustomerId(@PathVariable Long id) {
        try {
            List<BillDTO> billDTOS = billRepository.findByCustomerId(id)
                    .stream()
                    .map(billMapper::mapBill)
                    .toList();
            return ResponseEntity.ok(billDTOS);
        }catch (Exception exception){
            return ResponseEntity.badRequest()
                    .body(exception.getMessage());
        }
    }

}
