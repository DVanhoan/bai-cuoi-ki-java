package Controller;

import View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home_Controller implements MouseListener {
    Home_Vieww homeVieww;
    public Home_Controller(Home_Vieww homeVieww){
        this.homeVieww = homeVieww;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==homeVieww.lbl_anhLoTrinh){
            homeVieww.setVisible(false);

            LoTrinh_View loTrinhView = new LoTrinh_View();
            loTrinhView.setVisible(true);
            loTrinhView.setLocationRelativeTo(null);
        }

        if (e.getSource()==homeVieww.lbl_anhxe){
            homeVieww.setVisible(false);

            Xe_View xeView = new Xe_View();
            xeView.setVisible(true);
            xeView.setLocationRelativeTo(null);
        }

        if (e.getSource()==homeVieww.lbl_anhVe){
            homeVieww.setVisible(false);

            VeXeView veXeView = new VeXeView();
            veXeView.setVisible(true);
            veXeView.setLocationRelativeTo(null);
        }
        if (e.getSource()==homeVieww.lbl_anhdatve){
            homeVieww.setVisible(false);

            BanVe_View banVeView = new BanVe_View();
            banVeView.setVisible(true);
            banVeView.setLocationRelativeTo(null);
        }

        if (e.getSource()==homeVieww.btn_dangXuat){
            homeVieww.setVisible(false);

            Login_View loginView = new Login_View();
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(null);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
