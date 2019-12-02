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
public class Author implements Comparable<Author>, Serializable {

    private String lastname;
    private String firstname;
    private String url;
    private int rank;

    @Override
    public int compareTo(Author o) {
        return (this.lastname + this.firstname).compareTo(o.lastname + o.firstname);
    }

}
