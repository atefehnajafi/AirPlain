package AirPlainPack;

import java.awt.geom.RectangularShape;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter(filterName = "ServletFilter", urlPatterns = "/AirPlain")
public class ServletFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ServletFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter outFilterMessage = response.getWriter();

		HttpServletRequest req = (HttpServletRequest) request;

		int flightNumber = Integer.parseInt(req.getParameter("flightNumber"));

		int count = 0;

		while (flightNumber != 0) {
			flightNumber = flightNumber / 10;
			count++;
		}
		String date = req.getParameter("date");
		if (count == 3) {
			if (date.matches("^1[34][0-9][0-9]\\/((1[0-2])|(0[1-9]))\\/(([12][0-9])|(3[01])|0[1-9])")) {
				chain.doFilter(request, response);
			}
			else
			{
				outFilterMessage.write("<!DOCTYPE html>");
				outFilterMessage.write("<html>");
				outFilterMessage.write("<body>");
				outFilterMessage.write(
						"<h3  style='color: red;width : 60%;'>Date Format Is Wrong</h1>");
				outFilterMessage.write("</body>");
				outFilterMessage.write("</html>");
			}
		}
		else {
			outFilterMessage.write("<!DOCTYPE html>");
			outFilterMessage.write("<html>");
			outFilterMessage.write("<body>");
			outFilterMessage.write(
					"<h3  style='color: red;width : 60%;'>The number of Flight Number digits is three</h1>");
			outFilterMessage.write("</body>");
			outFilterMessage.write("</html>");

		}

		/*
		 * if (date.matches("\\d{4}-\\d{2}-\\d{2}")) { chain.doFilter(request,
		 * response); } String[] part=new String[10];
		 * 
		 * for(int i=0;i<date.length();i++) { part=date.split(""); }
		 * if(part[4].equals("/") && part[7].equals("/") ) {
		 * chain.doFilter(request, response); } else {
		 * outFilterMessage.write("<!DOCTYPE html>");
		 * outFilterMessage.write("<html>"); outFilterMessage.write("<body>");
		 * outFilterMessage.
		 * write("<h3  style='color: red;width : 60%;'>Date Format is Wrong...</h1>"
		 * ); outFilterMessage.
		 * write("<h4  style='color: red;width : 60%;'>You should write As ..../../..</h1>"
		 * ); outFilterMessage.write("</body>");
		 * outFilterMessage.write("</html>");
		 * 
		 * 
		 * }
		 */

		outFilterMessage.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
