import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nquah
 * Date: 7/17/12
 * Time: 1:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTreeNode {
    MenuTreeNode parentNode;
    ArrayList<MenuTreeNode> childNodes;
    ArrayList<String> preMessage;
    String customInstruction;
    String menuOption = null;

    public MenuTreeNode() {
        childNodes = new ArrayList<MenuTreeNode>();
        preMessage = new ArrayList<String>();
        resetToPreMessageDefault();
    }

    public void resetToPreMessageDefault() {
        preMessage = new ArrayList<String>();
        preMessage.add("Please select one of the following menu options");
    }

    public void setPreMessageCustomBeforeDefault(String inMessage) {
        preMessage = new ArrayList<String>();
        preMessage.add(inMessage);
        preMessage.add("Please select one of the following menu options");
    }

    // only single message
    public void setPreMessageCustom(String inMessage) {
        preMessage = new ArrayList<String>();
        preMessage.add(inMessage);
    }

    public void setPreMessageCustom(ArrayList<String> inMessage) {
        preMessage = new ArrayList<String>();
        preMessage = inMessage;
    }

    public ArrayList<String> getPreMessage() {
        return preMessage;
    }

    public void setCustomInstruction(String inInstruction) {
        customInstruction = inInstruction;
    }

    public void setMenuOption(String inMenuOption) {
        menuOption = inMenuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }

    public void setParentNode(MenuTreeNode inParent) {
        parentNode = inParent;
    }

    public void resetChildNodes() {
        childNodes = new ArrayList<MenuTreeNode>();
    }

    public void addChildNode(MenuTreeNode newChild) {
        childNodes.add(newChild);
    }

    public int getNumChildNodes() {
        return childNodes.size();
    }

    public ArrayList<MenuTreeNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(ArrayList<MenuTreeNode> inChildNodes) {
        childNodes = inChildNodes;
    }

    public MenuTreeNode getParentNode() {
        return parentNode;
    }

    public void displayCustomInstruction() {
        System.out.println(customInstruction);
    }

    public void displayPreMessage() {
        for (String message : preMessage)
            System.out.println(message);
    }

    public void displayMenuOptions() {
        displayPreMessage();
        int i = 0;
        for (MenuTreeNode child : childNodes) {
            i++;
            System.out.println(i + ": " + child.getMenuOption());
        }
    }

    public void executeMenuAction() {
        displayMenuOptions();
        UserInput userInput = new UserInput();
        int userChoice = userInput.handleUserInput(this);
        if (userChoice == -1) {
            System.out.println("Select a valid option!!");
            executeMenuAction();
        }
        else {
            childNodes.get(userChoice-1).executeMenuAction();
        }
    }

}