import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Questions extends JPanel
                             implements ActionListener {
    static String notAtAll = "Not at all";
    static String severalDays = "Several days";
    static String moreThanHalf = "More than half the days";
    static String everyDay = "Nearly every day";
    static String submit = "Submit";

    ButtonGroup group = new ButtonGroup();

    public Questions() {

        super(new BorderLayout());

        //Create question
        JLabel question = new JLabel("Sample question");

        //Create the radio buttons.
        JRadioButton notAtAllButton = new JRadioButton(notAtAll);
        notAtAllButton.setMnemonic(KeyEvent.VK_0);
        notAtAllButton.setActionCommand(notAtAll);

        JRadioButton severalDaysButton = new JRadioButton(severalDays);
        severalDaysButton.setMnemonic(KeyEvent.VK_1);
        severalDaysButton.setActionCommand(severalDays);

        JRadioButton moreThanHalfButton = new JRadioButton(moreThanHalf);
        moreThanHalfButton.setMnemonic(KeyEvent.VK_2);
        moreThanHalfButton.setActionCommand(moreThanHalf);

        JRadioButton everyDayButton = new JRadioButton(everyDay);
        everyDayButton.setMnemonic(KeyEvent.VK_3);
        everyDayButton.setActionCommand(everyDay);

        //Group the radio buttons.
        group.add(notAtAllButton);
        group.add(severalDaysButton);
        group.add(moreThanHalfButton);
        group.add(everyDayButton);

        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(notAtAllButton);
        radioPanel.add(severalDaysButton);
        radioPanel.add(moreThanHalfButton);
        radioPanel.add(everyDayButton);

        //add a submit button
        JButton submitButton = new JButton(submit);
        submitButton.addActionListener(this);

        add(question, BorderLayout.WEST);
        add(radioPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        //compose this to get what I want the action to be
        ButtonModel selection = group.getSelection();
        if (selection != null) {
          writeResults(selection.getActionCommand());
        }
        else {
          System.out.println("None selected");
        }
    }

    private static void writeResults(String results) {
      Path file = Paths.get("./file.txt");
      try (BufferedWriter writer =
          Files.newBufferedWriter(
            file,
            StandardCharsets.UTF_8,
            StandardOpenOption.APPEND
          )
        ) {
        writer.append(results, 0, results.length());
      } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
      }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PHQs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Questions();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
