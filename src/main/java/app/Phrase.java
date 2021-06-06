package app;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "phrases")
@NoArgsConstructor
public class Phrase {

    private static int ids = 1;

    @Id
    private Integer id;
    @NotBlank(message = "Текст не должен быть пустым")
    @Size(min = 5, max = 50, message = "Длина фразы должна быть от 5 до 50 символов")
    private String text;

    public Phrase(String text) {
        this.text = text;
    }

    public void id(){
        this.id = ids++;
    }
}
