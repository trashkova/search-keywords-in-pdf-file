package ru.trashkova.keywords.pdf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.trashkova.keywords.pdf.exception.WrongLinksFormatException;
import ru.trashkova.keywords.pdf.payload.LinksSuggester;
import ru.trashkova.keywords.pdf.util.DirNameConstants;
import ru.trashkova.keywords.pdf.util.PDFUtil;

import java.io.File;
import java.io.IOException;

public class KeywordsPdfApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(KeywordsPdfApplication.class);

    public static void main(String[] args) {
        try {
            LinksSuggester linksSuggester = new LinksSuggester(new File(DirNameConstants.MAIN_DIR_NAME +"/config"));
            // получить все файлы в директории и обработать полученные pdf-документы
            var dir = new File(DirNameConstants.MAIN_DIR_NAME + DirNameConstants.SUB_DIR_ALL_PDFS_NAME);
            File[] files = dir.listFiles();
            if (files != null) {
                for (var fileIn : files) {
                    PDFUtil pdfUtil = new PDFUtil(fileIn, linksSuggester, DirNameConstants.MAIN_DIR_NAME);
                    pdfUtil.edit();
                }
            }
        } catch (WrongLinksFormatException | IOException e) {
            LOGGER.error("конфигурационный файл не найден или содержит некорректные данные");
        }
    }

}