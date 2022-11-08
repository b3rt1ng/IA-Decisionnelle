package blocksworld;

import representation.Variable;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");

        // Building state
        int n = 5;
        BWStateBuilder <Integer> builder = BWStateBuilder.makeBuilder(n);
        for (int b = 0 ; b<n ; b++) 
        {
            Variable onB = ...; // get instance of Variable for " on_b "
            int under = (int) instanciation.get(onB);
            if (under >= 0) 
            { 
                // if the value is a block ( as opposed to a stack )
                builder.setOn (b , under );
            }
        }

        BWState <Integer> state = builder.getState();

        // Displaying
        BWIntegerGUI gui = new BWIntegerGUI(n);
        JFrame frame = new JFrame(title);
        frame.add(gui.getComponent(state));
        frame.pack();
        frame.setVisible(true);
    }    
}
