
public enum Menu {
	ADD("Place a string on the stack"),
	POP("Remove the top elemnt of the stack"),
	TOP("The value of the top element"),
	ISEMPTY("Check if the stack is empty"),
	SIZE("How many elemnts the stack has"),
	QUIT("exit the program"),
	HELP("if you want to see all the commands");

	  private String description;

    private Menu(String description) {
        this.description = description;
    }

    public String getdescription() {
        return description;
    }
}
