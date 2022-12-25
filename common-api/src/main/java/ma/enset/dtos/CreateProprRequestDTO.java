package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateProprRequestDTO {
    public String name;
    public Date dateOfBirth;
    public String email;
}
