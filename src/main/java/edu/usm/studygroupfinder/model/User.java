package edu.usm.studygroupfinder.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    
    private String username;
    private String name;
    private String password;
    private Set<Course> courseList;
    private Set<String> groupList;
    
    public User() {
        courseList = new HashSet<>();
        groupList = new HashSet<>();
    }
    
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public Set<Course> getCourseList() { return courseList; }
    public Set<String> getGroupList() { return groupList; }
    
    public void setUsername(String username) { this.username = username; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setCourseList(Set<Course> courseList) { this.courseList = courseList; }
    public void setGroupList(Set<String> groupList) { this.groupList = groupList; }
    
    public boolean addCourse(Course course) {
        if (courseList.contains(course)) { 
            return false; 
        }
        courseList.add(course);
        return true;
    }
    
    public boolean removeCourseById(String id) {
        for (Course course : courseList) {
            if (course.getId().equalsIgnoreCase(id)) {
                courseList.remove(course);
                return true;
            }
        }
        return false;
    }
    
}
