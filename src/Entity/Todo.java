/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author phanh
 */
public class Todo {
    String titles;
    Date deadline;
    Boolean isDone;

    public Todo(String titles, Date deadline, Boolean isDone) {
        this.titles = titles;
        this.deadline = deadline;
        this.isDone = isDone;
    }

    public String getTitles() {
        return titles;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Boolean getIsDone() {
        return isDone;
    }
    
    public String toString(){
        return titles + "|" + deadline + "|" + isDone;
    }
    
    
}
