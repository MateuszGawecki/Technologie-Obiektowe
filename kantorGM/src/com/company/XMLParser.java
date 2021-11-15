package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
    private final Document doc = new URLProvider().getFromURL();

    public void createRepository(){

        Repository rep = Repository.getInstance();

        doc.getDocumentElement().normalize();
        //System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("pozycja");
        for(int i = 0; i< nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            //System.out.println(node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                String name = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();

                int conversionRatio = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent());

                String code = element.getElementsByTagName("kod_waluty").item(0).getTextContent();

                float rate = Float.parseFloat(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",","."));

                rep.addToMap(new Currency(name,code,conversionRatio,rate));
            }
        }
    }
}
