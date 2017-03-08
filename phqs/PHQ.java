package phqs;

import phqs.Question;

public class PHQ {

  public static Question[] questions() {
    Question[] questions = {
      new Question("1. Little interest or pleasure in doing things"),
      new Question("2. Feeling down, depressed, or hopeless"),
      new Question("3. Trouble falling or staying asleep, or sleeping too much"),
      new Question("4. Feeling tired or having little energy"),
      new Question("5. Poor appetite or overeating"),
      new Question("6. Feeling bad about yourself- or that you are a failure or have let yourself or your family down"),
      new Question("7. Trouble concentrating on things, such as reading the newspaper or watching television"),
      new Question("8. Moving or speaking so slowly that other people could have noticed. Or the opposite – being so fidgety or restless that you have been moving around a lot more than usual"),
      new Question("9. Thoughts that you would be better off dead, or of hurting yourself in some way")
    };
    return questions;
  }
}
