package Test;



import Controller.LoTrinh_Controller;
import View.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                Login_View loginView = new Login_View();
                loginView.setVisible(true);
                loginView.setLocationRelativeTo(null);

//                LoTrinh_View loTrinhView = new LoTrinh_View();
//                loTrinhView.setVisible(true);
//                loTrinhView.setLocationRelativeTo(null);

//                Xe_View xeView = new Xe_View();
//                xeView.setVisible(true);
//                xeView.setLocationRelativeTo(null);

//                BanVe_View banVeView = new BanVe_View();
//                banVeView.setVisible(true);
//                banVeView.setLocationRelativeTo(null);

//                VeXeView veXeView = new VeXeView();
//                veXeView.setVisible(true);
//                veXeView.setLocationRelativeTo(null);
//                veXeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

