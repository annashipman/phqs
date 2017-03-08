package phqs;

import phqs.Question;
import phqs.PHQ;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class Questions extends JPanel
                             implements ActionListener {
    static String submit = "Submit";
    Question[] questions = PHQ.questions();

    public Questions() {
        super(new GridLayout(0, 2));
    }

    public void loadQuestions() {

        for (Question q: questions) {
          add(q.label());
          add(q.radioPanel());
          add(new JSeparator(SwingConstants.HORIZONTAL));
          add(new JSeparator(SwingConstants.HORIZONTAL));
        }

    }

    public void addSubmitButton() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JButton submitButton = new JButton(submit);
        submitButton.addActionListener(this);

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;

        buttonPanel.add(submitButton);
        add(buttonPanel);
    }


    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        for (Question q: questions){
          ButtonModel selection = q.getSelection();
          if (selection != null) {
            writeResults(selection.getActionCommand());
          }
          else {
            System.out.println("None selected");
          }
        }
    }

    private static void writeResults(String results) {
      Path file = Paths.get("./file.txt");
      try (BufferedWriter writer =
          Files.newBufferedWriter(
            file,
            StandardCharsets.UTF_8,
            StandardOpenOption.CREATE,
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
        Questions newContentPane = new Questions();
        newContentPane.loadQuestions();
        newContentPane.addSubmitButton();
        newContentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
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
