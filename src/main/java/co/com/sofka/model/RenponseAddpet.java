package co.com.sofka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenponseAddpet {

    public Long id;
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", category:" + category +
                ", name:'" + name + '\'' +
                ", photoUrls:" + photoUrls +
                ", tags:" + tags +
                ", status:'" + status + '\'' +
                '}';
    }
}
