import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  @WebServlet("/1414080902208")
  public class Se1414080902208Servlet extends HttpServlet {
  
  		request.setCharacterEncoding("gb2312");
  		response.setCharacterEncoding("gb2312");
  		PrintWriter out = response.getWriter();
 		String Score = new String(request.getParameter("score"));
 		String Comment = new String(request.getParameter("comment"));
 		HttpSession session=request.getSession(true);
 		String msg = "";
  		if (Score.equals("")) {
 			out.println("���ֲ���Ϊ��");
 			msg = "���ֲ���Ϊ��";
  		} else if (Comment.equals("")) {
 			out.println("���۲���Ϊ��");
 			msg = "���۲���Ϊ��";
  		} else {
  			boolean flat = true;
  			char[] str=Score.toCharArray();
  			for (int i = 0;i < Score.length();i++) {
  				int x = str[i] - '0';
  				if (!(x >= 0 && x <= 10)) {
 // �������Ϊ10�֣���	
	                     out.println("��������ȷ������");
 					msg = "��������ȷ������";
  					flat = false;
  					break;
  				}
 
  				for (int i = 0;i < Amount.length();i++) {
  					int x = sstr[i] - '0';
  					if (!(x >= 0 && x <= 100)) {

 //�����������Ϊ100 ����			out.println("����������Χ����������");
 						msg = "����������Χ����������";
  						flat = false;
  						break;
  					}
  				}
  			}
 			if (flat) out.println("���۳ɹ�");
 			if (flat) msg = "���۳ɹ�";
  		}
 		System.out.println(msg);
 		request.setAttribute("message", msg);
 		request.getRequestDispatcher("/index.jsp").forward(request, response);

 		session.setAttribute("message", msg);


 