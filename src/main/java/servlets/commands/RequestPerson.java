package servlets.commands;

public class RequestPerson {
    public RequestPerson() {
    }
    public RequestPerson(int group) {
        this.group = group;
    }


    public int getGroup() {
        return group;
    }


    int group;

}
