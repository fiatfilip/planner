package ro.siit.planner.servlet;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/qrvalidator")
public class QRServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String qrText = req.getParameter("salt");
        ByteArrayOutputStream out = QRCode.from(qrText).to(ImageType.PNG).withSize(300, 300).stream();

        response.setContentType("image/png");
        response.setContentLength(out.size());

        OutputStream os = response.getOutputStream();
        os.write(out.toByteArray());

        os.flush();
        os.close();

    }
}
