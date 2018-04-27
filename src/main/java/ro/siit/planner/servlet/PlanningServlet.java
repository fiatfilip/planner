package ro.siit.planner.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.siit.planner.entity.Employee;
import ro.siit.planner.entity.Planning;
import ro.siit.planner.entity.Room;
import ro.siit.planner.model.EmployeeModel;
import ro.siit.planner.model.PlanningModel;
import ro.siit.planner.model.RoomModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static ro.siit.persistence.JpaListener.PERSISTENCE_FACTORY;

@WebServlet(urlPatterns={"/planning"})
public class PlanningServlet extends HttpServlet {
    private EntityManager entityManager;
    private RoomModel roomModel;
    private EmployeeModel employeeModel;
    private PlanningModel planningModel;
    private static final Logger LOGGER = LoggerFactory.getLogger(PlanningServlet.class.getName());

    @Override
    public void init() throws ServletException {
        LOGGER.info("Initializing planning servlet");
        super.init();
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute(PERSISTENCE_FACTORY);
        entityManager = emf.createEntityManager();
        roomModel = new RoomModel(entityManager);
        employeeModel = new EmployeeModel(entityManager);
        planningModel = new PlanningModel(entityManager);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", employeeModel.getEmployees());
        req.setAttribute("rooms", roomModel.getRooms());

        req.getRequestDispatcher("/jsps/planning.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID employeeId = UUID.fromString(req.getParameter("employee"));
        UUID roomId = UUID.fromString(req.getParameter("room"));
        Employee employee = employeeModel.getEmployeeById(employeeId);
        Room room = roomModel.getRoomById(roomId);
        Planning planning = new Planning();
        planning.setPlanningId(UUID.randomUUID());
        planning.setEmployee(employee);
        planning.setRoom(room);
        planningModel.schedulePlanning(planning);
        resp.sendRedirect(getServletContext().getContextPath() + "/plannings");
    }
}
