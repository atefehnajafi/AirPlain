package AirPlainPack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class TicketDaoClass {

	ConnectionClass _connectionObj = new ConnectionClass();
	Connection _connectionString = _connectionObj.GetConnection();
	
	
	public boolean insert(TicketClass ticket)
	{
		try {
			//System.out.println(_connectionString);
			Statement stm=_connectionString.createStatement();
			
			String query="insert Into tickettable(name,source,destination,flightNumber,date) Values ('"+ticket.getName()+"' , '"+ticket.getSorce()+"' ,"
					+ " '"+ticket.getDestination()+"' , '"+ticket.getFlightNumber()+"' , '"+ticket.getDate()+"')";
			
			int rows=stm.executeUpdate(query);
			_connectionObj.CloseConnect();
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int showTicketId(TicketClass ticket)
	{
		int ticketId=0;
		try {
			Connection _connectionString = _connectionObj.GetConnection();
			
			Statement stm1=_connectionString.createStatement();
			String checkQuery="select * from TicketTable where flightNumber='"+ticket.getFlightNumber()+"' and name='"+ticket.getName()+"'";
			ResultSet result=stm1.executeQuery(checkQuery);
			while(result.next())
			{
				ticketId=Integer.parseInt(result.getString("ticketId"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ticketId;
	}
	
	
	
	public boolean delete(int id)
	{
		try {
			Statement stm=_connectionString.createStatement();
			String query="Delete From TicketTable Where ticketId='"+id+"'";
			boolean deleteTicket=stm.execute(query);
			_connectionObj.CloseConnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public TicketClass showTicket(int id)
	{
		TicketClass ticket=new TicketClass();
		try {
			Statement stm=_connectionString.createStatement();
			String checkQuery="select * from TicketTable where ticketId='"+id+"'";
			ResultSet result=stm.executeQuery(checkQuery);
			while(result.next())
			{
				String name=result.getString("name");
				String sorce=result.getString("source");
				String destination=result.getString("destination");
				String date=result.getString("date");
				int flightNumber=Integer.parseInt(result.getString("flightNumber"));
				
				
				ticket.setDate(date);
				ticket.setDestination(destination);
				ticket.setFlightNumber(flightNumber);
				ticket.setName(name);
				ticket.setSorce(sorce);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}
	
	
	
	public boolean update(TicketClass ticket,int id)
	{
		try {
			Statement stm=_connectionString.createStatement();
			String query="update TicketTable set name ='"+ticket.getName()+"' , source='"+ticket.getSorce()+"' ,"
					+ " destination='"+ticket.getDestination()+"'  , date='"+ticket.getDate()+"' , flightNumber='"+ticket.getFlightNumber()+"' "
							+ "where ticketId='"+id+"'";
			
			stm.executeUpdate(query);
			return true;
					
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
