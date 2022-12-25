package ma.enset.query.controllers;

import lombok.AllArgsConstructor;
import ma.enset.queries.GetPropr;
import ma.enset.query.entities.Proprietaire;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/owner")
@AllArgsConstructor
@Service
public class ProprQueryController {
    private QueryGateway queryGateway;


    @GetMapping(path = "/")
    public List<Proprietaire> getPropr() {
        return queryGateway.query(new GetPropr(), ResponseTypes.multipleInstancesOf(Proprietaire.class)).join();
    }

    @GetMapping(path = "/{id}")
    public Proprietaire getOwner(@PathVariable String id) {
        return queryGateway.query(new GetPropr(id), Proprietaire.class).join();
    }


}
