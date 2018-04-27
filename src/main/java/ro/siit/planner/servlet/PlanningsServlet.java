package ro.siit.planner.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns={"/plannings"})
public class PlanningsServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Planning> plannings = DBMock.getInstance().getSchedulesPlannings();
//        req.setAttribute("plannings", plannings);
//        req.getRequestDispatcher("/jsps/plannings.jsp").forward(req, resp);
    }
}
