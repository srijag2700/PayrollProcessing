package Project2;
public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateHired() {
        return dateHired;
    }

    @Override
    public String toString() {
        return (name + "::" + department + "::" + dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        Profile profileObj = (Profile) obj;
        if (name.equals(profileObj.getName()) && department.equals(profileObj.getDepartment()) && dateHired.compareTo(profileObj.getDateHired()) == 0) {
            return true;
        }
        return false;
    } //compare name, department and dateHired
}