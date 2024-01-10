package chap18;

import java.awt.*;
import javax.swing.*;
import java.rmi.*;
import java.awt.event.*;

public class ServiceBrowser {

    private JPanel mainPanel;
    private JComboBox<Object> serviceList;
    private ServiceServer server;

    public void buildGUI() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        Object[] services = getServicesList();

        serviceList = new JComboBox<>(services);
        frame.getContentPane().add(BorderLayout.NORTH, serviceList);

        serviceList.addActionListener(new MyListListener());

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void loadService(Object serviceSelection) {
        try {
            Service svc = server.getService(serviceSelection);

            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Object[] getServicesList() {
        Object obj = null;
        Object[] services = null;

        try {
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        server = (ServiceServer) obj;

        try {
            services = server.getServiceList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }

    private class MyListListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }

    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
}
