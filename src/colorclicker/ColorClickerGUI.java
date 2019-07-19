package colorclicker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ColorClickerGUI {
    private JFrame frame;
    private BoardGUI boardGUI;
    
    
    public ColorClickerGUI(){
        frame = new JFrame("ColorClicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boardGUI = new BoardGUI(10);
        frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("Játék");
        menuBar.add(menu);
        int[] boardSizes = new int[]{5,10,15};
        for( int x : boardSizes ){
            JMenuItem SizeMenuIthem = new JMenuItem(x + "x" + x);
            menu.add(SizeMenuIthem);
            SizeMenuIthem.addActionListener(new NewActionListener(x));
        }
        JMenuItem exitMenuItem = new JMenuItem("Kilépés");
        menu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
       
        
        frame.pack();
        frame.setVisible(true);
    }
    
    class NewActionListener implements ActionListener{
        
        int boardSize;
        
        public NewActionListener(int boardSize){
            this.boardSize = boardSize;
        }

       @Override
            public void actionPerformed(ActionEvent e) { // levesz panel, új panel létrehoz majd azt rakjuk a frame-ra
                frame.getContentPane().remove(boardGUI.getBoardPanel());
                boardGUI = new BoardGUI(boardSize);
                frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
                frame.pack();
            }
    
    }
    
}
