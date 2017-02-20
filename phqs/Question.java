package phqs;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Question {

  private String label;
  private ButtonGroup group = new ButtonGroup();
  private JPanel radioPanel = new JPanel(new GridLayout(0, 1));

    static String notAtAll = "Not at all";
    static String severalDays = "Several days";
    static String moreThanHalf = "More than half the days";
    static String everyDay = "Nearly every day";

  public Question(String questionText){
    label = questionText;
  }

  public JLabel label(){
    return new JLabel(label);
  }

  public JPanel radioPanel(){
    populateRadioPanel();
    return radioPanel;
  }

  public ButtonModel getSelection() {
    return group.getSelection();
  }

  private void populateRadioPanel() {
    JRadioButton notAtAllButton = new JRadioButton(notAtAll);
    notAtAllButton.setActionCommand(notAtAll);

    JRadioButton severalDaysButton = new JRadioButton(severalDays);
    severalDaysButton.setActionCommand(severalDays);

    JRadioButton moreThanHalfButton = new JRadioButton(moreThanHalf);
    moreThanHalfButton.setActionCommand(moreThanHalf);

    JRadioButton everyDayButton = new JRadioButton(everyDay);
    everyDayButton.setActionCommand(everyDay);

    //Group the radio buttons.
    group.add(notAtAllButton);
    group.add(severalDaysButton);
    group.add(moreThanHalfButton);
    group.add(everyDayButton);

    //Add them to radio panel
    radioPanel.add(notAtAllButton);
    radioPanel.add(severalDaysButton);
    radioPanel.add(moreThanHalfButton);
    radioPanel.add(everyDayButton);
}

}
