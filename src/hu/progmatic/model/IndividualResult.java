package hu.progmatic.model;

public class IndividualResult extends Result {
    public IndividualResult() {

    }

    public IndividualResult(String line) {
        String[] parts = line.split(";");

        setParticipant(parts[0]);
        setRaceNumber(Integer.parseInt(parts[1]));
        setCategory(parts[2]);
        setRaceTime(parts[3]);
        setPercentage(Integer.parseInt(parts[4]));
    }
}
