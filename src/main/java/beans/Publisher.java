/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author annalechner
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publisher {
    private String name;
    private String url;
}
