package lsf.java._05_._551_StudentAttendanceRecordI;

public class Solution {

    public boolean checkRecord(String s) {
        return !s.contains("LLL") && (s.indexOf('A') == s.lastIndexOf('A'));
    }

}
