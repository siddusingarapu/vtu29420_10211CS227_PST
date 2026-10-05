class UndergroundSystem {

    private Map<Integer, String> checkInStation;
    private Map<Integer, Integer> checkInTime;
    private Map<String, double[]> travelData;

    public UndergroundSystem() {
        checkInStation = new HashMap<>();
        checkInTime = new HashMap<>();
        travelData = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id, stationName);
        checkInTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = 
          .get(id);
        int startTime = checkInTime.get(id);

        String route = startStation + "#" + stationName;
        int travelTime = t - startTime;

        if (!travelData.containsKey(route)) {
            travelData.put(route, new double[]{0, 0});
        }

        double[] data = travelData.get(route);
        data[0] += travelTime;
        data[1]++;

        checkInStation.remove(id);
        checkInTime.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;
        double[] data = travelData.get(route);

        return data[0] / data[1];
    }
}

Input/Output
  Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
