package com.example.jaxb.controller;

import com.example.jaxb.model.Book;
import com.example.jaxb.service.BookXml;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Класс BookController
 *
 * @author Max Ivanov
 * created 21.12.2021
 */

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookXml bookService;

    /**
     * Записывает XML в файл
     */
    @GetMapping(value = "/xml")
    public void getFile() throws JAXBException{
        log.info("[GET] getFile()");
        bookService.marshal();
    }

    /**
     * Читает XML из файла и преобразует в Java объект
     */
    @GetMapping(value = "/back")
    public String getBookFromFile() throws JAXBException, IOException {
        var result = bookService.unmarshall().toString();
        log.info("[GET] getBookFromFile({})", result);
        return result;
    }
}
