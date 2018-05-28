package AirPlainPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter outInsertMessage=response.getWriter();
		
		
		TicketClass ticket=new TicketClass();
		TicketDaoClass ticketManager=new TicketDaoClass();
		
			String name = request.getParameter("name");
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String date = request.getParameter("date");
			int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
			int ticketId = Integer.parseInt(request.getParameter("ticketId"));

			ticket.setDate(date);
			ticket.setDestination(destination);
			ticket.setFlightNumber(flightNumber);
			ticket.setName(name);
			ticket.setSorce(source);
			ticket.setTicketId(ticketId);
			
			boolean checkUpdate=ticketManager.update(ticket,ticketId);
			if (checkUpdate == true){
				
				outInsertMessage.write("<h3 style='background-color: #BDFF94;width : 30%;'>Update Successfulliy </h3>");
				}
			else{
				outInsertMessage.write("<h1>Your Data Saved  Failed</h1>");}
			
		outInsertMessage.write("<!DOCTYPE html>");
		outInsertMessage.write("<html>");
		outInsertMessage.write("<body>");
		
		outInsertMessage.write("</body>");
		outInsertMessage.write("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
