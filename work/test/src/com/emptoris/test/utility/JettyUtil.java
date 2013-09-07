package com.emptoris.test.utility;

import org.apache.axis.transport.http.AdminServlet;
import org.apache.axis.transport.http.AxisServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyUtil {
    private static Server _server;

    public static synchronized void initJetty() throws Exception {
        _server = new Server(8080);
        SocketConnector connector = new SocketConnector();
        _server.addConnector(connector);

        ServletHolder axisServletholder = new ServletHolder(new AxisServlet());
        ServletHolder axisAdminServletholder = new ServletHolder(new AdminServlet());

        ServletContextHandler root = new ServletContextHandler(_server, "/", ServletContextHandler.SESSIONS);
        root.addServlet(axisServletholder, "/servlet/AxisServlet");
        root.addServlet(axisServletholder, "/services/*");
        root.addServlet(axisServletholder, "*.jws");
        root.addServlet(axisAdminServletholder, "/servlet/AdminServlet");
        _server.start();
    }

    public static synchronized void destroyJetty() throws Exception {
        if (_server.isRunning()) {
            _server.stop();
        }
    }
}
