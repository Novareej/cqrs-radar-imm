package ma.enset.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commands.CreateProprCommand;
import ma.enset.dtos.CreateProprRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/owner")
@AllArgsConstructor
@Service
public class ProprCommandController {
    private CommandGateway commandGateway;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createOwner(@RequestBody CreateProprRequestDTO createOwnerRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateProprCommand(
                UUID.randomUUID().toString(),
                createOwnerRequestDTO.getName(),
                createOwnerRequestDTO.getDateOfBirth(),
                createOwnerRequestDTO.getEmail()
        ));
        return response;
    }
}
