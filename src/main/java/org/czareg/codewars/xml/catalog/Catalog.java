package org.czareg.codewars.xml.catalog;

import lombok.experimental.UtilityClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/*
You are given a small extract of a catalog:

s = "<root><prod><name>drill</name><prx>99</prx><qty>5</qty></prod>

<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>

<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>

<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>

<prod><name>saw</name><prx>9</prx><qty>10</qty></prod></root>
...
(prx stands for price, qty for quantity) and an article i.e "saw".

The function catalog(s, "saw") returns the line(s) corresponding to the article with $ before the prices:

"table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\n..."
If the article is not in the catalog return "Nothing".

Notes
There is a blank line between two lines of the catalog.

The same article may appear more than once. If that happens return all the lines concerned by the article (in the same order as in the catalog; however see below a note for Prolog language).
 */
@UtilityClass
public class Catalog {

    record Product(String name, String price, String quantity) {
    }

    public static String catalog(String s, String article) {
        String xml = "<root>" + s + "</root>";
        List<String> results = parseXmlToListOfProducts(xml).stream()
                .filter(product -> product.name().contains(article))
                .map(product -> "%s > prx: $%s qty: %s".formatted(product.name(), product.price(), product.quantity()))
                .toList();
        return results.isEmpty() ? "Nothing" : String.join("\n", results);
    }

    private static List<Product> parseXmlToListOfProducts(String s) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(s)));

            NodeList prodList = document.getElementsByTagName("prod");
            List<Product> productList = new ArrayList<>();

            for (int i = 0; i < prodList.getLength(); i++) {
                Element prodElement = (Element) prodList.item(i);
                Product product = parseProduct(prodElement);
                productList.add(product);
            }
            return productList;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Product parseProduct(Element prodElement) {
        String name = null;
        String price = null;
        String quantity = null;
        NodeList childNodes = prodElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String nodeName = element.getNodeName();
                String textContent = element.getTextContent();

                switch (nodeName) {
                    case "name":
                        name = textContent;
                        break;
                    case "prx":
                        price = textContent;
                        break;
                    case "qty":
                        quantity = textContent;
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }
        }
        return new Product(name, price, quantity);
    }
}
