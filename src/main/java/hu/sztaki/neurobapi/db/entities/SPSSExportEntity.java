package hu.sztaki.neurobapi.db.entities;

public class SPSSExportEntity {

    private String patientname;
    private String variablename;
    private int week;
    private String value;
    
    SPSSExportEntity(){}

    public String getPatientname() {
        return patientname;
    }

    public String getVariablename() {
        return variablename;
    }

    public int getWeek() {
        return week;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "patientname: " + patientname + " variablename: " + variablename + " week:" + week + " value:" + value;
    }

}
