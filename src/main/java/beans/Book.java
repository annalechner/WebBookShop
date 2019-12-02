/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class Book implements Serializable, Comparable<Book>{
    
    private String title;
    private String url;
    private double price;
    private Publisher publisher;
    private String isbn;
    private List<Author> authors = new ArrayList<>();

    @Override
    public int compareTo(Book o) {
        return 0;
    }
    public Author getFirstAuthor(){
        return authors.get(0);
    }
}
