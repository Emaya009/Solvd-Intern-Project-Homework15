package pharmacy.XMLparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;

public class SAXparserHandler extends DefaultHandler {

    public void startDocument()
    {
        System.out.println("Document begins here");
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs)
    {
        System.out.println("<" +qName + ">");
    }
    public void characters(char ch[],int start,int len)
    {
        System.out.println(new String(ch,start,len));
    }
    public void endElement(String uri,String localName,String qName)
    {
        System.out.println("</" +qName+ ">");
    }
    public void endDocument()
    {
        System.out.println("Document Ends Here");
    }
    public static void main(String[] args)throws Exception
    {
        SAXParser p= SAXParserFactory.newInstance().newSAXParser();
        p.parse(new FileInputStream("C:\\Users\\balaj\\IdeaProjects\\SolvdIntern\\src\\main\\java\\pharmacy\\XMLparser\\pharmacy.xml"),new SAXparserHandler());
    }
}
