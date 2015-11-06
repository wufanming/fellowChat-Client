package action.searchUIAction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import util.tools.Loginner;
import util.tools.Message;

import allUI.SearchUI;

import clientBase.ManClient;

public class RandomSearchAction extends MouseAdapter{

	private SearchUI searchUI;
	
	public RandomSearchAction(SearchUI searchUI){
		this.searchUI = searchUI;
	}
	
	public void mouseReleased(MouseEvent e){
		searchUI.setIndex(0);
		String msg = "<type>randomSearch</type><sender>"+Loginner.loginner+"</sender><index>0</index>";
		try{
			Message.sendMsg(msg, ManClient.client.getOutputStream());
		}catch(Exception ef){
			ef.printStackTrace();
		}
	}
}
