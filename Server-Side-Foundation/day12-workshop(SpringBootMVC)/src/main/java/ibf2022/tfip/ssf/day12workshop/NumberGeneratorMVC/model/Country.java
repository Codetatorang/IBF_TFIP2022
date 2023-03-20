package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String code;
    private String name;
    private int population;
}
