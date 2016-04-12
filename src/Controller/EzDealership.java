/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package Controller;
 
 
 
import View.EditFrame;
import View.MainFrame;
import View.SearchFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
 
 
/**
 * This is the main class for this project.
 * This tells the other classes when to be active
 * It also sets up how you can change between 
 *      said classes and how everything 
 *      interacts with everything else.
 * componentHidden: This sets the main window invisible
 *      while the none main windows are in use, once the "Exit"
 *      button is it, the program reopens the main window 
 *      without closing the program.
 * 
 */
public class EzDealership {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {   
        CreateDB.checkAndCreate();
        ArrayList<String> tableNames = new ArrayList<>();
        tableNames.add("Employees");
        tableNames.add("Inventory");
        tableNames.add("Sales");
        /* Set the Nimbus look and feel
         *<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        
        EditFrame ef = new EditFrame();
        SearchFrame sf = new SearchFrame();
        MainFrame mf = new MainFrame(ef, sf);
        mf.updateCbxTableList(tableNames);
        
        //Allows you to swap windows without closing the program.
        sf.addComponentListener(new ComponentAdapter() 
        {
            public void componentHidden(ComponentEvent e) 
            {
                mf.setVisible(true);
            }
            
        });
        
        ef.addComponentListener(new ComponentAdapter() 
        {
            public void componentHidden(ComponentEvent e) 
            {
                mf.setVisible(true);
            }
        });
    }  
}