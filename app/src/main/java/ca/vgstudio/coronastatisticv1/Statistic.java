package ca.vgstudio.coronastatisticv1;

public class Statistic {

    private String resultCountry;
    private int resultTCases,
            resultTRecovered,
            resultTDeaths,
            resultNCases,
            resultNDeaths,
            resultACases,
            seriousCases;

    public Statistic(String resultCountry, int resultTCases, int resultTRecovered, int resultTDeaths, int resultNCases, int resultNDeaths, int resultACases, int seriousCases) {

        this.resultCountry = resultCountry;
        this.resultTCases = resultTCases;
        this.resultTRecovered = resultTRecovered;
        this.resultTDeaths = resultTDeaths;
        this.resultNCases = resultNCases;
        this.resultNDeaths = resultNDeaths;
        this.resultACases = resultACases;
        this.seriousCases = seriousCases;
    }

    public String getResultCountry() {
        return resultCountry;
    }

    public void setResultCountry(String resultCountry) {
        this.resultCountry = resultCountry;
    }

    public int getResultTCases() {
        return resultTCases;
    }

    public void setResultTCases(int resultTCases) {
        this.resultTCases = resultTCases;
    }

    public int getResultTRecovered() {
        return resultTRecovered;
    }

    public void setResultTRecovered(int resultTRecovered) {
        this.resultTRecovered = resultTRecovered;
    }

    public int getResultTDeaths() {
        return resultTDeaths;
    }

    public void setResultTDeaths(int resultTDeaths) {
        this.resultTDeaths = resultTDeaths;
    }

    public int getResultNCases() {
        return resultNCases;
    }

    public void setResultNCases(int resultNCases) {
        this.resultNCases = resultNCases;
    }

    public int getResultNDeaths() {
        return resultNDeaths;
    }

    public void setResultNDeaths(int resultNDeaths) {
        this.resultNDeaths = resultNDeaths;
    }

    public int getResultACases() {
        return resultACases;
    }

    public void setResultACases(int resultACases) {
        this.resultACases = resultACases;
    }

    public int getSeriousCases() {
        return seriousCases;
    }

    public void setSeriousCases(int seriousCases) { this.seriousCases = seriousCases; }
}
