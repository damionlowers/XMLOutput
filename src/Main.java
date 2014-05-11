import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public class Main {
	
	public static void main(String aegs[]) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		ReadProjectXML read = new ReadProjectXML();
		
		EditPeerSection editSecPeer = new EditPeerSection(read.getPeerList(),read.getSectionList());
		
		editSecPeer.deleteSection("section number 5");
		editSecPeer.deletePeer("peer number 6");
		editSecPeer.deletePeer("This is another peer");
		
		
		
		WriteXMLProject write = new WriteXMLProject(editSecPeer.getPeerList(), editSecPeer.getSectionList());
	}

}
