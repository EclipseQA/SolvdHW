package com.solvd.hospital.person.patient.problem;

public enum Problem {

    SKIN("кожа"),
    SPINE("позвоночник"),
    KIDNEYS("почки"),
    HEAD("голова"),
    THROAT("горло"),
    EARS("ухи"),
    NOSE("нос"),
    TEETH("зубы"),
    EYES("глаза");

    private String problem;

    Problem(String problem){
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

    public static Problem findByName(String name) {
        Problem result = null;
        for (Problem pr : values()) {
            if (pr.toString().equalsIgnoreCase(name)) {
                result = pr;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return problem;
    }
}
