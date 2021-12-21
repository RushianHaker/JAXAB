package com.example.jaxb.service;

import com.example.jaxb.model.Book;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

/**
 * Класс BookXml
 *
 * @author Max Ivanov
 * created 21.12.2021
 */

@Service
public class BookXml {

    public static final String FILE_PATH = "src/main/resources/book.xml";

    public void marshal() throws JAXBException {
        var book = new Book(1L,"Book1","Author1", new Date());
        var file = new File(FILE_PATH);

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(book, file);
    }

    public Book unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        return (Book) context.createUnmarshaller()
                .unmarshal(new FileReader(FILE_PATH));
    }
}
