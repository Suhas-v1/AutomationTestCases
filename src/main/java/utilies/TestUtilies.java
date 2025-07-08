package utilies;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;

public class TestUtilies {

    public static final long Wait=10;
    public HashMap<String, String> parseStringXML(InputStream file) throws Exception {

        HashMap<String, String> stringmap = new HashMap<String, String>();

        //To get document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build document
        Document document = builder.parse(file);

        //normalize the XML structure
        document.getDocumentElement().normalize();

        //Root node
        Element root= document.getDocumentElement();

        //Get all elements
        NodeList nList=document.getElementsByTagName("string");

        for (int temp=0;temp < nList.getLength();temp++){
            Node node=nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element eElement=(Element) node;
                stringmap.put(eElement.getAttribute("name"), eElement.getTextContent());
            }

        }
        return stringmap;


    }

}
