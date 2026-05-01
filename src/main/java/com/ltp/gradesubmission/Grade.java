package com.ltp.gradesubmission;
import java.util.Objects;
import java.util.UUID;

public class Grade {
    private String name ;
    private String subject ;
    private String score;
    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public Grade(String name, String subject, String score, String id) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grade name(String name) {
        setName(name);
        return this;
    }

    public Grade subject(String subject) {
        setSubject(subject);
        return this;
    }

    public Grade score(String score) {
        setScore(score);
        return this;
    }

    public Grade id(String id) {
        setId(id);
        return this;
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, subject, score, id);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", score='" + getScore() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

    
}
