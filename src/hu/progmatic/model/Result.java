package hu.progmatic.model;

public abstract class Result {
    private String participant;
    private int raceNumber;
    private String category;
    private String raceTime;
    private int percentage;

    public Result() {

    }

    // NEM NAGY SEGÍTSÉG,
    // MIVEL super()-t csak a leszármazott osztály
    // konstruktorának első sorában lehet hívni
    public Result(String participant, int raceNumber, String category, String raceTime, int percentage) {
        this.participant = participant;
        this.raceNumber = raceNumber;
        this.category = category;
        this.raceTime = raceTime;
        this.percentage = percentage;
    }

    public final String getParticipant() {
        return participant;
    }

    public final void setParticipant(String participant) {
        this.participant = participant;
    }

    public final int getRaceNumber() {
        return raceNumber;
    }

    public final void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public final String getCategory() {
        return category;
    }

    public final void setCategory(String category) {
        this.category = category;
    }

    public final String getRaceTime() {
        return raceTime;
    }

    public final void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public int getHours() {
        String[] parts = raceTime.split(":");
        return Integer.parseInt(parts[0]);
    }

    public int getMinutes() {
        String[] parts = raceTime.split(":");
        return Integer.parseInt(parts[1]);
    }

    public int getSeconds() {
        String[] parts = raceTime.split(":");
        return Integer.parseInt(parts[2]);
    }

    public int getTotalSeconds() {
        return getHours() * 3600 + getMinutes() * 60 + getSeconds();
    }

    public final int getPercentage() {
        return percentage;
    }

    public final void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
