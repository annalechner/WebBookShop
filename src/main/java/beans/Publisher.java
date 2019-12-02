/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
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
public class Publisher implements Serializable{
    private String name;
    private String url;
}
