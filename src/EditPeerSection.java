import java.util.ArrayList;
import java.util.List;


public class EditPeerSection {
	
	private List<String> peerList = new ArrayList<String>();
	private List<String> sectionList = new ArrayList<String>();
	
	public EditPeerSection(List<String> peerList,List<String> sectionList)
	{
		this.peerList = peerList;
		this.sectionList = sectionList;
	}
	
	public void addSection(String section)
	{
		sectionList.add(section);
	}
	public void addPeer(String peer)
	{
		peerList.add(peer);
	}
	
	public List<String> getSectionList()
	{
		return sectionList;
	}
	public List<String> getPeerList()
	{
		return peerList;
	}
	
	public void deletePeer(String peer)
	{
		if(peerList.remove(peer))
		{
			System.out.println("Peer deleted succesfully..");
		}
		else
		{
			System.out.println("was unsuccesful in deleting peer "+peer);
		}
	}
	
	public void deleteSection(String section)
	{
		if(sectionList.remove(section))
		{
			System.out.println("section deleted succesfully");
		}
		else
		{
			System.out.println("was unsuccesful in deleting section "+section);
		}
	}
}
