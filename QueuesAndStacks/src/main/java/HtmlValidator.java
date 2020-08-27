import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
    Stack<HtmlTag> htmlTagStack = new Stack<>();

    for (HtmlTag tag : tags) {
      if (tag.isOpenTag()) {
        htmlTagStack.push(tag);
      } else {
        if (!tag.isSelfClosing()) {
          if (!htmlTagStack.isEmpty() && tag.matches(htmlTagStack.peek())) {
            htmlTagStack.pop();
          } else {
            return htmlTagStack.isEmpty() ? null : htmlTagStack;
          }
        }

      }
    }

    return htmlTagStack;
	}

}

