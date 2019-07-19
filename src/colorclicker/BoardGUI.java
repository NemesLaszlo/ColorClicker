package colorclicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardGUI {
    
    private ArrayList<ArrayList<JButton>> buttons;
    private Board board; // model view összekötés
    private JPanel BoardPanel;
    private int clickNum = 0;
    
    private Random random = new Random();
    private final int NUM_COLORED = 4;

    public BoardGUI(int boardSize){
        board = new Board(boardSize);
        buttons = new ArrayList<>();
        BoardPanel = new JPanel();
        BoardPanel.setLayout(new GridLayout(boardSize,boardSize));
        for(int i = 0; i < boardSize; ++i){
            ArrayList<JButton> row = new ArrayList<>();
            for(int j = 0; j < boardSize; ++j){
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i, j) );
                row.add(button);
                BoardPanel.add(button);
                button.setPreferredSize(new Dimension(80,40));
            }
            buttons.add(row);
        }
        
    }

    public JPanel getBoardPanel() {
        return BoardPanel;
    }


    
    public void refresh(){ //logika szintű összekötés, megfelelő szinnel kitöltjük 
        for(int i = 0; i < buttons.size(); ++i){
            for(int j = 0; j < buttons.get(i).size(); ++j){
                JButton button = buttons.get(i).get(j);
                Field field = board.get(i, j);
                if( field.getColor() == null ){
                    button.setText("");
                    button.setBackground(null);
                }else{
                    button.setText(Integer.toString(field.getValue()));
                    button.setBackground(field.getColor());
                }
            }
        }
         if(board.isOver()){
             JOptionPane.showMessageDialog(this.BoardPanel,"Nyertél!","Gratula",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    class ButtonListener implements ActionListener{
        
        private int x,y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Field field = board.get(x,y);
            if(field.getColor() == null ){
            clickNum++;
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            field.setColor(color); 
            field.setValue(clickNum);
            for(int i = 0; i < NUM_COLORED ; ++i){
                int x = random.nextInt(board.getBoardSize());
                int y = random.nextInt(board.getBoardSize());
                while(board.get(x,y).getColor() != null){
                     x = random.nextInt(board.getBoardSize());
                     y = random.nextInt(board.getBoardSize());
                }
                
                board.get(x,y).setColor(color);
                board.get(x,y).setValue(clickNum);
            }
            refresh();
            }
        }
    
}

}
