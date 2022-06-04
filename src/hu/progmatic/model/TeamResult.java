package hu.progmatic.model;

public class TeamResult extends Result {
    private int teamMembers;

    public TeamResult() {

    }

    public TeamResult(String line) {
        String[] parts = line.split(";");

        setParticipant(parts[0]);
        setRaceNumber(Integer.parseInt(parts[1]));
        setCategory(parts[2]);
        setRaceTime(parts[3]);
        setPercentage(Integer.parseInt(parts[4]));
        this.teamMembers = Integer.parseInt(parts[5]);
    }

    public int getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(int teamMembers) {
        this.teamMembers = teamMembers;
    }
}
