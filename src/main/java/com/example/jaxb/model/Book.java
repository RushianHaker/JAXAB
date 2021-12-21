package com.example.jaxb.model;

import com.example.jaxb.config.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Класс Book содержит следующие аннотации:
 *
 * <p>
 * XmlRootElement: имя корневого элемента XML является производным от имени класса,
 * и мы также можем указать имя корневого элемента XML, используя его атрибут name
 * XmlType: определите порядок, в котором поля записываются в XML-файл
 * XmlElement: определите фактическое имя XML-элемента, которое будет использоваться
 * XmlAttribute: определите, что поле id отображается как атрибут вместо элемента
 * XmlTransient: аннотировать поля, которые мы не хотим включать в XML
 * </p>
 *
 * @author Max Ivanov
 * created 21.12.2021
 */

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "book")
public class Book {
    @XmlAttribute
    private Long id;
    @XmlElement(name = "title")
    private String name;
    @XmlTransient
    private String author;
    @XmlElement(name = "date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    @Override
    public String toString() {
        return "Book {" + "id=" + id + ", name=" + name + ", date=" + date + '}';
    }
}
