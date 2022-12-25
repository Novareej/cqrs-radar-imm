package ma.enset.commands;

import lombok.Getter;

import java.util.Date;

public class CreateProprCommand extends BaseCommand<String> {
    @Getter public String name;
    @Getter public Date dateOfBirth;
    @Getter public String email;

    public CreateProprCommand(String id, String name, Date dateOfBirth, String email) {
        super(id);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
